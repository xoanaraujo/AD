
package util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Alberto Paz P�rez
 */
public class Manejador extends DefaultHandler{

    String nombreEtiqueta = "";
    int contador = 0, numNotaAlumno = 0;
    
    @Override
    public void startDocument() throws SAXException {
        System.out.println("NOTAS");
        System.out.println("==========================");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       nombreEtiqueta = localName;
       if(nombreEtiqueta.equals("nota")) {
            switch(attributes.getValue("valor")) {
                case "9" -> System.out.println("Sobresaliente");
                case "8" -> System.out.println("Notable 8");
                case "7" -> System.out.println("Notable 7");
                case "5" -> System.out.println("Suficiente");
                case "4" -> System.out.println("Insuficiente 4");
            }
        }
    }
    
        @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(nombreEtiqueta.equals("alumno")) {
             System.out.println("\t"+String.valueOf(ch, start, length));
             contador++;
        }
        nombreEtiqueta = "";
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(localName.equals("nota")) {
            System.out.println("Num. de alumnos " + contador);
            System.out.println("-------------------------");
            contador = 0;
        }
    }  

    @Override
    public void endDocument() throws SAXException {

    }
}
