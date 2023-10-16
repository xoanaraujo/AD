package ej1_a1ud2_xoanaraujogandara;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ej1_a1ud2_XoanAraujoGandara {

    private static final String ACTORES_XML = "actores.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 1
        System.out.println("Validando: " + dbf.isValidating());
        dbf.setValidating(true);
        System.out.println("Validando: " + dbf.isValidating());
        System.out.println("======================================");
        // 2
        System.out.println("Soporte para espacios de nombre: " + dbf.isNamespaceAware());
        dbf.setNamespaceAware(true);
        System.out.println("Soporte para espacios de nombre: " + dbf.isNamespaceAware());
        System.out.println("======================================");

        // 3
        System.out.println("Ignora comentarios: " + dbf.isIgnoringComments());
        dbf.setIgnoringComments(true);
        System.out.println("Ignora comentarios: " + dbf.isIgnoringComments());
        dbf.setIgnoringElementContentWhitespace(true);
        System.out.println("======================================");
        // 4
        Document doc;
        try {
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            doc = docBuilder.parse(new File( ACTORES_XML));


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        System.out.println(doc.getXmlEncoding() + " encoding");

        System.out.println("======================================");
        // 6
        Node root = doc.getDocumentElement();
        System.out.println("Elemento raíz: " + root.getNodeName());
        System.out.println("Valor elemento raíz: " + root.getNodeValue());
        System.out.println("Numero de hijos: " + root.getChildNodes().getLength());
        System.out.println("======================================");
        // 7
        NodeList hijos = root.getChildNodes();
        System.out.println(root.getTextContent());
        for (int i = 0; i < hijos.getLength(); i++) {
            System.out.println(hijos.item(i).getTextContent());
        }
        System.out.println("======================================");
        // 8
        Node nodo = root.getFirstChild().getNextSibling();
        System.out.println("Nobre del nodo:" +nodo.getNodeName()+ " Valor del nodo:" + nodo.getNodeValue());
        System.out.println("Se accede al hermano del primer hijo del nodo raiz");
        System.out.println("======================================");
        // 9
        Node elisa = root.getFirstChild();
        NodeList nodos = elisa.getChildNodes();
        System.out.println("<" + elisa.getAttributes().item(0).getNodeName() +">:" + elisa.getAttributes().item(0).getNodeValue());
        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println("<" + nodos.item(i).getNodeName() + ">" + nodos.item(i).getTextContent());
        }
        System.out.println("======================================");
        // 10
        Node deep = elisa.getNextSibling();
        nodos = deep.getChildNodes();
        System.out.println("<" + deep.getAttributes().item(0).getNodeName() +">:" + deep.getAttributes().item(0).getNodeValue());
        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println("<" + nodos.item(i).getNodeName() + ">" + nodos.item(i).getTextContent());
        }
        System.out.println("======================================");
        // 11
        
    }
}