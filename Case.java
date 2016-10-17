public class Case 
{
	private int x;
	private int y;
	private Joueur joueur;
	
	public Case(int x, int y, Joueur j)
	{
		this(x,y);
		this.joueur = j;
	}
	
	public Case(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.joueur = null;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
