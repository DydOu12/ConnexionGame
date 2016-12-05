import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grille 
{
	public Case[][] grille_;
	private Joueur joueur1_, joueur2_;
	private ArrayList<Case> casesEtoilesJ1_, casesEtoilesJ2_;
	private HashSet<Case> classes_;
	private int nbEtoiles_;
	
	public Grille(int n, int nbEtoiles, boolean ia)
	{
		grille_ = new Case[n][n];
		classes_ = new HashSet<>();
		joueur1_ = new Joueur(Color.BLUE, "BLEU", false);
		joueur2_ = new Joueur(Color.RED, "ROUGE", ia);
		casesEtoilesJ1_ = new ArrayList<>();
		casesEtoilesJ2_ = new ArrayList<>();
		nbEtoiles_ = nbEtoiles;
		
		Case c;
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
			{
				c = new Case(i,j);
				grille_[i][j] = c;
				classes_.add(c);
			}
		
		placerEtoilesAleatoirement(nbEtoiles);
	}
	
	public void colorerCase(Case c, Joueur j)
	{
		c.setJoueur(j);
		
		ArrayList<Case> casesAutour = casesAutour(c);
		
		Case classeCaseActuelle;
		
		Case nouvelleClasse = c;
		
		Set<Case> classes = new HashSet<>();
		for (Case caseActuelle : casesAutour) {
			// si la case observée à un joueur identique à j
			if(j.equals(caseActuelle.getJoueur())){
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
			if (joueur1_.equals(c.getJoueur()) && scores[0] < nbEtoiles)
				scores[0] = nbEtoiles;
			else if (scores[1] < nbEtoiles)
				scores[1] = nbEtoiles;
		}
		return scores;
	}
	
	public int getNombreEtoiles (Case c) {
		return c.getNombreEtoiles();
	}

	public HashSet<Case> getClasses() {
		return classes_;
	}
	
	
	public void placerEtoilesAleatoirement(int nbEtoile){
		int i = 0;
		Joueur j = joueur1_;
		ArrayList<Case> casesEtoiles = casesEtoilesJ1_;
		
		int x;
		int y;
		Case c;
		
		while (i<2*nbEtoile) {
			// On initialise aléatoirement x et y compris entre 0 et la taille de la grille-1
			x = (int)(Math.random() * getTailleGrille());
			y = (int)(Math.random() * getTailleGrille());
			
			c = grille_[x][y];
			
			// s'il n'y a pas de case de la même couleur autour de la case random
			if(c.getJoueur() == null){
				if(casePlacable(c,j)){
					
					c.setaEtoile(true);
					c.setJoueur(j);
					classes_.add(c);
					casesEtoiles .add(c);
					
					if(i++%2 == 0) {
						j = joueur2_;
						casesEtoiles = casesEtoilesJ2_;
					}
					else {
						j = joueur1_;
						casesEtoiles = casesEtoilesJ1_;
					}
				}
			}			
		}
	}
	
	public boolean casePlacable(Case c, Joueur joueur){
		ArrayList<Case> casesAutour = casesAutour(c);

		for (Case caseObservee : casesAutour) {
				/* 
				 * si la case observée a un joueur égal au joueur qui doit obtenir la nouvelle case et
				 * qu'elle n'est pas égale à la case en paramètre 
				 */
			if(joueur.equals(caseObservee.getJoueur())  && !caseObservee.equals(c))
					return false;
		}
		
		return true;
	}
	
	public ArrayList<Case> casesAutour(Case c){
		int xMin;
		int xMax;
		int yMin;
		int yMax;
		
		ArrayList<Case> cases = new ArrayList<>();

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
		
		for (int x = xMin; x <= xMax; ++x)
			for (int y = yMin; y <= yMax; ++y)
				/* 
				 * si la case observée a un joueur égal au joueur qui doit obtenir la nouvelle case et
				 * qu'elle n'est pas égale à la case en paramètre 
				 */
				if(!c.equals(grille_[x][y]))
					cases.add(grille_[x][y]);

		return cases;
	}
	
	public boolean relieComposantes(Case c, Joueur joueur) {
		ArrayList<Case> casesAutour = casesAutour(c);
		
		Case premiereClasseTrouvee = null;
		Case classe;
		
		for (Case caseObservee : casesAutour) {
			// Classe de la case observée
			classe = caseObservee.getClasse();
				
			/*
			 *  Si le joueur de la case est égal au joueur en paramètre
			 *  et que la classe de la case observée est différente de celles entourant la case cliquée
			 */

			if(joueur.equals(caseObservee.getJoueur()) && !classe.equals(premiereClasseTrouvee)){
				if(premiereClasseTrouvee == null)
					premiereClasseTrouvee = classe;
				else 
					return true;
			}
		}
		return false;
	}
	
	public void relierCasesMin(Case case1, Joueur j) {
		ArrayList<Case> casesAut = casesAutour(case1);
		for(Case c : casesAut){
			if (case1.getDistance() < c.getDistance()) {
				// Joueur de la case null ou joueur identique à j ou 
				// Si la distance de la case observée est supérieure à celle la case c
				if(c.getJoueur() == null ) {
					c.setDistance(case1.getDistance()+1);
					relierCasesMin(c, j);
				// Case avec le même joueur
				} else if (j!=null && j.equals(c.getJoueur())) {
					c.setDistance(case1.getDistance());
					relierCasesMin(c, j);
				} else {
					c.setDistance(-1);
				}
			}
		}
	}
	
	public void initDistCase(Case caseDepart){
		for(Case[] ligne : grille_)
			for(Case c : ligne)
				c.setDistance(Integer.MAX_VALUE);
		caseDepart.setDistance(0);
	}

	public int getNbEtoiles() {
		return nbEtoiles_;
	}

	public boolean casesEtoilesConnectables() {
		for (int i=0; i<nbEtoiles_-1; ++i) {
			initDistCase(casesEtoilesJ1_.get(i));
			relierCasesMin(casesEtoilesJ1_.get(i), joueur1_);
			
			for (int j=i+1; j<nbEtoiles_; ++j) {
				if(casesEtoilesJ1_.get(j).getDistance() > 0 && casesEtoilesJ1_.get(j).getDistance() != Integer.MAX_VALUE)
					return true;
			}
			
			initDistCase(casesEtoilesJ2_.get(i));
			relierCasesMin(casesEtoilesJ2_.get(i), joueur2_);
			for (int j=i+1; j<nbEtoiles_; ++j) {
				if(casesEtoilesJ2_.get(j).getDistance() > 0 && casesEtoilesJ2_.get(j).getDistance() != Integer.MAX_VALUE)
					return true;
			}
		}
		return false;
	}	
	
	public Case colorerCaseIa(Joueur ia){
		int x=0;
		int y=0;
		Case c;
		ArrayList<Case> casesEtoiles;
		if (ia.equals(joueur1_))
			casesEtoiles = casesEtoilesJ1_;
		else
			casesEtoiles = casesEtoilesJ2_;
		
		for(Case ca : casesEtoiles) {
			x += ca.getX();
			y += ca.getY();
		}
		x /= casesEtoiles.size();
		y /= casesEtoiles.size();

		int i = 0;
		int xx = x;
		int yy = y;
		
		int xMax=x;
		int yMax=y;
		
		c = grille_[x][y];

		while (c.getJoueur() != null) {
			
			if (xx+1 > xMax && yy+1 > yMax) {
				
				++i;
				
				// On regarde si x+1 n'est pas en dehors de la grille
				if(x+i<grille_.length)
					xMax = x+i;
				else
					xMax = grille_.length-1;
				// On regarde si y+1 n'est pas en dehors de la grille
				if(y+i<grille_.length)
					yMax = y+i;
				else
					yMax = grille_.length-1;
				
				// On regarde si x-1 n'est pas en dehors de la grille
				if (x-i>=0)
					xx = x-i;
				else 
					xx = 0;
				// On regarde si y+1 n'est pas en dehors de la grille
				if (y-i>=0)
					yy = y-i;
				else 
					yy = 0;
				
			} else if (yy+1 <= yMax) {
				++yy;
			}
			else {
				if (y-i>=0)
					yy = y-i;
				else 
					yy = 0;
				++xx;
			} 
			c = grille_[xx][yy];
		}
		
		return c;
	}
}
