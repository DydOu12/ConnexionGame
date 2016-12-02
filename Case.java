import java.util.ArrayList;

public class Case
{
	private int x_;
	private int y_;
	private Joueur joueur_;
	private boolean aEtoile_;
	private Case parent_;
	private ArrayList<Case> fils_;
	private int distance_;

	public Case(int x, int y)
	{
		x_ = x;
		y_ = y;
		joueur_ = null;
		aEtoile_ = false;
		parent_ = null;
		fils_ = new ArrayList<>();
		distance_ = Integer.MAX_VALUE;
	}

	public int getDistance() {
		return distance_;
	}

	public void setDistance(int distance_) {
		this.distance_ = distance_;
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
	
	public void ajouterFils(Case fils){
		fils_.add(fils);
	}
	
	public void supprimerFils(Case fils){
		fils_.remove(fils);
	}
	
	public ArrayList<Case> getFils() {
		return fils_;
	}

	public Joueur getJoueur() {
		return joueur_;
	}

	public void setJoueur(Joueur joueur) 
	{
		joueur_ = joueur;
	}
	
	@Override
	public String toString() {
		return "("+x_ + ", " + y_ +")";
	}

	public int getX() {
		return x_;
	}

	public int getY() {
		return y_;
	}

	public boolean isaEtoile() {
		return aEtoile_;
	}

	public void setaEtoile(boolean aEtoile) {
		aEtoile_ = aEtoile;
	}
	
	public Case getClasse() {
		if (parent_ == null){
			return this;
		}else {
			Case classe = parent_.getClasse();
			// Remonte le noeud à la racine
			setParent(classe);
			return classe;
		}
	}
	
	public int cardinaliteCase(){
		if(fils_.size() == 0)
			return 1;
		else {
			int i = 0;
			for(Case c : fils_)
				i += c.cardinaliteCase();
			return i+1;
		}
	}
	
	public int getNombreEtoiles() {
		int i = 0;
		if (isaEtoile()) {
			++i;
		}
		for (Case fils : fils_)
			i += fils.getNombreEtoiles();
		return i;
	}

	@Override
	public int hashCode() {
		return x_*10+y_;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (x_ != other.x_)
			return false;
		if (y_ != other.y_)
			return false;
		return true;
	}

	
}
