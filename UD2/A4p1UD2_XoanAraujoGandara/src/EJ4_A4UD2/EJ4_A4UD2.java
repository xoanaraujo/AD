package EJ4_A4UD2;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;

/**
 *
 * @author Alberto Paz Pérez
 */
public class EJ4_A4UD2 {

    static final String ARCHIVO_DAT = "Hoteles.dat";
    static final String DOCUMENTO_XML = "Hoteles.xml";

    static EscribirObjeto escritura = new EscribirObjeto(ARCHIVO_DAT);
    static LeerObjeto lectura = new LeerObjeto(ARCHIVO_DAT);

    public static void main(String[] args) throws IOException, TransformerException {
//
//        ArrayList<String> telefonos1 = new ArrayList();
//        telefonos1.add("123456789");
//        telefonos1.add("000000000");
//
//        ArrayList<String> telefonos2 = new ArrayList();
//        telefonos2.add("987654321");
//        telefonos2.add("111111111");
//
//        ArrayList<String> telefonos3 = new ArrayList();
//        telefonos3.add("123459876");
//        telefonos3.add("222222222");
//

//
//        Hotel hotel1 = new Hotel(1, "Gran Hotel", telefonos1, new Direccion("Sol", 2, 36031));
//        addHotel(hotel1);
//
//        Hotel hotel2 = new Hotel(2, "Medio Hotel", telefonos2, new Direccion("Luna", 4, 36601));
//        addHotel(hotel2);
//
//        Hotel hotel3 = new Hotel(3, "Peque Hotel", telefonos3, new Direccion("Noche", 5, 36081));
//        addHotel(hotel3);

        CadenaHotelera cadenaHotelera = new CadenaHotelera("Sol Confort", "AB237237287", new ArrayList<Hotel>());
        introducirHotelesToCadenaHotelera(cadenaHotelera);
        crearXmlHoteles(cadenaHotelera);
    }

    private static void addHotel(Hotel hotel) {
        if (escritura.exists()) {
            escritura.abrirArchivoAdd();
        } else {
            escritura.abrirArchivo();
        }
        escritura.escribirArchivo(hotel);
        escritura.cerrarArchivo();
    }

    private static void introducirHotelesToCadenaHotelera(CadenaHotelera cadenaHotelera) throws IOException {
        if (!lectura.exists()) {
            return;
        }

        lectura.abrirArchivo();
        Hotel hotel;
        try {
            while (true) {
                hotel = (Hotel) lectura.leerObjeto();
                cadenaHotelera.nuevoHotel(hotel);
            }
        } catch (EOFException e) {
            lectura.cerrarArchivo();
        }
    }

    private static void crearXmlHoteles(CadenaHotelera cadenaHotelera) throws IOException {
       JAXBContext contexto = null;
        Marshaller m = null;
        
        try {
            contexto = JAXBContext.newInstance(CadenaHotelera.class);
            m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Writer w = new FileWriter("Hoteles.xml");
            m.marshal(cadenaHotelera, w);
        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println("error al crear el objeto Marshaller");
        }
    }
}
