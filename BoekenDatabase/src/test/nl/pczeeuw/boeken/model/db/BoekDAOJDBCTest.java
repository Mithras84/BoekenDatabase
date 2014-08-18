/**
 * 
 */
package test.nl.pczeeuw.boeken.model.db;

import static org.junit.Assert.*;

import java.util.List;

import nl.pczeeuw.boeken.model.beans.Boek;
import nl.pczeeuw.boeken.model.db.DAOBoek;
import nl.pczeeuw.boeken.model.db.IBoekDAO;

import org.junit.Before;
import org.junit.Test;

/**
 * Class description
 * 
 * @version		1.00 28 jul. 2014
 * @author 		Pieter
 */
public class BoekDAOJDBCTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testAddBoek() {
	Boek boek = new Boek (1234567891018L, "Boek23", "Schrijver23", 120.01,"Saai", 125);
	IBoekDAO dao = new DAOBoek();
	dao.add(boek);
    }
    
    @Test 
    public void testFindByISBN () {
	Boek boek = new Boek (1234567891018L, "Boek23", "Schrijver23", 120.01,"Saai", 125);
	IBoekDAO dao = new DAOBoek();
	Boek boek2 = dao.findByISBN(1234567891018L);	
	
	assertEquals(boek, boek2);
    }
    
    @Test
    public void testUpdateBoek () {
	Boek boek3 = new Boek (1234567891018L, "Boek23", "Schrijver23", 120.01,"Spannend", 125);
	IBoekDAO dao = new DAOBoek();
	dao.update(boek3);
	Boek boek4 = dao.findByISBN(boek3.getIsbn());
	assertEquals(boek3, boek4);
    }
    
    @Test
    public void testGetAll () {
	IBoekDAO dao = new DAOBoek();
	List <Boek> lijst = dao.getAll();
	for (Boek b : lijst) {
	    System.out.println(b.getAuteur() + " " + b.getTitel());
	}
    }
    
    @Test
    public void testGetBoekByAuteur () {
	IBoekDAO dao = new DAOBoek();
	List <Boek> lijst = dao.findByAuteur("Auteur5");
	for (Boek b : lijst) {
	    System.out.println(b.getAuteur() + " " + b.getTitel());
	}
    }
    
    @Test
    public void testGetBoekByTitel () {
	IBoekDAO dao = new DAOBoek();
	List <Boek> lijst = dao.findByTitle("Titel3");
	for (Boek b : lijst) {
	    System.out.println(b.getAuteur() + " " + b.getTitel());
	}
    }
    
    @Test
    public void testDeleteBoek () {
	IBoekDAO dao = new DAOBoek ();
	dao.delete(1234567891018L);
    }
    

}
