/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class SimpleErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException { }

    @Override
    public void error(SAXParseException exception) throws SAXException { }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException { }

}
