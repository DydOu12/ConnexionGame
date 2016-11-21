import java.util.ArrayList;

public class Case
{
	private int x;
	private int y;
	private Joueur joueur;
	private boolean aEtoile;
	private Case parent;
	private ArrayList<Case> fils;

	public Case(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.joueur = null;
		aEtoile = false;
		parent = null;
		fils = new ArrayList<>();
	}

	public Case getParent() {
		return parent;
	}

	public void setParent(Case parent) {
		this.parent = parent;
	}
	
	public void ajouterFils(Case c){
		fils.add(c);
	}
	
	public ArrayList<Case> getfils() {
		return fils;
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
	
	public Case getClasse() {
		if (parent == null)
			return this;
		else
			return parent.getClasse();
	}
	
	public int cardinaliteCase(){
		if(fils.size() == 0){
			return 1;
		}
		else
		{
			int i = 0;
			for(Case c : fils){
				i += c.cardinaliteCase();
			}
			return i;
		}
	}
}
