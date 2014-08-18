/**
 * 
 */
package nl.pczeeuw.boeken.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.pczeeuw.boeken.view.zoeken.ZoekGUI;

/**
 * Class description
 * 
 * @version		1.00 18 aug. 2014
 * @author 		Pieter
 */
public class MainGUI {
    
    JFrame frame;
    JPanel panel;
    
    public static void main (String args[]) {
	MainGUI gui = new MainGUI ();
	gui.makeFrame();

    }
    
    private void makeFrame () {
	frame = new JFrame ("Boeken app");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300, 300);
	frame.setVisible(true);
		
	addButtons();
	
	frame.add(panel);
	frame.pack();
    }
    
    private void addButtons () {
	panel = new JPanel();	
	
	JButton zoek = new JButton ("Zoek GUI");
	zoek.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		ZoekGUI zoekGUI = new ZoekGUI ();
		zoekGUI.run();
	    }	    
	});
	JButton kassa = new JButton ("Kassa GUI");
	JButton admin = new JButton ("Admin GUI");
	
	panel.add(zoek);
	panel.add(kassa);
	panel.add(admin);
	
    }
    
  
}
