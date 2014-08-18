/**
 * 
 */
package nl.pczeeuw.boeken.model;

import java.util.ArrayList;
import java.util.List;

import nl.pczeeuw.boeken.model.beans.Boek;
import nl.pczeeuw.boeken.model.enums.Locatie;

/**
 * Class description
 * 
 * @version		1.00 18 aug. 2014
 * @author 		Pieter
 */
public class Bestelling {
    private static int VOLG_NUMMER;
    
    private List<Boek> boekenLijst;
    private Locatie locatie;
    private long totaalPrijs;
    
    
    
    public Bestelling (Locatie locatie) {
	VOLG_NUMMER ++;
	this.locatie = locatie;
	boekenLijst = new ArrayList<Boek>();
    }
    
    public void voegToeAanBestelling (Boek b) {
	boekenLijst.add(b);
    }
    
    public boolean verwijderUitBestelling (long isbn) {
	for (Boek b : boekenLijst) {
	    if (b.getIsbn() == isbn) {
		boekenLijst.remove(b);
		System.out.println("Boek " + b.getTitel() + " verwijdert uit bestelling");
		return true;
	    }
	}
	System.out.println("Boek niet gevonden in de bestelling");
	return false;
    }
    
    public long getTotaalPrijs () {
	totaalPrijs = 0;
	for (Boek b : boekenLijst) {
	    totaalPrijs += b.getPrijs();
	}
	return totaalPrijs;
    }
    
    public Locatie getLocatie () {
	return this.locatie;
    }
    
    public int getVolgNummer () {
	return Bestelling.VOLG_NUMMER;
    }

}
