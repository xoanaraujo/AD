import org.w3c.dom.*;
import util.DOMManager;

import java.util.ArrayList;

public class Ej1a3ud2_xoanaraujogandara {
    private static final String XML = "BibliotecaInformatica.xml";

    public static void main(String[] args) {
        Document doc = DOMManager.loadDocument(XML);
        NodeList libros = getLibros(doc.getDocumentElement());
        if (libros.getLength() == 0)
            System.err.println("No hay libros");
        else
            for (int i = 0; i < libros.getLength(); i++) {
                printLibro((Element) libros.item(i));
            }
    }

    private static void printLibro(Element item) {
        NamedNodeMap attributes = item.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attr = attributes.item(i);
            System.out.println(attr.getNodeName() + ": " + attr.getNodeValue());
        }
        Element autoresEl = (Element) item.getFirstChild();
        NodeList autoresNl = autoresEl.getElementsByTagName("autor");
        ArrayList<String> autores = new ArrayList<>();
        for (int i = 0; i < autoresNl.getLength(); i++) {
            autores.add(autoresNl.item(i).getFirstChild().getNodeValue());
        }
        System.out.println(autores);

        Element fechaEl = (Element) autoresEl.getNextSibling();
        System.out.println(fechaEl.getNodeName() + ": " + fechaEl.getFirstChild().getNodeValue());

        Element editorialEl = (Element) fechaEl.getNextSibling();
        System.out.println(editorialEl.getNodeName() + ": " + editorialEl.getFirstChild().getNodeValue());


        Element precioEl = (Element) editorialEl.getNextSibling();
        System.out.println(precioEl.getNodeName() + ": " + precioEl.getFirstChild().getNodeValue());

        Element copiasEl = (Element) precioEl.getNextSibling();
        NodeList copiasNl = copiasEl.getElementsByTagName("copia");
        for (int i = 0; i < copiasNl.getLength(); i++) {
            Element copia = (Element) copiasNl.item(i);
            attributes = copia.getAttributes();
            System.out.print("{Numero de copia: " +  attributes.item(1) + " Estado: " + attributes.item(1) + "}");
        }
        System.out.println();
        System.out.println();

    }

    private static NodeList getLibros(Element element) {
        NodeList libros = element.getElementsByTagName("libro");
        return libros;
    }
}
