
public class Partie {
	private Joueur j1_;
	private Joueur j2_;
	private Joueur jC_;
	private Grille grille;
	
	public Partie(Joueur j1, Joueur j2){
		j1_ = j1;
		j2_ = j2;
		jC_ = j1;
		grille = new Grille(8);
	}
	
	
}
