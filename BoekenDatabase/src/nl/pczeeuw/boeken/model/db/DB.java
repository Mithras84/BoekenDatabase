/**
 * 
 */
package nl.pczeeuw.boeken.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import nl.pczeeuw.boeken.util.XMLHelper;

/**
 * Class description
 * 
 * @version		1.00 13 aug. 2014
 * @author 		Pieter
 */
public class DB {
    
    private String host;
    private String user;
    private String pass;
    
    private static DB instance;
    private static Connection con;
    
    private DB () {
	System.out.println("Creating DB instance");
	try {
	    XMLHelper helper = new XMLHelper ();
	    host = helper.getHost();
	    user = helper.getUser();
	    pass = helper.getPass();
	} catch (Exception e) {
	    System.out.println("Something went wrong while getting DB info from the XML file");
	    e.printStackTrace();
	}
    }

    /**
     * @return the instance
     */
    public static DB getInstance() {
	if (instance == null) {
	    instance = new DB ();
	}
	return instance;
    }
    
    public Connection getWinkelConnection () {
	connect("winkel");
	return con;
    }
    
    public Connection getBankConnection () {
	connect("bank");
	return con;
    }
    
    private void connect (String dbName) {	
	try {
	    if (con != null) 
		con.close();
	    con = DriverManager.getConnection(host + dbName, user, pass);
	    
	} catch (SQLException e) {
	    System.out.println("Cannot connect to the Database!");
	    e.printStackTrace();
	}
    }
    
    public void disconnect () {	
	try {
	    if (con != null) {
		con.close();
		System.out.println("Connection closed!");
	    }
	} catch (SQLException e) {
	    System.out.println("Cannot close connection!");
	}
    }

}
