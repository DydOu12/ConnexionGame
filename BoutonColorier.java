import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BoutonColorier extends ChoixBouton {

	public BoutonColorier(ArrayList<Bouton> boutons, Partie partie){
		super("Colorer une case", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton bouton) {
		if(bouton.getCouleurBouton() == null){
			Joueur joueurC = partie_.getJoueurCourant();
			// on colorie le modèle
			partie_.colorerCase(bouton.getCase());
			// on colorie la vue
			bouton.colorer(joueurC, partie_.getJoueurCourant());

			
			if (partie_.partieFinie()) {
				Joueur gagnant = partie_.joueurGagnant();
				if(gagnant != null){
					JOptionPane.showMessageDialog(null, "Le joueur "+gagnant.getPseudo()+" a gagné !", "Partie terminée !", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Aucun des joueurs n'a pu connecter des cases étoiles", "Partie terminée..", JOptionPane.INFORMATION_MESSAGE);
				
				for(Bouton b : boutons_)
					b.setEnabled(false);
			}
			
		}
	}
}
