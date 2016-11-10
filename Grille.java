import java.util.ArrayList;

public class Grille 
{
	private Case[][] grille;
	private ArrayList<Classe> classes;
	
	public Grille(int n)
	{
		this.grille = new Case[n][n];
		
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
		
		for(Classe classe : classes)
		{
			if(classe.caseAutour(x, y, j))
			{
				
			}
		}
	}
	
	public Case getCase(int x, int y)
	{
		return this.grille[x][y];
	}
}
