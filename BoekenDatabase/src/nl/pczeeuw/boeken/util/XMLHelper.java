/**
 * 
 */
package nl.pczeeuw.boeken.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import test.nl.pczeeuw.boeken.util.XMLContentHandler;

/**
 * Class description
 * 
 * @version		1.00 12 aug. 2014
 * @author 		Pieter
 */
public class XMLHelper extends DefaultHandler {
    
    private File file;
    private SAXParser parser;
    private XMLContentHandler handler;
    
    
    public XMLHelper () throws SAXException, IOException, ParserConfigurationException{
	initFile();
	initParser();
	parseFile();
    }
    
    public String getHost () {
	return handler.getHost();
    }
    
    public String getUser () {
	return handler.getUser();
    }
    
    public String getPass () {
	return handler.getPass();
    }
    
    private void parseFile () throws SAXException, IOException {
	InputStream inputStream= new FileInputStream(file);
	Reader reader = new InputStreamReader(inputStream,"UTF-8");	 
	InputSource is = new InputSource(reader);
	is.setEncoding("UTF-8");
	
	handler = new XMLContentHandler();
	parser.parse(is, handler);
    }
    
    private void initParser () throws ParserConfigurationException, SAXException {
	SAXParserFactory fac = SAXParserFactory.newInstance();
	parser = fac.newSAXParser();	
    }
    
    private void initFile () {
	file = new File ("resources/DBConnect.xml");	
    }
}
