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
	private ChoixBouton bScore;
	private ChoixBouton bReliComp;
	private BoutonJouer bJouer;
	private Partie partie;
	
	public Fenetre(String titre, int n)
	{		
		panneau = new JPanel();
		panneau.setLayout(new BorderLayout());
		
		grille = new JPanel();
		grille.setLayout(new GridLayout(n,n));

		Bouton b;
		ArrayList<Bouton> boutons = new ArrayList<>();
		panneau.add(grille, BorderLayout.CENTER);
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				b = new Bouton(i,j);
				grille.add(b);
				boutons.add(b);
			}
		}
		//random i et ramdom j --> fait dans grille
		// setText sur case(i,j) = * avec la couleur associée
		
		partie = new Partie(new Joueur(Color.BLUE), new Joueur(Color.RED),n); 
		
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
		bScore = new BoutonScore(boutons, partie);
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

	public ChoixBouton getbScore() {
		return bScore;
	}

	public ChoixBouton getbReliComp() {
		return bReliComp;
	}

	public BoutonJouer getbJouer() {
		return bJouer;
	}
}
