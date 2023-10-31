package main.ej1_a2rud2_xoanaraujogandara;

import main.model.Actor;
import main.util.DOMManager;
import main.util.SAXManager;
import org.w3c.dom.*;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EJ1_A2RUD2_XoanAraujoGandara {
    public static final String TXT_PATH = "actores.txt";
    public static final String XML_PATH = "actores.xml";
    public static void main(String[] args) {
        updateDate();

    }

    private static void updateDate(){
        Document doc = DOMManager.getDocument(XML_PATH);
        NodeList actorNodes = doc.getElementsByTagName("Actores");
        try(BufferedReader bffReader = new BufferedReader(new FileReader(TXT_PATH))){
            String line;
            int i = 0;
            while((line = bffReader.readLine()) != null){
                String[] data = line.split(",");
                boolean dataOk = true;
                for (int j = 0; j < actorNodes.getLength() && dataOk; j++) {
                    Element actorNode = (Element) actorNodes.item(i);
                    Element dateNode = (Element) actorNode.getElementsByTagName("DataNacemento");
                    Element date = (Element) dateNode.getFirstChild();
                    if (data[0].equals(actorNode.getAttribute("id"))){
                        date.setNodeValue(data[1]);
                        dataOk = false;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DOMManager.printXml(doc.getDocumentElement(), 0);
    }


}
