package main;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador extends DefaultHandler {

    int contador = 1;

    public Manejador() {
    }

    @Override
    public void startDocument() {
        System.out.println("\nInformacion de actores");
        System.out.println("=============================");
    }

    @Override
    public void endDocument() {
        System.out.println("Total de actores: " + (contador - 1));
        System.out.println("Fin del documento...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("Actor")) {
            System.out.println("Actor " + contador);
            System.out.println("**************");
            contador++;
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + ": " + attributes.getValue(i));
            }

        } else if (!localName.equals("Actores")) {
            System.out.println(localName + ": ");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(String.valueOf(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("Actor")) {
            System.out.println("-----------------------");
        }

    }

}
