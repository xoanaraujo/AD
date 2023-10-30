package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MareaManager extends DefaultHandler {

    String nombreEtiqueta;
    SimpleDateFormat formato = new SimpleDateFormat("EEEEEEEEE, dd MMM yyyy");
    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yy");
    String nombrePuerto;
    boolean guardado = false;

    @Override
    public void startDocument() {
        System.out.println("=====================================");
        System.out.println("Taboa de Mareas");
        System.out.println("=====================================");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del documento...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nombreEtiqueta = qName;

        if (uri.equals("Mareas")) {
            if (localName.equals("mareas")) {
                System.out.printf("\testado: %-20shora: "
                                + "%-15saltura: %-6s\n",
                        attributes.getValue("estado"),
                        attributes.getValue("hora"),
                        attributes.getValue("altura"));
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        //Este booleano es para que no se borre el nombre del puerto tras fin de etiqueta
        if (nombreEtiqueta.equals("Mareas:nomePorto") && !guardado) {
            nombrePuerto = String.valueOf(ch, start, length);
            guardado = true;
        } else if (nombreEtiqueta.equals("Mareas:dataPredicion"))
            try {
                System.out.println("Fecha de la prediccion: " + formato.format(fecha.parse(String.valueOf(ch, start, length))) + " Puerto: " + nombrePuerto.toUpperCase());
                guardado = false;
            } catch (ParseException ex) {}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("item")) {
            System.out.println("===========================");
        }

    }
}
