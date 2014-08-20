/**
 * 
 */
package nl.pczeeuw.boeken.view.kassa;

import javax.swing.JLabel;
import javax.swing.JTextField;

import nl.pczeeuw.boeken.model.beans.Boek;
import nl.pczeeuw.boeken.model.beans.Voorraad;
import nl.pczeeuw.boeken.view.zoeken.BoekInfo;

/**
 * Class description
 * 
 * @version		1.00 20 aug. 2014
 * @author 		Pieter
 */
public class KassaInfo extends BoekInfo {
    
    //Specifieke Labels voor Kassa versie:
    private JLabel voorraadAmsLabel;
    private JLabel voorraadGroLabel;
    private JLabel voorraadUtrLabel;
    
    //Specifieke Velden voor Kassa versie:
    private JTextField voorraadAmsVeld;
    private JTextField voorraadGroVeld;
    private JTextField voorraadUtrVeld; 
	
    private Voorraad voorraad;
    /**
     * @param b
     * @param v
     */
    public KassaInfo(Boek b, Voorraad v) {
	super(b);
	if (v == null) {
	    infoFrame.dispose();
	}
	voorraad = v;
	createVoorraadLabelsEnVelden ();
	addVoorraadLabelsEnVelden();
    }
    
    private void createVoorraadLabelsEnVelden () {
	//Moet aparte functie worden, alleen voor Admins en Kassas!
	voorraadAmsLabel = new JLabel("Voorraad Amsterdam: ");
	voorraadGroLabel = new JLabel("Voorraad Groningen: ");
	voorraadUtrLabel = new JLabel("Voorraad Utrecht: ");
	
	//Moet aparte functie worden in de Admin/Kasse BoekInfo.
	voorraadAmsVeld = new JTextField(String.valueOf(voorraad.getVoorraadAmsterdam()));
	voorraadGroVeld = new JTextField(String.valueOf(voorraad.getVoorraadGroningen()));
	voorraadUtrVeld = new JTextField(String.valueOf(voorraad.getVoorraadUtrecht()));
    }
    
    @Override
    protected void setFieldsEditable(boolean value) {
	super.setFieldsEditable(value);
	voorraadAmsVeld.setEditable(value);
	voorraadGroVeld.setEditable(value);
	voorraadUtrVeld.setEditable(value);
    }

    private void addVoorraadLabelsEnVelden () {
	infoPanel.add(voorraadAmsLabel);
	infoPanel.add(voorraadAmsVeld);
	infoPanel.add(voorraadGroLabel);
	infoPanel.add(voorraadGroVeld);
	infoPanel.add(voorraadUtrLabel);
	infoPanel.add(voorraadUtrVeld);
    }

}
