import java.util.ArrayList;

public class Case
{
	private int x;
	private int y;
	private Joueur joueur;
	private boolean aEtoile;
	private Case parent_;
	private ArrayList<Case> fils;

	public Case(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.joueur = null;
		aEtoile = false;
		parent_ = null;
		fils = new ArrayList<>();
	}

	public Case getParent() {
		return parent_;
	}

	public void setParent(Case parent) {
		if(parent_ != null) {
			parent_.supprimerFils(this);
		}
		parent_ = parent;
		parent_.ajouterFils(this);
	}
	
	public void ajouterFils(Case c){
		fils.add(c);
	}
	
	public void supprimerFils(Case c){
		fils.remove(c);
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
		return "Case [x=" + x + ", y=" + y +"]\n";
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
		if (parent_ == null){
			return this;
		}else
			return parent_.getClasse();
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
			return i+1;
		}
	}
}
