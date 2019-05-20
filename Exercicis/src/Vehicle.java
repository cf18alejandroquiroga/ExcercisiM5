public class Vehicle {

    private Categoria categoria;
    private String model;
    private String marca;

    public enum Categoria {
        BASIC,
        GENERAL,
        LUXE
    }


    public Vehicle(String model, String marca, Categoria categoria){
        this.model = model;
        this.marca = marca;
        this.categoria = categoria;
    }

    public String getMarca() { return marca; }
    public String getModel() { return model; }

    public Categoria getCategoria() { return categoria; }
    public String getCategoria(boolean bool) {
        switch(categoria){
            case BASIC:
                return "basic";
            case GENERAL:
                return "general";
            case LUXE:
                return "luxe";
            default:
                return null;
        }

    }

    //public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModel(String model) { this.model = model; }

}
