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

import nl.pczeeuw.boeken.model.beans.Boek;

/**
 * Class description
 * Data Access Object.
 * Create, Read, Update, Delete - methods for 'boek' transfer objects @see Boek.
 * @version		1.00 28 jul. 2014
 * @author 		Pieter
 */
public class DAOBoek implements IBoekDAO {

   
    @Override
    public void add(Boek boek) {
	
	String sql = "INSERT INTO boek VALUES (?,?,?,?,?,?)";
	
	try {
	    
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(1, boek.getIsbn());
	    ps.setString(2 , boek.getTitel());
	    ps.setString(3, boek.getAuteur());
	    ps.setDouble(4, boek.getPrijs());	   
	    ps.setString(5, boek.getGenre());
	    ps.setInt(6, boek.getPaginas());
	    
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
	
	String sql = "DELETE FROM boek WHERE isbn = ?";
	
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
    public void update(Boek boek) {
	
	String sql = "UPDATE boek SET titel = ?, auteur = ?, prijs = ?, genre = ?, paginas = ? WHERE isbn = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(6, boek.getIsbn());
	    ps.setString(1 , boek.getTitel());
	    ps.setString(2, boek.getAuteur());
	    ps.setDouble(3, boek.getPrijs());	   
	    ps.setString(4, boek.getGenre());
	    ps.setInt(5, boek.getPaginas());
	    
	    ps.executeUpdate();
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    DB.getInstance().disconnect();
	}
	
    }

    
    @Override
    public Boek findByISBN(long isbn) {
	
	Boek boek = null;
	String sql = "SELECT * FROM boek WHERE isbn = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setLong(1, isbn);
	    	    
	    ResultSet res = ps.executeQuery();
	    while (res.next() ) {
		boek = new Boek ();
		boek.setIsbn(res.getLong(1));
		boek.setTitel(res.getString(2));
		boek.setAuteur(res.getString(3));
		boek.setPrijs(res.getDouble(4));
		boek.setGenre(res.getString(5));
		boek.setPaginas(res.getInt(6));
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    System.out.println("Boek niet gevonden!");
	    return null;	    
	} finally {
	    DB.getInstance().disconnect();
	}
	return boek;
    }

    
    @Override
    public List<Boek> findByTitle(String title) {
	
	List<Boek> boeken = new ArrayList<Boek>();
	String sql = "SELECT * FROM boek WHERE titel = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, title);
	    
	    ps.executeQuery();
	    ResultSet res = ps.getResultSet();
	    while (res.next()) {
		Boek boek = new Boek ();
		boek.setIsbn(res.getLong(1));
		boek.setTitel(res.getString(2));
		boek.setAuteur(res.getString(3));
		boek.setPrijs(res.getDouble(4));
		boek.setGenre(res.getString(5));
		boek.setPaginas(res.getInt(6));
		boeken.add( boek );
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    
	} finally {
	    DB.getInstance().disconnect();
	}
	return boeken;
    }

   
    @Override
    public List<Boek> findByAuteur(String auteur) {
	
	List<Boek> boeken = new ArrayList<Boek>();
	String sql = "SELECT * FROM boek WHERE auteur = ?";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, auteur);
	    
	    ps.executeQuery();
	    ResultSet res = ps.getResultSet();
	    while (res.next()) {
		Boek boek = new Boek ();
		boek.setIsbn(res.getLong(1));
		boek.setTitel(res.getString(2));
		boek.setAuteur(res.getString(3));
		boek.setPrijs(res.getDouble(4));
		boek.setGenre(res.getString(5));
		boek.setPaginas(res.getInt(6));
		boeken.add( boek );
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    
	} finally {
	    DB.getInstance().disconnect();
	}
	return boeken;
    }

    
    @Override
    public List<Boek> getAll() {
	List<Boek> boeken = new ArrayList<Boek>();
	String sql = "SELECT * FROM boek";
	
	try {
	    Connection con = DB.getInstance().getWinkelConnection();
	    
	    PreparedStatement ps = con.prepareStatement(sql);
	    
	    ps.executeQuery();
	    ResultSet res = ps.getResultSet();
	    
	    while (res.next()) {
		Boek boek = new Boek ();
		boek.setIsbn(res.getLong(1));
		boek.setTitel(res.getString(2));
		boek.setAuteur(res.getString(3));
		boek.setPrijs(res.getDouble(4));
		boek.setGenre(res.getString(5));
		boek.setPaginas(res.getInt(6));
		boeken.add( boek );
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    
	} finally {
	    DB.getInstance().disconnect();
	}
	return boeken;
    }

}
