/**
 * 
 */
package nl.pczeeuw.boeken.view.zoeken;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nl.pczeeuw.boeken.model.beans.Boek;

/**
 * Class description
 * 
 * @version		1.00 19 aug. 2014
 * @author 		Pieter
 */
public class BoekInfo {
    protected JFrame infoFrame;
    protected JPanel infoPanel;
    //Labels:
    private JLabel titelLabel;
    private JLabel auteurLabel;
    private JLabel ISBNLabel;
    private JLabel paginasLabel;
    private JLabel genreLabel;
    private JLabel prijsLabel;

    //Texfields
    private JTextField titelVeld;
    private JTextField auteurVeld;
    private JTextField ISBNVeld;
    private JTextField paginasVeld;
    private JTextField genreVeld;
    private JTextField prijsVeld;
   
    
    private JButton terugKnop;
    
    private Boek boek;
    
    public BoekInfo (Boek b) {
	if (b == null) {
	    return;
	}
	boek = b;
	createWindow();
    }
    
    private void createWindow() {
	infoFrame = new JFrame (boek.getTitel() + " " + boek.getAuteur());
	infoFrame.setSize(200,300);
	infoFrame.setVisible(true);
	infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	infoPanel = new JPanel ();
	createLabelsAndFields();
	createKnop();
	infoFrame.add(infoPanel);
	setFieldsEditable (false);
    }
    
    private void createLabelsAndFields () {
	titelLabel = new JLabel ("Titel: ");
	auteurLabel = new JLabel ("Auteur: ");
	ISBNLabel = new JLabel ("ISBN: ");
	paginasLabel = new JLabel ("Pagina's: ");
	genreLabel = new JLabel ("Genre: ");
	prijsLabel = new JLabel ("Prijs: $");
	
	titelVeld = new JTextField(boek.getTitel());	
	auteurVeld = new JTextField(boek.getAuteur());
	ISBNVeld = new JTextField(String.valueOf(boek.getIsbn()));
	paginasVeld = new JTextField(String.valueOf(boek.getPaginas()));
	genreVeld = new JTextField(boek.getGenre());
	prijsVeld = new JTextField(String.valueOf(boek.getPrijs()));
	
	addBoekLabelsAndFields();
    }

    /**
     * 
     */
    private void addBoekLabelsAndFields() {
	infoPanel.add(titelLabel);
	infoPanel.add(titelVeld);
	infoPanel.add(auteurLabel);
	infoPanel.add(auteurVeld);
	infoPanel.add(ISBNLabel);
	infoPanel.add(ISBNVeld);
	infoPanel.add(paginasLabel);
	infoPanel.add(paginasVeld);
	infoPanel.add(genreLabel);
	infoPanel.add(genreVeld);
	infoPanel.add(prijsLabel);
	infoPanel.add(prijsVeld);
    }
    
    protected void setFieldsEditable(boolean value) {
	titelVeld.setEditable(value);
	auteurVeld.setEditable(value);
	ISBNVeld.setEditable(value);
	paginasVeld.setEditable(value);
	genreVeld.setEditable(value);
	prijsVeld.setEditable(value);
    }
    
    private void createKnop () {
	terugKnop = new JButton ("Terug");
	terugKnop.addActionListener(new ActionListener () {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		infoFrame.dispose();		
	    }
	    
	});
	
	infoPanel.add(terugKnop);
    }

}
