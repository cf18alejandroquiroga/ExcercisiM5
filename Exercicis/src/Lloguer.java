import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

    private static final int BONIFICACION_INICIAL_BASIC = 3;
    private static final int BONIFICACION_INICIAL_GENERAL = 4;
    private static final int DIES_PER_BONIFICACION_ADICIONAL_BASIC = 3;
    private static final int DIES_PER_BONIFICACION_ADICIONAL_GENERAL = 2;
    private static final double MULTIPLICADOR_BONIFICACION_BASIC = 1.5;
    private static final double MULTIPLICADOR_BONIFICACION_GENERAL = 2.5;
    private static final double MULTIPLICADOR_BONIFICACION_LUXE = 6;

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

    public double quantitat(){
        double quantitat = 0;
        switch (this.getVehicle().getCategoria()) {
            case BASIC:
                quantitat += BONIFICACION_INICIAL_BASIC;
                if (this.getDies() > DIES_PER_BONIFICACION_ADICIONAL_BASIC) {
                    quantitat += (this.getDies() - DIES_PER_BONIFICACION_ADICIONAL_BASIC) * MULTIPLICADOR_BONIFICACION_BASIC;
                }
                return quantitat;
            case GENERAL:
                quantitat += BONIFICACION_INICIAL_GENERAL;
                if (this.getDies() > DIES_PER_BONIFICACION_ADICIONAL_GENERAL) {
                    quantitat += (this.getDies() - DIES_PER_BONIFICACION_ADICIONAL_GENERAL) * MULTIPLICADOR_BONIFICACION_GENERAL;
                }
                return quantitat;
            case LUXE:
                quantitat += this.getDies() * MULTIPLICADOR_BONIFICACION_LUXE;
                return quantitat;
        }
        return 0;
    }

    public int bonificacionsDeLloguer(){
        // afegeix bonificació per dos dies de lloguer de Luxe
        if (this.getVehicle().getCategoria() == Vehicle.Categoria.LUXE &&
                this.getDies()>1 ) { return 2; }
        else { return 1; }
    }
}
