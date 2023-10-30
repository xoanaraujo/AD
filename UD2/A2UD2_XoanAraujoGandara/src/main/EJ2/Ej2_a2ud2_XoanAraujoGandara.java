package main.EJ2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import main.MareaManager;
import main.SimpleErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ej2_a2ud2_XoanAraujoGandara {
    static XMLReader analizador;

    public static void main(String[] args) {
        crearSAX();
        verXml();
    }

    private static void crearSAX() {
        try {
            String namespaces = "http://xml.org/sax/features/namespaces";

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

    private static void verXml() {
        try {
            analizador.setContentHandler(new MareaManager());
            analizador.setErrorHandler(new SimpleErrorHandler());

            analizador.parse(new InputSource(new FileInputStream("Mareas.xml")));
        } catch (FileNotFoundException ex) {
        } catch (IOException | SAXException ex) {
        }
    }
}
