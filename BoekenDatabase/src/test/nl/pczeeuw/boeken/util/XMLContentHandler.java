/**
 * 
 */
package test.nl.pczeeuw.boeken.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class description
 * 
 * @version		1.00 12 aug. 2014
 * @author 		Pieter
 */
public class XMLContentHandler extends DefaultHandler {
    
    private String host;
    private String user;
    private String pass;
    
    boolean bHost = false;
    boolean bUser = false;
    boolean bPass = false;
    
    

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    @Override
    public void characters(char[] ch, int start, int length)
	    throws SAXException {
	
	if (bHost) {
	    if (length == 0) 
		host = "";
	    else 
		host = new String (ch, start, length);
	    bHost = false;
	}
	if (bUser) {
	    if (length == 0) 
		user = "";
	    else 
		user = new String (ch, start, length);
	    bUser = false;
	}
	if (bPass) {
	   
	    pass = new String (ch, start, length);
	    if (pass.equals("\n"))
		pass = null;
	    bPass = false;
	}
    }

    @Override
    public void endElement(String uri, String localName, String qName)
	    throws SAXException {
	
    }

    @Override
    public void startElement(String uri, String localName, String qName,
	    Attributes attributes) throws SAXException {
	
	if (qName.equalsIgnoreCase("Url")) {
	    bHost = true;
	} 
	if (qName.equalsIgnoreCase("Username")) {
	    bUser = true;
	} 
	if (qName.equalsIgnoreCase("Password")) {
	    bPass = true;
	}
    }
    
    

}
