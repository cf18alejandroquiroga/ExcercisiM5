package Exercici2;

public class Lloguer {
    private String data;
    private int dies;
    private Vehicle vehicle;

    public Lloguer(String data, int dies, String vehicleModel, String marcaModel, String categoriaModel){
        this.data = data;
        this.dies = dies;
        vehicle = new Vehicle(vehicleModel,marcaModel,categoriaModel);
    }

    public String getData() { return data; }
    public int getDies() { return dies; }
    public Vehicle getVehicle() { return vehicle; }

    public void setData(String data) { this.data = data; }
    public void setDies(int dies) { this.dies = dies;    }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
