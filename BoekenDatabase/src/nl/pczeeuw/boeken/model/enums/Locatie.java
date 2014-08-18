/**
 * 
 */
package nl.pczeeuw.boeken.model.enums;

import nl.pczeeuw.boeken.model.beans.Voorraad;
import nl.pczeeuw.boeken.model.db.DAOVoorraad;

/**
 * Class description
 * 
 * @version		1.00 18 aug. 2014
 * @author 		Pieter
 */
public enum Locatie {
    
    AMSTERDAM, GRONINGEN, UTRECHT;
    
    
    public static int getVoorraad (long isbn, Locatie locatie) {
	switch (locatie) {
	case AMSTERDAM:
	    return new DAOVoorraad().findByISBN(isbn).getVoorraadAmsterdam();
	case GRONINGEN:
	    return new DAOVoorraad().findByISBN(isbn).getVoorraadGroningen();
	case UTRECHT:
	    return new DAOVoorraad().findByISBN(isbn).getVoorraadUtrecht();
	default:
	    return 0;
	}	
    }
    
    public static void increaseVoorraad (long isbn, Locatie locatie) {
	Voorraad voorraad = new DAOVoorraad().findByISBN(isbn);
	
	switch (locatie) {
	case AMSTERDAM:	    
	    voorraad.setVoorraadAmsterdam(voorraad.getVoorraadAmsterdam() + 1);
	    break;
	case GRONINGEN:
	    voorraad.setVoorraadGroningen(voorraad.getVoorraadGroningen() + 1);
	    break;
	case UTRECHT:
	    voorraad.setVoorraadUtrecht(voorraad.getVoorraadUtrecht() + 1);
	    break;
	default:
	    ;
	}	
    }
    
    public static void decreaseVoorraad (long isbn, Locatie locatie) {
	Voorraad voorraad = new DAOVoorraad().findByISBN(isbn);
	
	switch (locatie) {
	case AMSTERDAM:	    
	    voorraad.setVoorraadAmsterdam(voorraad.getVoorraadAmsterdam() - 1);
	    break;
	case GRONINGEN:
	    voorraad.setVoorraadGroningen(voorraad.getVoorraadGroningen() - 1);
	    break;
	case UTRECHT:
	    voorraad.setVoorraadUtrecht(voorraad.getVoorraadUtrecht() - 1);
	    break;
	default:
	    ;
	}
    }
    
    
}
