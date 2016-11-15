
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
		placerEtoilesAleatoirement();
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
	
	public Grille getGrille() {
		return grille;
	}
	
	public void colorerCase(Case c) {
		grille.colorerCase(c, jC_);
		echangerJoueur();
	}
	
	public void placerEtoilesAleatoirement(){
		int i=0;
		int x;
		int y;
		while (i<4) {
			x = (int)(Math.random() * grille.getTailleGrille());
			y = (int)(Math.random() * grille.getTailleGrille());
			
			if(grille.getCase(x, y).getJoueur() == null && i%2 == 0){
				grille.getCase(x, y).setaEtoile(true);
				grille.getCase(x, y).setJoueur(j1_);
				++i;
			}
			else if(grille.getCase(x, y).getJoueur() == null && i%2 == 1)
			{
				grille.getCase(x, y).setaEtoile(true);
				grille.getCase(x, y).setJoueur(j2_);
				++i;
			}
		}
	}

	public Classe afficherComposante(Case ca) {
		return grille.afficherComposante(ca);
	}
	
	public boolean existeChemin(Case c1, Case c2){
		return grille.existeChemin(c1, c2);
	}
	
}
