public class Grille 
{
	private Case[][] grille;
	
	public Grille(int n)
	{
		this.grille = new Case[n][n];
		
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)
				this.grille[i][j] = new Case(i,j);
	}
	
	public void colorerCase(int x, int y, Joueur j)
	{
		this.getCase(x,y).setJoueur(j);
	}
	
	public Case getCase(int x, int y)
	{
		return this.grille[x][y];
	}
}
