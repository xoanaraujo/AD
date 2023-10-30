package main;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticiasManager extends DefaultHandler {

    String nombreEtiqueta = "";
    SimpleDateFormat formato = new SimpleDateFormat("dd-MMMMMMMMMMMMMMMMMM-yyyy");
    SimpleDateFormat fecha = new SimpleDateFormat("dd MMM yyyy");
    boolean empezaronLasNoticias = false;
    int contador = 0;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("=====================================");
        System.out.println("Titular: ULTIMAS NOTICIAS" );

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fin del documento...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nombreEtiqueta = qName;

        if (qName.equals("item")) {
            empezaronLasNoticias = true;
            contador++;
            System.out.println("============ NOTICIA " + contador + " ===============");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (empezaronLasNoticias) {
            switch (nombreEtiqueta) {
                case "title" ->
                        System.out.println("Título: " + String.valueOf(ch, start, length));
                case "dc:creator" ->
                        System.out.println("Autor: " + String.valueOf(ch, start, length));
                case "media:description" ->
                        System.out.println("Descripción: " + String.valueOf(ch, start, length));
                case "pubDate" -> {
                    String fechaEntera = String.valueOf(ch, start, length);
                    String fechaRecortada = fechaEntera.substring(5, fechaEntera.indexOf(" G"));

                    try {
                        String tiempoSucedido = calcularTiempo(fechaRecortada);
                        System.out.println("Fecha de publicación: " + formato.format(fecha.parse(fechaRecortada)) + " , " + tiempoSucedido);

                    } catch (ParseException ex) {

                    }
                }
            }
        }
        nombreEtiqueta = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

    }

    private String calcularTiempo(String fechaRecortada) throws ParseException {
        String diferencia;
        Date ahora = new Date();
        Date fechaNoticia = fecha.parse(fechaRecortada);

        long tiempo = ahora.getTime() - fechaNoticia.getTime();
        //Pasamos la diferencia a días
        long diferenciaDias = tiempo / (24 * 60 * 60 * 1000);

        //Pasamos la diferencia a horas
        long diferenciaHoras = tiempo / (60 * 60 * 1000);

        //Pasamos la diferencia a minutos
        long diferenciaMinutos = tiempo / (60 * 1000);

        //Comprobaciones
        if (diferenciaDias > 1) {
            diferencia = "hace " + diferenciaDias + " días";

        } else if (diferenciaHoras > 1) {
            diferencia = "hace " + diferenciaHoras + " horas";

        } else {
            diferencia = "hace " + diferenciaMinutos + " minutos";
        }

        return diferencia;

    }
}
