package util;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class TransformerManager {
    public static void transformDocument(String path, String stylesheet, String pathNew){
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        StreamSource stylesheetStreamSource = new StreamSource(stylesheet);
        StreamSource pathStreamSource = new StreamSource(path);

        try {
            transformer = tf.newTransformer(stylesheetStreamSource);
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathNew));
            StreamResult sr = new StreamResult(writer);
            transformer.transform(pathStreamSource, sr);
        } catch (IOException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
