package main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ManejadorTxt extends DefaultHandler {

    int contador = 1;
    private PrintStream p;

    @Override
    public void startDocument() throws SAXException {
        try {
            p = new PrintStream("Actores.txt");
        } catch (FileNotFoundException ex) {
        }
        p.println("\nInformacion de actores");
        p.println("=============================");
    }

    @Override
    public void endDocument() throws SAXException {
        p.println("Total de actores: " + (contador - 1));
        p.println("Fin del documento...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("Actor")) {
            p.println("Actor " + contador);
            p.println("**************");
            contador++;
            for (int i = 0; i < attributes.getLength(); i++) {
                p.println(attributes.getQName(i) + ": " + attributes.getValue(i));
            }

        } else if (!localName.equals("Actores")) {
            p.print(localName + ": ");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        p.println(String.valueOf(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("Actor")) {
            p.println("-----------------------");
        }
    }

}
