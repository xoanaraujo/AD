package main.util;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXManager {
    public static XMLReader createXmlReader(){
        XMLReader xmlReader;
        String val = "http://xml.org/sax/features/validation";
        String namespaces = "http://xml.org/sax/features/namespaces";
        String esquemas = "http://apache.org/xml/features/validation/schema";
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            if (!xmlReader.getFeature(val))
                xmlReader.setFeature(val, true);
            if (!xmlReader.getFeature(namespaces))
                xmlReader.setFeature(namespaces, true);
            if (!xmlReader.getFeature(esquemas))
                xmlReader.setFeature(esquemas, true);
        } catch (SAXException e) {
            throw new RuntimeException();
        }
        return xmlReader;
    }
}
