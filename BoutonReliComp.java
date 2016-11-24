import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BoutonReliComp extends ChoixBouton{
	public BoutonReliComp(ArrayList<Bouton> boutons, Partie partie){
		super("Relier composantes", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {
		if (partie_.relieComposantes(b.getCase()))
			JOptionPane.showMessageDialog(null, "La case cliquée permet de relier au moins deux composantes", "Relier plusieurs composantes ?", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "La case cliquée ne permet pas de relier au moins deux composantes", "Relier plusieurs composantes ?", JOptionPane.INFORMATION_MESSAGE);

	}
}
