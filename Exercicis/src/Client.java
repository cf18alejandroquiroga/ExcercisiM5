import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()      { return nif;     }
    public String getNom()      { return nom;     }
    public String getTelefon()  { return telefon; }
    public int getNumLloguers() { return lloguers.size(); }
    public Vector<Lloguer> getLloguers() { return lloguers; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }



    public String informe() {
        return composaCapsalera() +
                composaDetall() +
                composaPeu();
    }

    private double importTotal() {
        double total = 0;
        for (Lloguer lloguer: lloguers) {
            total += lloguer.getPreuFinal();
        }
        return total;
    }

    private int bonificacionsTotals() {
        int bonificacions = 0;
        for (Lloguer lloguer: lloguers) {
            bonificacions += lloguer.bonificacionsDeLloguer();
        }
        return bonificacions;
    }

    private String composaCapsalera() {
        return "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
    }

    private String composaDetall() {
        String detall = "";
        for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            detall += "\t" +
                    lloguer.getVehicle().getMarca() +
                    " " +
                    lloguer.getVehicle().getModel() + ": " +
                    lloguer.getPreuFinal() + "€" + "\n";
        }
        return detall;
    }

    private String composaPeu() {
        return "Import a pagar: " + importTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotals() + "\n";
    }

    public String informeHTML() {
        return composaCapsaleraHTML() +
                composaDetallHTML() +
                composaPeuHTML();
    }



    private String composaCapsaleraHTML() {
        return "<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>" + getNom() + "</em> (<strong>" + getNif() + "</strong>)</p>\n";
    }

    private String composaDetallHTML() {
        String informe = "<table>\n<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     ";
        for(Lloguer lloguer : lloguers) {
            informe +=   "<tr><td>" + lloguer.getVehicle().getMarca() + "</td><td>" + lloguer.getVehicle().getModel() + "</td><td>" + lloguer.getPreuFinal() + "</td></tr>\n";
        }
        informe += "</table>\n";
        return informe;
    }

    private String composaPeuHTML() {
        return "<p>Import a pagar: <em>" + importTotal() + "€</em></p>\n" +
                "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>";
    }
}