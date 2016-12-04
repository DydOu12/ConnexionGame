import java.util.ArrayList;

public class BoutonColorier extends ChoixBouton {
	
	public BoutonColorier(ArrayList<Bouton> boutons, Partie partie){
		super("Colorer une case", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton bouton) {
		if(bouton.getCase().getJoueur() == null){
			// on colorie le modèle
			partie_.colorerCase(bouton.getCase());
			// on colorie la vue
			setBackground(partie_.getJoueurCourant().getCouleur());
		}
	}
}
