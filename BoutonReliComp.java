import java.util.ArrayList;

import javax.swing.JButton;

public class BoutonReliComp extends ChoixBouton{
	public BoutonReliComp(ArrayList<Bouton> boutons, Partie partie){
		super("Relier composantes", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
