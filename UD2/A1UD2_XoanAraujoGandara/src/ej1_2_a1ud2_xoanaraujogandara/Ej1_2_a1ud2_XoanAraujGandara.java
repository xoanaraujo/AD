package ej1_2_a1ud2_xoanaraujogandara;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ej1_2_a1ud2_XoanAraujGandara {

    private static File file = new File("actores.txt");

    public static void main(String[] args) {
        String path = "actores.xml";
        File file = new File(path);
        Document doc = loadDocument(file);
        XmlWithoutRootToTxtFile(doc.getDocumentElement(), -1);
    }

    private static void XmlWithoutRootToTxtFile(Node node, int nParents){
        if (node != node.getOwnerDocument().getDocumentElement()){

            NamedNodeMap attributes;
            StringBuilder atrBuilder = new StringBuilder();
            if (node.hasAttributes()) {
                attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    atrBuilder.append(" ").append(attributes.item(i).getNodeName()).append("=\"").append(attributes.item(i).getNodeValue()).append("\"");
                }
            }
            String name = node.getNodeName().equals("#text") ? "" : "<" + node.getNodeName() + atrBuilder + ">";
            try(BufferedWriter bffWriter = new BufferedWriter(new FileWriter(file, true))){
                bffWriter.write("\t".repeat(nParents) + name + (node.getNodeValue() == null ? "" : node.getNodeValue() + name));
                bffWriter.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (node.hasChildNodes()) {
            NodeList childs = node.getChildNodes();
            for (int i = 0; i < childs.getLength(); i++) {
                XmlWithoutRootToTxtFile(childs.item(i), nParents + 1);
            }
            if (node != node.getOwnerDocument().getDocumentElement())
                try(BufferedWriter bffWriter = new BufferedWriter(new FileWriter(file, true))){
                    bffWriter.write("\t".repeat(nParents) + "</" + node.getNodeName() + ">");
                    bffWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    private static Document loadDocument(File file){
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setNamespaceAware(true);
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(true);
        try {
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            doc = documentBuilder.parse(file);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return doc;
    }
}
