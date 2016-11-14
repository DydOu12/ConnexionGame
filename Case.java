public class Case 
{
	private int x;
	private int y;
	private Joueur joueur;
	private boolean aEtoile;
	
//	public Case(int x, int y, Joueur j)
//	{
//		this(x,y);
//		this.joueur = j;
//		this.aEtoile = true;
//	}
	
	public Case(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.joueur = null;
		aEtoile = false;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) 
	{
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "Case [x=" + x + ", y=" + y + ", joueur=" + joueur + "]";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isaEtoile() {
		return aEtoile;
	}

	public void setaEtoile(boolean aEtoile) {
		this.aEtoile = aEtoile;
	}
	
	
}
