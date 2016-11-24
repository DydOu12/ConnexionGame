import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;

public class BoutonAffComp extends ChoixBouton {
	public BoutonAffComp(ArrayList<Bouton> boutons, Partie partie){
		super("Afficher la composante", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {
		ArrayList<Case> composante = partie_.afficherComposante(b.getCase());
		int tailleGrille = partie_.getGrille().getTailleGrille();
		for (Bouton bouton : boutons_) {
			bouton.setBackground(null);
		}
		for (Case ca : composante) {
			boutons_.get(tailleGrille * ca.getX() + ca.getY()).setBackground(Color.BLACK);
		}
	}
}
