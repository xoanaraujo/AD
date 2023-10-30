package main.EJ3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import main.NoticiasManager;
import main.SimpleErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ej3_a2ud2_XoanAraujoGandara {

    static XMLReader analizador;

    public static void main(String[] args) throws FileNotFoundException {
        crearSAX();

        visualizarEnPantallaDatosXML();
    }

    private static void crearSAX() throws FileNotFoundException {
        //Características del analizador
        String namespaces = "http://xml.org/sax/features/namespaces";

        // Creamos el analizador con las características por defecto
        try {
            analizador = XMLReaderFactory.createXMLReader();

            if (analizador.getFeature(namespaces)) {
                System.out.println("Soporta espacios de nombres");
            } else {
                System.out.println("NO soporta espacios de nombres. Se van a establecer");
                analizador.setFeature(namespaces, true);
            }

        } catch (SAXException e) {
        }

    }

    private static void visualizarEnPantallaDatosXML() {
        try {
            analizador.setContentHandler(new NoticiasManager());
            analizador.setErrorHandler(new SimpleErrorHandler());

            // Procesamos el xml de ejemplo
            analizador.parse(new InputSource(new FileInputStream("elpais.xml")));
        } catch (FileNotFoundException ex) {
        } catch (IOException | SAXException ex) {
        }
    }
}
