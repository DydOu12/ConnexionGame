import java.awt.Color;
import java.util.ArrayList;


public class Partie {
	private Joueur joueurCourant_;
	private Grille grille_;
	
	public Partie(int n, int nbEtoiles){
		grille_ = new Grille(n, nbEtoiles);
		joueurCourant_ = grille_.getJoueur1();
	}

	public Joueur getJoueurCourant() {
		return joueurCourant_;
	}
	
	public Grille getGrille() {
		return grille_;
	}
	
	public void echangerJoueur () {
		if(joueurCourant_.equals(grille_.getJoueur1()))
		{
			joueurCourant_ = grille_.getJoueur2(); 
		} else 
		{
			joueurCourant_ = grille_.getJoueur1(); 
		}
	}
	
	public void colorerCase(Case c) {
		grille_.colorerCase(c, joueurCourant_);
		echangerJoueur();
	}

	public ArrayList<Case> afficherComposante(Case ca) {
		return grille_.afficherComposante(ca.getClasse());
	}
	
	public boolean existeChemin(Case c1, Case c2){
		return grille_.existeChemin(c1, c2);
	}
	
	public int[] afficheScores () {
		return grille_.afficheScores();
	}
	
	public int getNombreEtoiles(Case c){
		return grille_.getNombreEtoiles(c);
	}
	
	public boolean relieComposantes(Case c) {
		return grille_.relieComposantes(c, joueurCourant_);
	}
	
	public int relierCasesMin(Case case1, Case case2) {
		return grille_.relierCasesMin(case1, case2);
	}
}