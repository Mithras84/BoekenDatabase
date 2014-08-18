/**
 * 
 */
package nl.pczeeuw.boeken.view.zoeken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nl.pczeeuw.boeken.controller.ZoekListener;
import nl.pczeeuw.boeken.model.BoekZoeker;
import nl.pczeeuw.boeken.model.beans.Boek;

/**
 * Class description
 * Simpele GUI om boeken te zoeken die in de DB staan. Deze GUI maakt gebruik van de ZoekListener.
 * 
 * @version		1.00 18 aug. 2014
 * @author 		Pieter
 */
public class ZoekGUI {

    JFrame zoekFrame;
    JPanel zoekPanel;
    
    JTextField zoekVeld;
    JComboBox<String> zoekOpties;
    JButton zoekKnop;
    
    JButton alleBoekenKnop;
    
    JLabel infoLabel;
    
    JList<Boek> zoekLijst;
    
    DefaultListModel<Boek> result = new DefaultListModel<Boek>();
    
    ZoekListener zoeker;
    
    public void run() {
	setZoekListener ( new BoekZoeker () );
	createFrame();
    }
    
    private void createFrame () {
	zoekFrame = new JFrame ("Zoek GUI");
	zoekFrame.setSize(300,300);
	zoekFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	zoekFrame.setVisible(true);
	createContent ();
	zoekFrame.add(zoekPanel);
    }
    
    private void createContent () {
	zoekPanel = new JPanel ();
	
	createZoekOpties ();
	createTextveld ();
	
	ButtonListener btnListener = new ButtonListener ();
	
	zoekKnop = new JButton ("Zoek!");
	zoekKnop.addActionListener(btnListener);
	
	alleBoekenKnop = new JButton ("Toon alle boeken");
	alleBoekenKnop.addActionListener(btnListener);
	
	zoekLijst = new JList<Boek>(result);
	
	infoLabel = new JLabel ();
	
	zoekPanel.add(zoekOpties);
	zoekPanel.add(zoekVeld);
	zoekPanel.add(zoekKnop);
	zoekPanel.add(alleBoekenKnop);
	zoekPanel.add(zoekLijst);
	zoekPanel.add(infoLabel);
    }
    
    private void createZoekOpties () {
	zoekOpties = new JComboBox<String>();
	zoekOpties.addItem("ISBN");
	zoekOpties.addItem("Auteur");
	zoekOpties.addItem("Titel");
    }
    
    private void createTextveld () {
	zoekVeld = new JTextField ("Zoekterm hier");
	
	zoekVeld.addFocusListener(new FocusListener () {

	    @Override
	    public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		zoekVeld.setText("");
	    }

	    @Override
	    public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		if (zoekVeld.getText().length() < 1)
		    zoekVeld.setText("Zoekterm hier");
	    }	    
	});
    }
    
    private void setZoekListener (ZoekListener listener) {
	this.zoeker = listener;
    }
    
    private class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    infoLabel.setText("");
	    if ( e.getActionCommand().equals("Toon alle boeken") ) {
		result.clear();
		for (Boek b : zoeker.getAlleBoeken() )  {
		    result.addElement (b);
		}
	    } else if (zoekOpties.getSelectedItem() == "ISBN") {
		
		result.clear();
		System.out.println("ISBN zoeken selected");
		long isbn = checkInputForLong();
		result.addElement( zoeker.toonBoek( isbn ) );		
		
	    } else if (zoekOpties.getSelectedItem() == "Titel") {
		System.out.println("Titel zoeken selected");
		result.clear();
		for (Boek b : zoeker.vindBoekMetTitel(zoekVeld.getText() ) )  {
		    result.addElement (b);
		}
	    } else if (zoekOpties.getSelectedItem() == "Auteur") {
		System.out.println("Auteur zoeken selected");
		result.clear();
		for (Boek b : zoeker.vindBoekVanAuteur(zoekVeld.getText() ) )  {
		    result.addElement (b);
		}
	    }
	    
	    if (result.isEmpty() || result.get(0) == null) 
		    noResult();
	    
	}
	
	public void noResult () {
	    infoLabel.setText("Geen resultaat gevonden voor " + zoekVeld.getText());
	}
	
	public long checkInputForLong () {
	    try {
		return Long.parseLong(zoekVeld.getText());
	    } catch (NumberFormatException nfe) {
		System.out.println("Alleen numerieke cijfers zijn toegestaan!");
		return 0;
	    }
	}
	
    }
    
}
