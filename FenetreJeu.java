import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreJeu extends JFrame 
{
	private JPanel grille;
	private JPanel panneau;
	private JPanel menu;
	private Partie partie;
	private ArrayList<Bouton> boutons;
	private ArrayList<ChoixBouton> actions;
	
	public FenetreJeu(int n, int nbEtoiles, boolean ia)
	{		
		panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		grille = new JPanel();
		grille.setLayout(new GridLayout(n,n));

		partie = new Partie(n, nbEtoiles, ia, this); 

		actions = new ArrayList<>();
		
		menu = new JPanel();
		
		menu.setLayout(new GridLayout(7,0));
		panneau.add(menu, BorderLayout.EAST);

		boutons = new ArrayList<>();

		ChoixBouton bColor;
		ChoixBouton bAffComp;
		ChoixBouton bExistChem;
		ChoixBouton bNbCasesMin;
		ChoixBouton bNbEtoiles;
		ChoixBouton bScore;
		ChoixBouton bReliComp;
		
		bColor = new BoutonColorier(boutons, partie);
		bColor.setBackground(partie.getJoueurCourant().getCouleur());
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
		
		Bouton b;
		
		panneau.add(grille, BorderLayout.CENTER);
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				b = new Bouton(partie.getGrille().getCase(i, j), bColor);
				grille.add(b);
				boutons.add(b);
				if(partie.getGrille().getCase(i, j).isaEtoile()) {
					b.setText("*");
					b.setFont(new Font(b.getFont().getFontName(), Font.BOLD, 40));
					b.colorer(partie.getGrille().getCase(i, j).getJoueur());
				}
			}
		}
		
		for (ChoixBouton action: actions)
			action.setActions(actions);
		
		setTitle("Best Game Ever");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panneau);
		setVisible(true);
		pack();
	}

	public ArrayList<Bouton> getBoutons() {
		return boutons;
	}
	
}
