/**
 * 
 */
package nl.pczeeuw.boeken.controller;

import java.util.List;

import nl.pczeeuw.boeken.model.beans.Boek;
import nl.pczeeuw.boeken.model.beans.Voorraad;
import nl.pczeeuw.boeken.model.enums.Locatie;

/**
 * Class description
 * 
 * @version		1.00 14 aug. 2014
 * @author 		Pieter
 */
public interface ZoekListener {

    public abstract List<Boek> getAlleBoeken();

    public abstract Boek toonBoek(long isbn);

    public abstract List<Boek> vindBoekVanAuteur(String auteur);

    public abstract List<Boek> vindBoekMetTitel(String titel);

    public abstract Voorraad toonBoekHeleVoorraad(long isbn);

    public abstract int toonBoekVoorraad(long isbn, Locatie locatie);

}