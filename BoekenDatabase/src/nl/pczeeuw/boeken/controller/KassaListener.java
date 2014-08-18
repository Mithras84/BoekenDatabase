/**
 * 
 */
package nl.pczeeuw.boeken.controller;


/**
 * Class description
 * 
 * @version		1.00 18 aug. 2014
 * @author 		Pieter
 */
public interface KassaListener extends ZoekListener{
    
    public void nieuweBestelling ();
    
    public void voegToeAanBestelling (long isbn);
    
    public void verwijderUitBestelling (long isbn);
    
    public void rekenBestellingAf ();
}
