package main.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMManager {
    public static Document getDocument(String xmlPath){
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setNamespaceAware(true);
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            documentBuilder.setErrorHandler(new MyErrorHandler());
            doc = documentBuilder.parse(xmlPath);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return doc;
    }

    public static void printXml(Node node, int nParents) {
        Document document = node.getOwnerDocument();
        if (node == document.getDocumentElement())
            System.out.println("<?xml version=\"" + document.getXmlVersion() + "\" encoding=\"" + document.getXmlEncoding() + "\"?>");

        NamedNodeMap attributes;
        StringBuilder atrBuilder = new StringBuilder();
        if (node.hasAttributes()) {
            attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                atrBuilder.append(" ").append(attributes.item(i).getNodeName()).append("=\"").append(attributes.item(i).getNodeValue()).append("\"");
            }
        }
        String name = node.getNodeName().equals("#text") ? "" : "<" + node.getNodeName() + atrBuilder + ">";

        System.out.println("\t".repeat(nParents) + name + (node.getNodeValue() == null ? "" : node.getNodeValue() + name));
        if (node.hasChildNodes()) {
            NodeList childs = node.getChildNodes();
            for (int i = 0; i < childs.getLength(); i++) {
                printXml(childs.item(i), nParents + 1);
            }
            System.out.println("\t".repeat(nParents) + "</" + node.getNodeName() + ">");

        }
    }
}
