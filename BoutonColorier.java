import java.util.ArrayList;

import javax.swing.JButton;

public class BoutonColorier extends ChoixBouton {

	public BoutonColorier(ArrayList<Bouton> boutons, Partie partie){
		super("Colorer une case", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton bouton) {
		if(bouton.getCouleurBouton() == null){
			// on colorie la vue
			bouton.colorer(partie_.getJoueurCourant());
			// on colorie le modèle
			partie_.colorerCase(bouton.getCase());
		}
	}
}
