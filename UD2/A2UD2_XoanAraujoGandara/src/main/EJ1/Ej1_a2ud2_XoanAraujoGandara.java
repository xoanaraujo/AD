package main.EJ1;

import main.Manejador;
import main.ManejadorTxt;
import main.SimpleErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Ej1_a2ud2_XoanAraujoGandara {

    static XMLReader analizador;

    public static void main(String[] args) {
        crearSAX();

        parseXml(new Manejador());
        parseXml(new ManejadorTxt());
    }

    private static void crearSAX() {
        try {
            String val = "http://xml.org/sax/features/validation";
            String namespaces = "http://xml.org/sax/features/namespaces";
            String esquemas = "http://apache.org/xml/features/validation/schema";

            analizador = XMLReaderFactory.createXMLReader();

            if (analizador.getFeature(val)) {
                System.out.println("Esta activada la validacion");
            } else {
                System.out.println("NO Esta activada la validacion. Se va a establecer");
                analizador.setFeature(val, true);
            }
            if (analizador.getFeature(namespaces)) {
                System.out.println("Soporta espacios de nombres");
            } else {
                System.out.println("NO soporta espacios de nombres. Se van a establecer");
                analizador.setFeature(namespaces, true);
            }

            //Apartado D2
            if (analizador.getFeature(esquemas)) {
                System.out.println("Soporta validacion con esquemas");
            } else {
                System.out.println("NO soporta validación con esquemas. Se va a establecer");
                analizador.setFeature(esquemas, true);
            }
        } catch (SAXException ignored) { }

    }

    private static void parseXml(DefaultHandler handler) {
        try {
            analizador.setContentHandler(handler);
            analizador.setErrorHandler(new SimpleErrorHandler());
            analizador.parse(new InputSource(new FileInputStream("Actores.xml")));
        } catch (IOException | SAXException ignored) {
        }
    }

}
