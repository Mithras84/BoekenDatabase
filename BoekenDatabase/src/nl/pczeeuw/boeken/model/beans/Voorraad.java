/**
 * 
 */
package nl.pczeeuw.boeken.model.beans;

/**
 * Class description
 * Bean for voorraad.
 * @version		1.00 13 aug. 2014
 * @author 		Pieter
 */
public class Voorraad {
    private long isbn;
    private int voorraadAmsterdam;
    private int voorraadGroningen;
    private int voorraadUtrecht;
    
    
    public Voorraad () {
	
    }
    
    /**
     * @return the isbn
     */
    public long getIsbn() {
        return isbn;
    }
    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    /**
     * @return the voorraadAmsterdam
     */
    public int getVoorraadAmsterdam() {
        return voorraadAmsterdam;
    }
    /**
     * @param voorraadAmsterdam the voorraadAmsterdam to set
     */
    public void setVoorraadAmsterdam(int voorraadAmsterdam) {
        this.voorraadAmsterdam = voorraadAmsterdam;
    }
    /**
     * @return the voorraadGroningen
     */
    public int getVoorraadGroningen() {
        return voorraadGroningen;
    }
    /**
     * @param voorraadGroningen the voorraadGroningen to set
     */
    public void setVoorraadGroningen(int voorraadGroningen) {
        this.voorraadGroningen = voorraadGroningen;
    }
    /**
     * @return the voorraadUtrecht
     */
    public int getVoorraadUtrecht() {
        return voorraadUtrecht;
    }
    /**
     * @param voorraadUtrecht the voorraadUtrecht to set
     */
    public void setVoorraadUtrecht(int voorraadUtrecht) {
        this.voorraadUtrecht = voorraadUtrecht;
    }
    
    
}
