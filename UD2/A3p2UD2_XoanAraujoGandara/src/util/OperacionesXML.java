package util;

import java.io.*;
import org.xml.sax.ContentHandler;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.xml.sax.*;

/**
 *
 * @author Alberto Paz P�rez
 */
public class OperacionesXML {

    static final String JAXP_SCHEMA_LANGUAGE
            = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    //Especifica el espacio de nombres
    static final String W3C_XML_SCHEMA
            = "http://www.w3.org/2001/XMLSchema";

    public static Document crearDocumento(String nombreDoc) throws ParserConfigurationException, DOMException {
        //Crear documento XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        DOMImplementation implementacion = db.getDOMImplementation();
        //Crea el documento con el elemento ra?z nombre pasado por argumentos
        Document doc = implementacion.createDocument(null, nombreDoc, null);
        //Se pueden establecer caracter?sticas al documento xml
        doc.setXmlStandalone(false);
        doc.setXmlVersion("1.1");
        return doc;
    }

    public static Document cargarDocumento(String archivoXML) {
        Document documento = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        dbf.setNamespaceAware(true);
        dbf.setIgnoringComments(true);
        dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);

        try {
            dbf.setIgnoringElementContentWhitespace(true);
            DocumentBuilder constructor = dbf.newDocumentBuilder();
            constructor.setErrorHandler(new SimpleErrorHandler());

            documento = constructor.parse(new File(archivoXML));

            System.out.println("Documento cargado con exito");
        } catch (ParserConfigurationException e) {
            System.err.println("No se ha podido crear una instancia de DocumentBuilder");
        } catch (SAXException e) {
            System.err.println("Error SAX al parsear el archivo");
        } catch (IOException e) {
            System.err.println("Se ha producido un error de entrada salida");
        }

