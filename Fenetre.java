import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;


public class Fenetre extends JFrame 
{
	private JPanel grille;
	private JPanel panneau;
	private JPanel menu;
	private Partie partie;
	private ArrayList<Bouton> boutons;
	private ArrayList<ChoixBouton> actions;
	
	public Fenetre(String titre, int n, int nbEtoiles)
	{		
		panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		grille = new JPanel();
		grille.setLayout(new GridLayout(n,n));

		partie = new Partie(n, nbEtoiles); 

		actions = new ArrayList<>();
		
		Bouton b;
		boutons = new ArrayList<>();
		panneau.add(grille, BorderLayout.CENTER);
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				b = new Bouton(partie.getGrille().getCase(i, j));
				b.setText(i+","+j);
				grille.add(b);
				boutons.add(b);
				if(partie.getGrille().getCase(i, j).isaEtoile()) {
					b.setText("*");
					b.setFont(new Font(b.getFont().getFontName(), Font.BOLD, 40));
					b.colorer(partie.getGrille().getCase(i, j).getJoueur());
				}
			}
		}		
		
		menu = new JPanel();
		menu.setLayout(new GridLayout(8,0));
		panneau.add(menu, BorderLayout.EAST);
		
		ChoixBouton bColor;
		ChoixBouton bAffComp;
		ChoixBouton bExistChem;
		ChoixBouton bNbCasesMin;
		ChoixBouton bNbEtoiles;
		ChoixBouton bScore;
		ChoixBouton bReliComp;
		BoutonJouer bJouer;
		
		bColor = new BoutonColorier(boutons, partie);
		menu.add(bColor);
		actions.add(bColor);
		bAffComp = new BoutonAffComp(boutons, partie);
		menu.add(bAffComp);
		actions.add(bAffComp);
		bExistChem = new BoutonExistChem(boutons, partie);
		menu.add(bExistChem);
		actions.add(bExistChem);
		bNbCasesMin = new BoutonNbCasesMin(boutons, partie);
		menu.add(bNbCasesMin);
		actions.add(bNbCasesMin);
		bNbEtoiles = new BoutonNbEtoiles(boutons, partie); 
		menu.add(bNbEtoiles);
		actions.add(bNbEtoiles);
		bScore = new BoutonScore("Scores", partie);
		menu.add(bScore);
		actions.add(bScore);
		bReliComp = new BoutonReliComp(boutons, partie); 
		menu.add(bReliComp);
		actions.add(bReliComp);
		bJouer = new BoutonJouer("Jeu 2 joueurs", actions, boutons, partie, bColor);
		menu.add(bJouer);

		for (ChoixBouton action: actions)
			action.setActions(actions);
		
		setTitle(titre);
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panneau);
		setVisible(true);
	}

}
