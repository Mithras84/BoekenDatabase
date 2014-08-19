/**
 * 
 */
package nl.pczeeuw.boeken.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.pczeeuw.boeken.model.beans.Boek;

/**
 * Class description
 * 
 * @version		1.00 19 aug. 2014
 * @author 		Pieter
 */
public class BoekInfo {
    private JFrame infoFrame;
    private JPanel infoPanel;
    private JLabel titelLabel;
    private JLabel auteurLabel;
    private JLabel ISBNLabel;
    private JLabel paginasLabel;
    private JLabel genreLabel;
    private JLabel prijsLabel;
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
	infoFrame.setSize(300,300);
	infoFrame.setVisible(true);
	infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	infoPanel = new JPanel ();
	createLabels();
	createKnop();
	infoFrame.add(infoPanel);
	infoFrame.pack();
    }
    
    private void createLabels () {
	titelLabel = new JLabel ("Titel: " + boek.getTitel());
	auteurLabel = new JLabel ("Auteur: " + boek.getAuteur());
	ISBNLabel = new JLabel ("ISBN: " + boek.getIsbn());
	paginasLabel = new JLabel ("Aantal pagina's: " + boek.getPaginas());
	genreLabel = new JLabel ("Genre: " + boek.getGenre());
	prijsLabel = new JLabel ("Prijs: $" + boek.getPrijs());
	
	infoPanel.add(titelLabel);
	infoPanel.add(auteurLabel);
	infoPanel.add(ISBNLabel);
	infoPanel.add(paginasLabel);
	infoPanel.add(genreLabel);
	infoPanel.add(prijsLabel);
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
