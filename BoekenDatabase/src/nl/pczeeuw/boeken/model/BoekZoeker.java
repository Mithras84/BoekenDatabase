/**
 * 
 */
package nl.pczeeuw.boeken.model;

import java.util.List;

import nl.pczeeuw.boeken.controller.ZoekListener;
import nl.pczeeuw.boeken.model.beans.Boek;
import nl.pczeeuw.boeken.model.beans.Voorraad;
import nl.pczeeuw.boeken.model.db.DAOBoek;
import nl.pczeeuw.boeken.model.db.DAOVoorraad;
import nl.pczeeuw.boeken.model.enums.Locatie;

/**
 * Class description
 * Deze klasse zorgt ervoor dat de juiste informatie naar de view (via de controller) wordt gestuurd.
 * Deze klasse kan alleen boeken ophalen uit de database.
 * Verder dient deze klasse als basis voor de BoekAdmin klasse - die boeken kan toevoegen,
 * updaten en verwijderen - en de BoekBesteller klasse - die voorraad van boeken kan aanpassen -
 * 
 * 
 * @version		1.00 13 aug. 2014
 * @author 		Pieter
 */
public class BoekZoeker implements ZoekListener {    

    @Override
    public List<Boek> getAlleBoeken () {
	return new DAOBoek().getAll();
    }
    

    @Override
    public Boek toonBoek (long isbn) {
	return new DAOBoek().findByISBN(isbn);
    }
    

    @Override
    public List<Boek> vindBoekVanAuteur (String auteur) {
	return new DAOBoek().findByAuteur(auteur);
    }
    

    @Override
    public List<Boek> vindBoekMetTitel (String titel) {
	return new DAOBoek().findByTitle(titel);
    }
    

    @Override
    public Voorraad toonBoekHeleVoorraad (long isbn) {
	return new DAOVoorraad().findByISBN(isbn);
    }
    

    @Override
    public int toonBoekVoorraad(long isbn, Locatie locatie) {	
	return Locatie.getVoorraad(isbn, locatie);
    }

}
