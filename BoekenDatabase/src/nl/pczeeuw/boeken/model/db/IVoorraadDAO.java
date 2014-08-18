/**
 * 
 */
package nl.pczeeuw.boeken.model.db;

import java.util.List;

import nl.pczeeuw.boeken.model.beans.Voorraad;

/**
 * Class description
 * 
 * @version		1.00 13 aug. 2014
 * @author 		Pieter
 */
public interface IVoorraadDAO {
    
    public void add (Voorraad voorraad);
    
    public void delete (long isbn);
    
    public void update (Voorraad voorraad);
    
    public Voorraad findByISBN (long isbn);
    
    public List<Voorraad> getAll ();

}
