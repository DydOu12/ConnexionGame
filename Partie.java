
public class Partie {
	private Joueur j1_;
	private Joueur j2_;
	private Joueur jC_;
	private Grille grille;
	
	public Partie(Joueur j1, Joueur j2, int n){
		j1_ = j1;
		j2_ = j2;
		jC_ = j1;
		grille = new Grille(n);
	}
	
	public void echangerJoueur () {
		if(jC_.equals(j1_))
		{
			jC_ = j2_; 
		} else 
		{
			jC_ = j1_; 
		}
	}

	public Joueur getJoueurCour() {
		return jC_;
	}
	
	public void colorerCase(int x, int y) {
		grille.colorerCase(x, y, jC_);
		echangerJoueur();
	}
	
	public void placerEtoilesAleatoirement(){
		for (int i=0; i<2; i++) {
			
		}
	}
	
	
}
