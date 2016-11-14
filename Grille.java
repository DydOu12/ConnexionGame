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
	
	public void colorerCase(int x, int y, Joueur j)
	{
		this.getCase(x,y).setJoueur(j);
		Classe newClasse = new Classe();
		for(int i = 0; i<classes.size(); ++i)
		{
			if(classes.get(i).caseAutour(x, y, j))
			{
				newClasse.union(classes.remove(i));
			}
		}
		classes.add(newClasse);
	}
	
	public Case getCase(int x, int y)
	{
		return this.grille[x][y];
	}
}
