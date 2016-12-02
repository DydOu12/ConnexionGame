import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BoutonNbEtoiles extends ChoixBouton{
	public BoutonNbEtoiles(ArrayList<Bouton> boutons, Partie partie){
		super("Nb étoiles pour composante", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {
		JOptionPane.showMessageDialog(null, "La composante de la case cliquée contient "+partie_.getNombreEtoiles(b.getCase())
+" case(s) étoiles", "Nombre étoiles", JOptionPane.INFORMATION_MESSAGE);
	}
}
