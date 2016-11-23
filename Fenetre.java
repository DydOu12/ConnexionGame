import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame 
{
	private JPanel grille;
	private JPanel panneau;
	private JPanel menu;
	private ChoixBouton bColor;
	private ChoixBouton bAffComp;
	private ChoixBouton bExistChem;
	private ChoixBouton bNbCasesMin;
	private ChoixBouton bNbEtoiles;
	private BoutonScore bScore;
	private ChoixBouton bReliComp;
	private BoutonJouer bJouer;
	private Partie partie;
	private ArrayList<Bouton> boutons;
	
	public Fenetre(String titre, int n, int nbEtoiles)
	{		
		panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		grille = new JPanel();
		grille.setLayout(new GridLayout(n,n));

		partie = new Partie(n, nbEtoiles); 

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
					b.colorer(partie.getGrille().getCase(i, j).getJoueur());
				}
			}
		}		
		
		menu = new JPanel();
		menu.setLayout(new GridLayout(8,0));
		panneau.add(menu, BorderLayout.EAST);
		bColor = new BoutonColorier(boutons, partie);
		menu.add(bColor);
		bAffComp = new BoutonAffComp(boutons, partie);
		menu.add(bAffComp);
		bExistChem = new BoutonExistChem(boutons, partie);
		menu.add(bExistChem);
		bNbCasesMin = new BoutonNbCasesMin(boutons, partie);
		menu.add(bNbCasesMin);
		bNbEtoiles = new BoutonNbEtoiles(boutons, partie); 
		menu.add(bNbEtoiles);
		bScore = new BoutonScore("Scores", this);
		menu.add(bScore);
		bReliComp = new BoutonReliComp(boutons, partie); 
		menu.add(bReliComp);
		bJouer = new BoutonJouer("Jeu 2 joueurs", this);
		menu.add(bJouer);

		this.setTitle(titre);
		this.setSize(700,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panneau);
		this.setVisible(true);
	}

	public ArrayList<Bouton> getBoutons() {
		return boutons;
	}

	public Partie getPartie() {
		return partie;
	}

	public ChoixBouton getbColor() {
		return bColor;
	}

	public ChoixBouton getbAffComp() {
		return bAffComp;
	}

	public ChoixBouton getbExistChem() {
		return bExistChem;
	}

	public ChoixBouton getbNbCasesMin() {
		return bNbCasesMin;
	}

	public ChoixBouton getbNbEtoiles() {
		return bNbEtoiles;
	}

	public BoutonScore getbScore() {
		return bScore;
	}

	public ChoixBouton getbReliComp() {
		return bReliComp;
	}

	public BoutonJouer getbJouer() {
		return bJouer;
	}
}
