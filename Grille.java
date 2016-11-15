import java.util.ArrayList;

public class Grille 
{
	private Case[][] grille;
	private ArrayList<Classe> classes;
	
	public Grille(int n)
	{
		this.grille = new Case[n][n];
		classes = new ArrayList<>();
		
		Case c;
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
			{
				c = new Case(i,j);
				this.grille[i][j] = c;
				classes.add(new Classe(c));
			}		
	}
	
	public void colorerCase(Case c, Joueur j)
	{
		c.setJoueur(j);
		Classe newClasse = new Classe();
		int i = 0;
		while(i<classes.size())
		{
			if(classes.get(i).caseAutour(c, j))
			{
				newClasse.union(classes.remove(i));
			} else {
				++i;
			}
		}
		classes.add(newClasse);
		//System.out.println(classes);
	}
	
	public int getTailleGrille(){
		return grille.length;
	}
	
	public Case getCase(int x, int y)
	{
		return this.grille[x][y];
	}
	
	public Classe afficherComposante(Case ca) {

		for (Classe c : classes) {
			if(c.possede(ca)) {
				return c;
			}
		}
		return null;
	}
	
	public boolean existeChemin(Case c1, Case c2){
		for(Classe c : classes)
			if(c.possede(c1))
				return c.possede(c2);
		
		return false;
	}
}
