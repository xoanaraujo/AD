package EJ2_A4UD2;

import CLASES.*;
import java.io.*;
import javax.xml.bind.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Alberto Paz Pérez
 */
public class EJ2_A4UD2 {

    public static void main(String[] args) throws JAXBException {
        Modulo listaContenidos;
        JAXBContext contexto = null;
        Unmarshaller m = null;
        try {
            contexto = JAXBContext.newInstance(Modulo.class);
            m = contexto.createUnmarshaller();
        } catch (JAXBException ex) {
            ex.printStackTrace();
            System.out.println("error al crear el objeto Marshaller");
        }
        File f = new File("modulo.xml");
        listaContenidos = (Modulo) m.unmarshal(f);
        //recorremos el array de contenido
        for (Bloque b : listaContenidos.getContenido()) {
            System.out.println(b.getSesions() + "," + b.getNumero()
            + "," + b.getTitulo() + "," + b.getDescripcion());
        }
    }

}
