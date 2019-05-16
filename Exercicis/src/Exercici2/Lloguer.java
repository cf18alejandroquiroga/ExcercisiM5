package Exercici2;

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
    public void setDies(int dies) { this.dies = dies;    }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
