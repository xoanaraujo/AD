package ej1_1_a1ud2_xoanaraujogandara;

import org.w3c.dom.*;
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
            doc = docBuilder.parse(new File(ACTORES_XML));


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        System.out.println(doc.getXmlEncoding() + " encoding");

        System.out.println("======================================");
/*
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
        System.out.println("Nobre del nodo: " + nodo.getNodeName() + " Valor del nodo: " + nodo.getNodeValue());
        System.out.println("Se accede al hermano del primer hijo del nodo raiz");
        System.out.println("======================================");

        // 9
        Node elisa = root.getFirstChild();
        NodeList nodos = elisa.getChildNodes();
        System.out.println("<" + elisa.getAttributes().item(0).getNodeName() + ">:" + elisa.getAttributes().item(0).getNodeValue());
        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println("<" + nodos.item(i).getNodeName() + ">" + nodos.item(i).getTextContent());
        }
        System.out.println("======================================");

        // 10
        Node deep = elisa.getNextSibling();
        nodos = deep.getChildNodes();
        System.out.println("<" + deep.getAttributes().item(0).getNodeName() + ">:" + deep.getAttributes().item(0).getNodeValue());
        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println("<" + nodos.item(i).getNodeName() + ">" + nodos.item(i).getTextContent());
        }
        System.out.println("======================================");

        // 11
        Node ford = deep.getNextSibling();
        nodos = ford.getChildNodes();
        System.out.println("<" + ford.getAttributes().item(0).getNodeName() + ">:" + ford.getAttributes().item(0).getNodeValue());
        for (int i = 0; i < nodos.getLength(); i++) {
            System.out.println("<" + nodos.item(i).getNodeName() + ">" + nodos.item(i).getTextContent());
        }
        System.out.println("======================================");

        // 12*/
        printXml(doc.getDocumentElement(), 0);
    }

    private static void readNode(Node node, int nChild, int height, boolean writeOk) {
        if (writeOk) {
            System.out.println("\t".repeat(height) + "-" + node.getNodeName() + ": " + (node.getNodeValue() == null ? "" : node.getNodeValue()));
            NamedNodeMap attributes = node.getAttributes();
            if (attributes != null)
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("\t".repeat(height) + "\t-" + attributes.item(i).getNodeName() + ": " + attributes.item(i).getNodeValue());
                }
        }
        if (node.hasChildNodes() && node.getChildNodes().item(nChild) != null) {
            readNode(node.getChildNodes().item(nChild), 0, height + 1, true);
        } else {
            readNode(node.getParentNode().getParentNode(), nChild + 1, height - 1, false);
        }
    }

    private static void printXml(Node node, int nParents) {
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
