import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

    private static final int PREU_INICIAL_BASIC = 3;
    private static final int PREU_INICIAL_REGULAR = 4;
    private static final int PREU_INICIAL_LUXE = 6;
    private static final int DIES_PER_DESCOMPTE_BASIC = 3;
    private static final int DIES_PER_DESCOMPTE_REGULAR = 2;
    private static final double DISCOMPTE_BASIC = 1.5;
    private static final double DISCOMPTE_REGULAR = 2.5;
    private static final int INCREMENT_PREU = 30;


    public Lloguer(String data, int dies, Vehicle vehicle) throws ParseException {
        this.data = dateFormat.parse(data);
        this.dies = dies;
        this.vehicle = vehicle;
    }

    public Date getData() { return data; }
    public int getDies() { return dies; }
    public Vehicle getVehicle() { return vehicle; }

    public void setData(Date data) { this.data = data; }
    public void setDies(int dies) { this.dies = dies; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    private double getPreuRelatiu(){
        double preuRelatiu = 0;
        switch (this.getVehicle().getCategoria()) {
            case BASIC:
                preuRelatiu += PREU_INICIAL_BASIC;
                if (this.getDies() > DIES_PER_DESCOMPTE_BASIC) {
                    preuRelatiu += (this.getDies() - DIES_PER_DESCOMPTE_BASIC) * DISCOMPTE_BASIC;
                }
                return preuRelatiu;
            case GENERAL:
                preuRelatiu += PREU_INICIAL_REGULAR;
                if (this.getDies() > DIES_PER_DESCOMPTE_REGULAR) {
                    preuRelatiu += (this.getDies() - DIES_PER_DESCOMPTE_REGULAR) * DISCOMPTE_REGULAR;
                }
                return preuRelatiu;
            case LUXE:
                preuRelatiu += this.getDies() * PREU_INICIAL_LUXE;
                return preuRelatiu;
        }
        return 0;
    }

    public int bonificacionsDeLloguer(){
        // afegeix bonificació per dos dies de lloguer de Luxe
        if (this.getVehicle().getCategoria() == Vehicle.Categoria.LUXE &&
                this.getDies()>1 ) { return 2; }
        else { return 1; }
    }

    public double getPreuFinal() {
        return getPreuRelatiu() * INCREMENT_PREU;
    }
}
