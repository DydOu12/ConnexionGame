import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame 
{
	private GridLayout grille;
	private JPanel panneau;
	
	public Fenetre(String titre)
	{
		panneau = new JPanel();
		grille = new GridLayout(10,10);
		panneau.setLayout(grille);
		for(int i=0; i<10; ++i)
			for(int j=0; j<10; ++j)
				panneau.add(new JButton());
		this.setTitle(titre);
		this.setSize(500,500);
		this.setContentPane(panneau);
		this.setVisible(true);
	}
}
