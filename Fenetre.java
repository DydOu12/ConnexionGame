import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame 
{
	private JPanel grille;
	private JPanel panneau;
	private JPanel menu;
	
	public Fenetre(String titre)
	{		
		panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		grille = new JPanel();
		grille.setLayout(new GridLayout(10,10));

		Bouton b;
		ArrayList<Bouton> boutons = new ArrayList<>();
		panneau.add(grille, BorderLayout.CENTER);
		for(int i=0; i<10; ++i)
			for(int j=0; j<10; ++j){
				b = new Bouton(i,j);
				grille.add(b);
				boutons.add(b);
			}
		
		menu = new JPanel();
		menu.setLayout(new GridLayout(8,0));
		panneau.add(menu, BorderLayout.EAST);
		menu.add(new BoutonColorier(boutons));
		menu.add(new JButton("Afficher la composante"));
		menu.add(new JButton("Existence chemin"));
		menu.add(new JButton("Nb cases min sur un chemin"));
		menu.add(new JButton("Nb étoiles pour composante"));
		menu.add(new JButton("Scores"));
		menu.add(new JButton("Relier composantes"));
		menu.add(new JButton("Jeu 2 humains"));

		this.setTitle(titre);
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panneau);
		this.setVisible(true);
	}
}
