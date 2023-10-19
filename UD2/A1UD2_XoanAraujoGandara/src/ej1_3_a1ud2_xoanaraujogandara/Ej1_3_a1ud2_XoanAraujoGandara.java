package ej1_3_a1ud2_xoanaraujogandara;

import exceptions.MyErrorHandler;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ej1_3_a1ud2_XoanAraujoGandara {

    public static void main(String[] args) {
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

    private static void addIds(NodeList empleados){
        for (int i = 0; i < empleados.getLength(); i++) {
            Element element = (Element) empleados.item(i);
            element.setAttribute("id", String.valueOf(i + 1));
        }
    }
}