        return documento;
    }

    //Con un atributo
    public static Element addElementoAlFinal(Document documento, String nombreElemento, String nombreAtributo, String valorAtributo) {
        Element elemento = documento.createElement(nombreElemento);
        documento.getDocumentElement().appendChild(elemento);
        addAtributo(documento, elemento, nombreAtributo, valorAtributo);

        return elemento;
    }

    //Sin atributos
    public static Element addElementoAlFinal(Document documento, String nombreElemento) {
        Element elemento = documento.createElement(nombreElemento);
        documento.getDocumentElement().appendChild(elemento);

        return elemento;
    }

    //Con texto
    public static Element addElementoHijo(Document documento, Element elementoPadre, String nombreElemento, String text) {
        Element elementoHijo = documento.createElement(nombreElemento);
        Text texto = documento.createTextNode(text);
        elementoHijo.appendChild(texto);
        elementoPadre.appendChild(elementoHijo);
        return elementoHijo;
    }

    //Sin texto
    public static Element addElementoHijo(Document documento, Element elementoPadre, String nombreElemento) {
        Element elementoHijo = documento.createElement(nombreElemento);

        elementoPadre.appendChild(elementoHijo);
        return elementoHijo;
    }

    public static void addAtributo(Document documento, Element elemento, String nombreAtributo, String valorAtributo) {
        Attr attr = documento.createAttribute(nombreAtributo);
        attr.setValue(valorAtributo);
        elemento.setAttributeNode(attr);
    }

    public static void grabarArbol(Document documento, String nombreDoc) throws IOException, IllegalArgumentException {
        TransformerFactory transFact;
        try {
            transFact = TransformerFactory.newInstance();
            // a�adimos sangrado
            transFact.setAttribute("indent-number", 3);
            Transformer trans;
            try {
                trans = transFact.newTransformer();
                //permitir saltos de l?nea
                trans.setOutputProperty(OutputKeys.INDENT, "yes");
                //no omitir la declaracion xml
                trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

                //Crear fuente de entrada desde el nodo DOM
                DOMSource domSource = new DOMSource(documento);
                //Especificar el destino de la transformacion
                FileWriter fw = new FileWriter(nombreDoc);
                //Escribir todo el arbol en el fichero
                StreamResult sr = new StreamResult(fw);
                //Tambien podemos especificar el destino en la consola
                StreamResult consola = new StreamResult(System.out);

                try {
                    trans.transform(domSource, sr);
                    trans.transform(domSource, consola);

                } catch (TransformerException ex) {
                }

            } catch (TransformerConfigurationException ex) {
                System.out.println("ERROR al construir el motor de transformaci?n ");
            }
        } catch (TransformerFactoryConfigurationError e) {
            System.out.println("ERROR a la hora de implementar la transformaci?n");
        }
    }
    
    public static void visualizarNodosYValores(NodeList nodos) {
        for (int i = 0; i < nodos.getLength(); i++) {
            Node nodo = nodos.item(i);
            obtenerAtributosNodo(nodo);
            if (nodo.hasChildNodes()) {
                NodeList nodosHijos = nodo.getChildNodes();
                visualizarNodosYValores(nodosHijos);
            }

            if (nodo.getNodeValue() != null) {
                System.out.print(nodo.getParentNode().getNodeName()
                        + ": " + nodo.getNodeValue());
            }
        }
        System.out.println();
    }

    public static void obtenerAtributosNodo(Node node) {
        if (node.hasAttributes()) {
            NamedNodeMap atributos = node.getAttributes();
            for (int i = 0; i < atributos.getLength(); i++) {
                System.out.println("<" + atributos.item(i).getNodeName()
                        + ">: " + atributos.item(i).getNodeValue());
            }
        }
    }

    //Aplica una hoja de estilos y lo imprime en un archivo nuevo
    public static void transformarXSLT(String hojaEstilos, String contenidoXML, String nuevo) throws IOException {
        TransformerFactory transFact;
        try {
            //Se instancia el transFact
            transFact = TransformerFactory.newInstance();
            Transformer trans;
            try {
                //La interfaz Source se utiliza tanto para leer el docuemnto XML
                //como el fichero que contiene las hojas de estilo. Se utiliza
                /* un StreamSource , que tiene la capacidad de leer de un
                * Objeto File, un InputStream, un reader o un ID de sistema.*/
                StreamSource estilos = new StreamSource(hojaEstilos);
                StreamSource datos = new StreamSource(contenidoXML);
                /*El TransformerFactory es responsable de crear el transformador
                * aplicado la plantilla objetos. */
                trans = transFact.newTransformer(estilos);
                // creamos fichero para escribir en modo texto
                FileWriter sw = new FileWriter(nuevo);
                // escribimos todo el arbol en el fichero
                StreamResult sr = new StreamResult(sw);
                try {
                    trans.transform(datos, sr);
                } catch (TransformerException ex) {
                }
            } catch (TransformerConfigurationException ex) {
                System.out.println("ERROR al construir el motor de  transformaci�n  ");
            }
        } catch (TransformerFactoryConfigurationError e) {
            System.out.println("ERROR a la hora de implementar la transformaci�n");
        }
    }

    //Aplica una hoja de estilos y lo manda a un manejador SAX
    public static void transformXSLTtoSAX(String hojaEstilos, String contenidoXML) throws IOException {
        TransformerFactory transFact = TransformerFactory.newInstance();
        SAXTransformerFactory saxTransFactory = (SAXTransformerFactory) transFact;
        SAXSource datos = new SAXSource(new InputSource(contenidoXML));
        StreamSource estilos = new StreamSource(hojaEstilos);

        TransformerHandler transHand;
        try {
            transHand = saxTransFactory.newTransformerHandler(estilos);
            ContentHandler manejador = new Manejador();
            Result resultado = new SAXResult(manejador);

            try {
                /*El TransformerFactory es responsable de crear el transformador
                * aplicado la plantilla objetos.*/
                transHand.getTransformer().transform(datos, resultado);

            } catch (TransformerException ex) {
            }
        } catch (TransformerConfigurationException ex) {
            System.out.println("ERROR al construir el motor de  transformaci�n  ");
        }
    }

    //Aplica una hoja de estilos y convierte un documento DOM a SAX
    public static void transformarDOMaSAX(String hojaEstilos, Document documento) {
        //fichero que contiene el documento XML
        TransformerFactory transFact;
        try {
        //Se instancia el TransformerFactory
            transFact = TransformerFactory.newInstance();
            Transformer trans;
            StreamSource estilos = new StreamSource(hojaEstilos);
            DOMSource datos = new DOMSource(documento.getDocumentElement());
            trans = transFact.newTransformer(estilos);

            SAXResult sr = new SAXResult(new Manejador());
            trans.transform(datos, sr);

        } catch (Exception e) {
            System.out.println("ERROR a la hora de implementar la transformaci�n");
        }
    }

}
