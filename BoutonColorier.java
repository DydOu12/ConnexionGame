import java.util.ArrayList;

public class BoutonColorier extends ChoixBouton {

	private FenetreJeu fenetreJeu_;
	
	public BoutonColorier(ArrayList<Bouton> boutons, Partie partie){
		super("Colorer une case", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton bouton) {
		if(bouton.getCase().getJoueur() == null){
			Joueur joueurC = partie_.getJoueurCourant();
			// on colorie le modèle
			partie_.colorerCase(bouton.getCase());
			// on colorie la vue
			bouton.colorer(joueurC, partie_.getJoueurCourant());			
		}
	}
}
