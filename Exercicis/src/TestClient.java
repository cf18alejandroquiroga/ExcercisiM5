import org.junit.Test;

import java.text.ParseException;

import static junit.framework.TestCase.assertEquals;

public class TestClient {
    @Test
    public void testClientInforme() throws ParseException {
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

        assertEquals("Informe de lloguers del client Alejandro Quiroga (12345678X)\n" +
                "\tAudi C5: 585.0€\n" +
                "\tLamborgini Murcielago: 180.0€\n" +
                "\tPicapiedra II: 3720.0€\n" +
                "Import a pagar: 4485.0€\n" +
                "Punts guanyats: 3" + "\n", Alex.informe());
    }
}
