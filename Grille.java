import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Grille 
{
	private Case[][] grille;
//	private ArrayList<Classe> classes;
	
	public Grille(int n)
	{
		this.grille = new Case[n][n];
//		classes = new ArrayList<>();
		
		Case c;
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
			{
				c = new Case(i,j);
				this.grille[i][j] = c;
//				classes.add(new Classe(c));
			}		
	}
	
	public void colorerCase(Case c, Joueur j)
	{
		c.setJoueur(j);

		int xMin;
		int xMax;
		int yMin;
		int yMax;

		// si on se trouve sur la 1ère ligne ou la dernière
		if(c.getX() == 0 || c.getX() == grille.length -1) {
			/* si on est sur la 1ère
			 * le min est la coordonnée de la case
			 * et le max est la case d'en dessous
			 */
			if(c.getX() == 0) {
				xMin = c.getX();
				xMax = c.getX()+1;
			}
			/* si on est sur la dernière
			 * le min est la coordonnée de la case au dessus
			 * et le max est la coordonnée de la case
			 */ 
			else {
				xMin = c.getX()-1;
				xMax = c.getX();
			}
		}
		// sinon, la case ne se trouve pas sur un bord, donc pas de soucis
		else {
			xMin = c.getX()-1;
			xMax = c.getX()+1;
		}
		
		// même idée pour Y
		if(c.getY() == 0 || c.getY() == grille.length -1) {
			if(c.getY() == 0) {
				yMin = c.getY();
				yMax = c.getY()+1;
			} else {
				yMin = c.getY()-1;
				yMax = c.getY();
			}
		} else {
			yMin = c.getY()-1;
			yMax = c.getY()+1;
		}
		
		Case caseActuelle;
		
//		ArrayList<Case> classes = new ArrayList<>();
		Set<Case> classes = new HashSet<>();
		Case nouvelleClasse = c;
		for (int x = xMin; x <= xMax; ++x){
			for (int y = yMin; y <= yMax; ++y){
				caseActuelle = grille[x][y];
				// si x et y sont differents et le joueur est identique
				if(!(x == c.getX() && y == c.getY()) && j.equals(caseActuelle.getJoueur())){

//					if(!c.equals(caseActuelle.getClasse())){
//						caseActuelle.getClasse().setParent(c);
//					}
//					c.ajouterFils(caseActuelle);

					
					if (nouvelleClasse == null) {
						nouvelleClasse = caseActuelle.getClasse();
					} else {
						if (nouvelleClasse.cardinaliteCase() > caseActuelle.getClasse().cardinaliteCase()) {
							classes.add(caseActuelle.getClasse());
						} else {
							classes.add(nouvelleClasse);
							nouvelleClasse = caseActuelle.getClasse();
						}
					}
					System.out.println(caseActuelle);
					System.out.println(caseActuelle.getClasse().cardinaliteCase());
					
				}
			}
		}
		System.out.println(nouvelleClasse);
		for(Case ca : classes) {
			nouvelleClasse.ajouterFils(ca);
			ca.setParent(nouvelleClasse);
		}
		
		if (!c.equals(nouvelleClasse)) {
			nouvelleClasse.ajouterFils(c);
			c.setParent(nouvelleClasse);
		}
	}
	
	public int getTailleGrille(){
		return grille.length;
	}
	
	public Case getCase(int x, int y)
	{
		return this.grille[x][y];
	}
	
	public ArrayList<Case> afficherComposante(Case ca) {
		Case classe = ca.getClasse();
		ArrayList<Case> composante = new ArrayList<>();
		for (Case [] ligne : grille )
			for (Case c : ligne)
				if (c.getClasse().equals(classe))
					composante.add(c);
		return composante;
	}
	
	public boolean existeChemin(Case c1, Case c2){
		return c1.getClasse().equals(c2.getClasse());
	}
}
