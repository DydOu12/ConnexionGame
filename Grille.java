import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grille 
{
	private Case[][] grille_;
	private Joueur joueur1_;
	private Joueur joueur2_;
	private HashSet<Case> classes_;
	
	public Grille(int n, int nbEtoiles)
	{
		grille_ = new Case[n][n];
		classes_ = new HashSet<>();
		joueur1_ = new Joueur(Color.BLUE);
		joueur2_ = new Joueur(Color.RED);
		
		Case c;
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
			{
				c = new Case(i,j);
				this.grille_[i][j] = c;
			}
		
		placerEtoilesAleatoirement(nbEtoiles);
	}
	
	public void colorerCase(Case c, Joueur j)
	{
		c.setJoueur(j);
		
		int[] coordonneesAutourCase = caseAutour(c);
		int xMin = coordonneesAutourCase[0];
		int xMax = coordonneesAutourCase[1];
		int yMin = coordonneesAutourCase[2];
		int yMax = coordonneesAutourCase[3];
		
		Case caseActuelle;
		Case classeCaseActuelle;
		
		Case nouvelleClasse = c;
		
		Set<Case> classes = new HashSet<>();
		for (int x = xMin; x <= xMax; ++x){
			for (int y = yMin; y <= yMax; ++y){
				caseActuelle = grille_[x][y];
				// si x et y sont differents et le joueur est identique
				if(!(x == c.getX() && y == c.getY()) && j.equals(caseActuelle.getJoueur())){
					classeCaseActuelle = caseActuelle.getClasse();
					
					// Si la classe que l'on possède déjà est différente à celle que l'on va comparer
					if (!classeCaseActuelle.equals(nouvelleClasse)) {
						// Si la cardinalite de la classe de la case que l'on observe est superieure à nouvelleClasse 
						if (classeCaseActuelle.cardinaliteCase() > nouvelleClasse.cardinaliteCase()) {
							classes.add(nouvelleClasse);
							nouvelleClasse = classeCaseActuelle;
						} else {
							classes.add(classeCaseActuelle);
						}
					}
				}
			}
		}
		
		/*
		 *  Met en racine la classe (case) avec la plus grosse cardinalite et 
		 *	enlève les anciennes classes fusionnées avec la nouvelle
		*/
		for(Case ca : classes) {
			ca.setParent(nouvelleClasse);
			classes_.remove(ca);
		}
		
		if (!c.equals(nouvelleClasse)) {
			c.setParent(nouvelleClasse);
		}
		
		classes_.add(nouvelleClasse);
	}
	
	public int getTailleGrille(){
		return grille_.length;
	}
	
	public Joueur getJoueur1() {
		return joueur1_;
	}

	public Joueur getJoueur2() {
		return joueur2_;
	}

	public Case getCase(int x, int y)
	{
		return this.grille_[x][y];
	}
	
	public ArrayList<Case> afficherComposante(Case ca) {
		ArrayList<Case> composante = new ArrayList<>();
		composante.add(ca);
		for (Case fils : ca.getFils())
				composante.addAll(afficherComposante(fils));
		return composante;
	}
	
	public boolean existeChemin(Case c1, Case c2){
		return c1.getClasse().equals(c2.getClasse());
	}
	
	public int[] afficheScores() {
		int[] scores = new int[2];
		int nbEtoiles;
		
		for(Case c : classes_) {
			nbEtoiles = c.getNombreEtoiles();
			if (joueur1_.equals(c.getJoueur()) && scores[0] < nbEtoiles) {
				scores[0] = nbEtoiles;
			} else if (scores[1] < nbEtoiles){
				scores[1] = nbEtoiles;
			}
		}
		return scores;
	}

	public HashSet<Case> getClasses() {
		return classes_;
	}
	
	
	public void placerEtoilesAleatoirement(int nbEtoile){
		int i = 0;
		Joueur j = joueur1_;
		
		int x;
		int y;
		Case c;
		
		while (i<2*nbEtoile) {
			// On initialise aléatoirement x et y compris entre 0 et la taille de la grille-1
			x = (int)(Math.random() * getTailleGrille());
			y = (int)(Math.random() * getTailleGrille());
			
			c = grille_[x][y];
			
			// s'il n'y a pas de case de la même couleur autour de la case random
			if(casePlacable(c,j)){
				if(c.getJoueur() == null){
					
					c.setaEtoile(true);
					c.setJoueur(j);
					classes_.add(c);
					
					if(i++%2 == 0)
						j = joueur2_;
					else 
						j = joueur1_;				
				}
			}			
		}
	}
	
	public boolean casePlacable(Case c, Joueur joueur){
		int[] caseAutour = caseAutour(c);
		int xMin = caseAutour[0];
		int xMax = caseAutour[1];
		int yMin = caseAutour[2];
		int yMax = caseAutour[3];
		
		for (int x = xMin; x <= xMax; ++x){
			for (int y = yMin; y <= yMax; ++y){
				/* 
				 * si la case observée a un joueur égal au joueur qui doit obtenir la nouvelle case et
				 * qu'elle n'est pas égale à la case en paramètre 
				 */
				if(joueur.equals(grille_[x][y].getJoueur())  && !grille_[x][y].equals(c))
					return false;
			}
		}
		return true;
	}
	
	public int[] caseAutour(Case c){
		int xMin;
		int xMax;
		int yMin;
		int yMax;

		/* si on est sur la 1ère
		 * le min est la coordonnée de la case
		 * et le max est la case d'en dessous
		 */
		if(c.getX() == 0) {
				xMin = c.getX();
				xMax = c.getX()+1;
		} 
		/* snon si on est sur la dernière
		 * le min est la coordonnée de la case au dessus
		 * et le max est la coordonnée de la case
		 */ 
		else if(c.getX() == grille_.length-1){
			xMin = c.getX()-1;
			xMax = c.getX();
		}
		// sinon, la case ne se trouve pas sur un bord, donc pas de soucis
		else {
			xMin = c.getX()-1;
			xMax = c.getX()+1;
		}
		
		// même idée pour Y
		if(c.getY() == 0 ) {
			yMin = c.getY();
			yMax = c.getY()+1;
		} else if(c.getY() == grille_.length -1){
			yMin = c.getY()-1;
			yMax = c.getY();
		} else {
			yMin = c.getY()-1;
			yMax = c.getY()+1;
		} 
		
		int[] coordonneesAutourCase = new int[4];
		coordonneesAutourCase[0] = xMin;
		coordonneesAutourCase[1] = xMax;
		coordonneesAutourCase[2] = yMin;
		coordonneesAutourCase[3] = yMax;
		
		return coordonneesAutourCase;
	}
	
	public int cardinaliteClasse(Case c){
		int i = 1;
		for(Case[] ligne: grille_)
			for(Case ca: ligne)
				if(c.equals(ca.getParent())){
					i+= cardinaliteClasse(ca);
				}
		return i;
	}
	
	public int nombreEtoilesClasse(Case c) {
		int i = 0;
		
		if(c.isaEtoile())
			++i;
		
		for(Case[] ligne: grille_)
			for(Case ca: ligne)
				if(c.equals(ca.getParent()))
					i += nombreEtoilesClasse(ca);
		return i;
	}
	
}
