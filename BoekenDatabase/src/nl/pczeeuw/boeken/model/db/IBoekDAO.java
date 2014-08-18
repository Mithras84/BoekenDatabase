/**
 * 
 */
package nl.pczeeuw.boeken.model.db;

import java.util.List;

import nl.pczeeuw.boeken.model.beans.Boek;

/**
 * Class description
 * 
 * @version		1.00 28 jul. 2014
 * @author 		Pieter
 */
public interface IBoekDAO {
    
    public void add(Boek boek);
    
    public void delete(long isbn);
    
    public void update(Boek boek);
    
    public Boek findByISBN(long isbn);
    
    public List<Boek> findByTitle(String title);
    
    public List<Boek> findByAuteur(String auteur);
    
    public List<Boek> getAll ();

}
