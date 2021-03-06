import org.junit.Test;

import java.text.ParseException;

import static junit.framework.TestCase.assertEquals;

public class TestClient {
    @Test
    public void testClientInformeFull() throws ParseException {
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

    @Test
    public void testClientInformeZeroEntries(){
        Client Alex = new Client("12345678X", "Alejandro Quiroga", "666555444");

        assertEquals("Informe de lloguers del client Alejandro Quiroga (12345678X)\n" +
                "Import a pagar: 0.0€\n" +
                "Punts guanyats: 0\n", Alex.informe());
    }

    @Test
    public void testClientInformeZeroDaysRented() throws ParseException {
        Client Alex = new Client("12345678X", "Alejandro Quiroga", "666555444");
        Vehicle CZL1234 = new Vehicle("C5","Audi",Vehicle.Categoria.BASIC);
        Lloguer La0001 = new Lloguer("2/8/2013",0,CZL1234);
        Alex.afegeix(La0001);

        assertEquals("Informe de lloguers del client Alejandro Quiroga (12345678X)\n" +
                "\tAudi C5: 90.0€\n" +
                "Import a pagar: 90.0€\n" +
                "Punts guanyats: 1\n", Alex.informe());
    }

    @Test(expected=NullPointerException.class)
    public void testClientInformeNullEntry() {
        Client Alex = null;
        assertEquals("",Alex.informe());
    }

    @Test
    public void testClientInformeHTMLFull() throws ParseException {
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

        assertEquals("<h1>Informe de lloguers</h1>\n" +
                "<p>Informe de lloguers del client <em>Alejandro Quiroga</em> (<strong>12345678X</strong>)</p>\n" +
                "<table>\n" +
                "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Audi</td><td>C5</td><td>585.0</td></tr>\n" +
                "<tr><td>Lamborgini</td><td>Murcielago</td><td>180.0</td></tr>\n" +
                "<tr><td>Picapiedra</td><td>II</td><td>3720.0</td></tr>\n" +
                "</table>\n" +
                "<p>Import a pagar: <em>4485.0€</em></p>\n" +
                "<p>Punts guanyats: <em>3</em></p>", Alex.informeHTML());
    }
}
