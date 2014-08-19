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

    private JFrame zoekFrame;
    private JPanel zoekPanel;    
    private JTextField zoekVeld;
    private JComboBox<String> zoekOpties;
    private JButton zoekKnop;    
    private JButton alleBoekenKnop;    
    private JLabel infoLabel;    
    private JList<Boek> zoekLijst;    
    private DefaultListModel<Boek> result = new DefaultListModel<Boek>();    
    private ZoekListener zoeker;
    
    /**
     * Koppel de controler (zoekListener) aan deze klasse.
     * Maak het frame.
     */
    public void run() {
	setZoekListener ( new BoekZoeker () );
	createFrame();
    }
    
    /**
     * Frame wordt hier aangemaakt, vervolgens worden er functies aangeroepen om het frame inhoud te geven.
     */
    private void createFrame () {
	zoekFrame = new JFrame ("Zoek GUI");
	zoekFrame.setSize(300,300);
	zoekFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	zoekFrame.setVisible(true);
	createContent ();
	zoekFrame.add(zoekPanel);
    }
    
    /**
     * Panel wordt hier aangemaakt met knoppen, combo-boxes, textvelden, etc.
     * ActionListeners worden aan de knoppen verbonden.
     */
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
    
    /**
     * De opties van de combo-box worden hier toegevoegd.
     */
    private void createZoekOpties () {
	zoekOpties = new JComboBox<String>();
	zoekOpties.addItem("ISBN");
	zoekOpties.addItem("Auteur");
	zoekOpties.addItem("Titel");
    }
    
    /**
     * Textveld krijgt een focuslistener in deze functie.
     * Als het textveld aangeklikt wordt moet er geen text worden weergegeven.
     * Als het niet aangeklikt is staat er "Zoekterm hier" in.
     */
    private void createTextveld () {
	zoekVeld = new JTextField ("Zoekterm hier");
	
	zoekVeld.addFocusListener(new FocusListener () {

	    @Override
	    public void focusGained(FocusEvent arg0) {
		zoekVeld.setText("");
	    }

	    @Override
	    public void focusLost(FocusEvent arg0) {
		if (zoekVeld.getText().length() < 1)
		    zoekVeld.setText("Zoekterm hier");
	    }	    
	});
    }
    
    /**
     * Koppen de ZoekListener (in controllers) aan de ZoekBoek klasse in het model.
     * @param listener
     */
    private void setZoekListener (ZoekListener listener) {
	this.zoeker = listener;
    }
    
    /**
     * 
     * Class description
     * Private class om de actionListeners te definieren.
     * @version		1.00 19 aug. 2014
     * @author 		Pieter
     */
    private class ButtonListener implements ActionListener {

	/**
	 * ActionPerformed functie. Als er op een van beide knoppen wordt gedrukt, dan wordt
	 * deze functie aangeroepen.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    //Eerst infoLabel leeg maken.
	    infoLabel.setText("");
	    
	    //Maak de lijst met resultaten leeg.
	    result.clear();
	    
	    //ActionCommand afkomstig van de knop toon alle boeken: Roep controller fucntie aan om alle boeken te tonen.
	    if ( e.getActionCommand().equals("Toon alle boeken") ) {
				
		for (Boek b : zoeker.getAlleBoeken() )  {
		    result.addElement (b);
		}
	    } else if (zoekOpties.getSelectedItem() == "ISBN") {
		//Als zoekopties op ISBN staat, zoek dan op het ingevoerde ISBN nummer in de DB.
		System.out.println("ISBN zoeken selected");
		
		long isbn = checkInputForLong();
		result.addElement( zoeker.toonBoek( isbn ) );		
		
	    } else if (zoekOpties.getSelectedItem() == "Titel") {
		//Als zoekopties op titel staat, zoek dan op titel in de DB.
		System.out.println("Titel zoeken selected");
		result.clear();
		for (Boek b : zoeker.vindBoekMetTitel(zoekVeld.getText() ) )  {
		    result.addElement (b);
		}
	    } else if (zoekOpties.getSelectedItem() == "Auteur") {
		//Als zoekopties op Auteur staat, zoek op auteur in de DB.
		System.out.println("Auteur zoeken selected");
		result.clear();
		for (Boek b : zoeker.vindBoekVanAuteur(zoekVeld.getText() ) )  {
		    result.addElement (b);
		}
	    }
	    
	    //Als er geen resultaten zijn gevonden, laat het infoLabel dan "Geen resultaat" tonen.
	    if (result.isEmpty() || result.get(0) == null) 
		    noResult();
	    
	}
	
	/**
	 * Zet infoLabel op geen resultaat, en laat de zoekterm zien.
	 */
	public void noResult () {
	    infoLabel.setText("Geen resultaat gevonden voor " + zoekVeld.getText());
	}
	
	/**
	 * Korte functie om de NumberFormatException af te vangen als er op ISBN wordt gezocht
	 * en er geen numerieke waarden zijn ingevoerd in het zoekveld.
	 * @return long ISBN
	 */
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
