import java.awt.Color;
import java.util.ArrayList;


public class Partie {
	private Joueur joueurCourant_;
	private Grille grille;
	
	public Partie(int n, int nbEtoiles){
		grille = new Grille(n, nbEtoiles);
		joueurCourant_ = grille.getJoueur1();
	}

	public Joueur getJoueurCourant() {
		return joueurCourant_;
	}
	
	public Grille getGrille() {
		return grille;
	}
	
	public void echangerJoueur () {
		if(joueurCourant_.equals(grille.getJoueur1()))
		{
			joueurCourant_ = grille.getJoueur2(); 
		} else 
		{
			joueurCourant_ = grille.getJoueur1(); 
		}
	}
	
	public void colorerCase(Case c) {
		grille.colorerCase(c, joueurCourant_);
		echangerJoueur();
	}

	public ArrayList<Case> afficherComposante(Case ca) {
		return grille.afficherComposante(ca.getClasse());
	}
	
	public boolean existeChemin(Case c1, Case c2){
		return grille.existeChemin(c1, c2);
	}
	
	public int[] afficheScores () {
		return grille.afficheScores();
	}
	
}
