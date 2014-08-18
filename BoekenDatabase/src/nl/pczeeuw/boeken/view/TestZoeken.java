/**
 * 
 */
package nl.pczeeuw.boeken.view;

import java.util.List;

import nl.pczeeuw.boeken.controller.ZoekListener;
import nl.pczeeuw.boeken.model.BoekZoeker;
import nl.pczeeuw.boeken.model.beans.Boek;

/**
 * Class description
 * 
 * @version		1.00 14 aug. 2014
 * @author 		Pieter
 */
public class TestZoeken {
    ZoekListener zoeker;
    
    public static void main (String[] args) {
	TestZoeken test = new TestZoeken ();
	test.executeTest();
    }
    
    private void executeTest () {
	List<Boek> lijst = zoeker.getAlleBoeken();
	for (Boek b : lijst) {
	    System.out.println(b);
	}
    }
    
    private TestZoeken () {
	setZoekListener (new BoekZoeker () );
    }
    
    private void setZoekListener (ZoekListener listener) {
	this.zoeker = listener;
    }
}
