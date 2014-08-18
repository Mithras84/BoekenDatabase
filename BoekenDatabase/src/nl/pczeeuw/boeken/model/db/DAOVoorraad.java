/**
 * 
 */
package nl.pczeeuw.boeken.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.pczeeuw.boeken.model.beans.Voorraad;

/**
 * Class description
 * 
 * @version		1.00 13 aug. 2014
 * @author 		Pieter
 */
public class DAOVoorraad implements IVoorraadDAO {


    @Override
    public void add(Voorraad voorraad) {
	String sql = "INSERT INTO voorraad VALUES (?,?,?,?)";
	
	try {
	    
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(1, voorraad.getIsbn());
	    ps.setInt(2, voorraad.getVoorraadAmsterdam());
	    ps.setInt(3, voorraad.getVoorraadGroningen());
	    ps.setInt(4, voorraad.getVoorraadUtrecht());
	    
	    ps.executeUpdate();
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    DB.getInstance().disconnect();
	}
	
	
    }


    @Override
    public void delete(long isbn) {
	String sql = "DELETE FROM voorraad WHERE isbn = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(1, isbn);
	    
	    ps.executeUpdate();
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    DB.getInstance().disconnect();
	}
    }


    @Override
    public void update(Voorraad voorraad) {
	String sql = "UPDATE voorraad SET amsterdam = ?, groningen = ?, utrecht = ? WHERE isbn = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(4, voorraad.getIsbn());
	    ps.setInt(1, voorraad.getVoorraadAmsterdam());
	    ps.setInt(2, voorraad.getVoorraadGroningen());
	    ps.setInt(3, voorraad.getVoorraadUtrecht());
	    
	    ps.executeUpdate();
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    DB.getInstance().disconnect();
	}
	
    }


    @Override
    public Voorraad findByISBN(long isbn) {
	Voorraad voorraad = null;
	String sql = "SELECT * FROM voorraad WHERE isbn = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(1, isbn);
	    	    
	    ResultSet res = ps.executeQuery();
	    while (res.next() ) {
		voorraad = new Voorraad ();
		voorraad.setIsbn(res.getLong(1));
		voorraad.setVoorraadAmsterdam(res.getInt(2));
		voorraad.setVoorraadGroningen(res.getInt(3));
		voorraad.setVoorraadUtrecht(res.getInt(4));
		
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("Voorraad niet gevonden!");
	    return null;
	} finally {
	    DB.getInstance().disconnect();
	}
	return voorraad;
    }


    @Override
    public List<Voorraad> getAll() {
	List<Voorraad> lijst = new ArrayList<Voorraad>();
	
	String sql = "SELECT * FROM voorraad";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    
	    ps.executeQuery();
	    ResultSet res = ps.getResultSet();
	    while (res.next()) {
		Voorraad voorraad = new Voorraad ();
		voorraad.setIsbn(res.getLong(1));
		voorraad.setVoorraadAmsterdam(res.getInt(2));
		voorraad.setVoorraadGroningen(res.getInt(3));
		voorraad.setVoorraadUtrecht(res.getInt(4));
		lijst.add(voorraad);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();	    
	} finally {
	    DB.getInstance().disconnect();
	}
	return lijst;
    }

}
