import java.util.ArrayList;


public class Partie {
	private Joueur joueurCourant_;
	private Grille grille_;
	private Joueur joueurGagnant_;
	
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
		int[] scores = grille_.afficheScores();
		if (scores[0] > 1 || scores[1] > 1) {
			if (scores[0] > scores[1])
				joueurGagnant_ = grille_.getJoueur1();
			else 
				joueurGagnant_ = grille_.getJoueur2();
		}
		System.out.println(joueurGagnant_);
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
		return grille_.getNombreEtoiles(c.getClasse());
	}
	
	public boolean relieComposantes(Case c) {
		return grille_.relieComposantes(c, joueurCourant_);
	}
	
	public int relierCasesMin(Case case1, Case case2) {
		Joueur jCase1 = case1.getJoueur();
		Joueur jCase2 = case2.getJoueur();
		if(jCase1 != null && jCase1.equals(jCase2)) {
			grille_.initDistCase(case1);
			grille_.relierCasesMin(case1, case1.getJoueur());
			return case2.getDistance();
		} else {
			return -2;
		}
	}
	
	public boolean partieFinie() {
		int[] scores = grille_.afficheScores();
		if (scores[0] == grille_.getNbEtoiles() || scores[1] == grille_.getNbEtoiles() || !grille_.casesEtoilesConnectables())
			return true;
		return false;

	}
	public Joueur joueurGagnant() {
		int[] scores = grille_.afficheScores();
		if (scores[0] == grille_.getNbEtoiles())
			return grille_.getJoueur1();
		else if (scores[1] == grille_.getNbEtoiles())
			return grille_.getJoueur2();
		else 
			return joueurGagnant_;
	}
	
}