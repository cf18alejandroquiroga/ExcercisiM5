import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lloguer {
    private Date data;
    private int dies;
    private Vehicle vehicle;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

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
                quantitat += 3;
                if (this.getDies() > 3) {
                    quantitat += (this.getDies() - 3) * 1.5;
                }
                return quantitat;
            case GENERAL:
                quantitat += 4;
                if (this.getDies() > 2) {
                    quantitat += (this.getDies() - 2) * 2.5;
                }
                return quantitat;
            case LUXE:
                quantitat += this.getDies() * 6;
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
