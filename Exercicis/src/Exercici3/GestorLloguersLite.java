package Exercici3;

import Exercici2.Client;
import Exercici2.Lloguer;
import Exercici2.Vehicle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

    static String showInfo(Client client){
        int numLloguers = client.getNumLloguers();
        String info;
        info = "Client:\t" + client.getNom() + "\n" +
                "\t\t" + client.getNif() + "\n" +
                "\t\t" + client.getTelefon() + "\n" +
                "Lloguers: " + numLloguers;
        for(int i = 0; i < numLloguers; i++) {
            String marca = client.getLloguers().get(i).getVehicle().getMarca();
            String model = client.getLloguers().get(i).getVehicle().getModel();
            Date dataInici = client.getLloguers().get(i).getData();
            int diesLlogats = client.getLloguers().get(i).getDies();

            info += "\n" +
                    "\t   " + (i + 1) + ". vehicle: " + marca + " " + model + "\n" +
                    "\t\t  data d'inici: " + dateFormat.format(dataInici) + "\n" +
                    "\t\t  dies llogats: " + diesLlogats + "\n";
        }

        return info;
    }

    public static void main(String[] args) throws ParseException {

        Client Alex = new Client("12345678X", "Alejandro Quiroga", "666555444");
        Vehicle CZL1234 = new Vehicle("C5","Audi",Vehicle.Categoria.BASIC);
        Vehicle RMP2345 = new Vehicle("Murcielago", "Lamborgini",Vehicle.Categoria.LUXE);
        Vehicle SPL3456 = new Vehicle("II","Picapiedra",Vehicle.Categoria.GENERAL);
        Lloguer La0001 = new Lloguer("2/8/2013",14,CZL1234);
        Lloguer La0002 = new Lloguer("5/9/2019",1,RMP2345);
        Lloguer La0003 = new Lloguer("1/1/2000",50,SPL3456);
        Alex.afegeix(La0001);
        Alex.afegeix(La0002);
        Alex.afegeix(La0003);

        System.out.print(showInfo(Alex));
    }
}
