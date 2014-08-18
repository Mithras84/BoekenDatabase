/**
 * 
 */
package nl.pczeeuw.boeken.model;

import nl.pczeeuw.boeken.controller.KassaListener;
import nl.pczeeuw.boeken.model.beans.Boek;
import nl.pczeeuw.boeken.model.db.DAOBoek;
import nl.pczeeuw.boeken.model.enums.Locatie;

/**
 * Class description
 * 
 * @version		1.00 18 aug. 2014
 * @author 		Pieter
 */
public class BoekKassa extends BoekZoeker implements KassaListener {
    private Locatie locatie;
    private Bestelling bestelling;
    
    public BoekKassa (Locatie locatie) {
	this.locatie = locatie;
    }


    @Override
    public void nieuweBestelling() {
	this.bestelling = new Bestelling (this.locatie);
    }


    @Override
    public void voegToeAanBestelling(long isbn) {
	Boek b = new DAOBoek().findByISBN(isbn);
	
	if (Locatie.getVoorraad(isbn, this.locatie) > 0) {	
	    bestelling.voegToeAanBestelling(b);
	    Locatie.decreaseVoorraad(isbn, this.locatie);
	}
    }


    @Override
    public void verwijderUitBestelling(long isbn) {
	if (bestelling.verwijderUitBestelling(isbn)) {
	    Locatie.increaseVoorraad(isbn, this.locatie);
	}	
    }


    @Override
    public void rekenBestellingAf() {
	// Hier rekening dingen doen.
	
    }
    
    public Locatie getLocatie () {
	return this.locatie;
    }

}
