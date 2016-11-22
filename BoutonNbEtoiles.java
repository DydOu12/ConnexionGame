import java.util.ArrayList;

public class BoutonNbEtoiles extends ChoixBouton{
	public BoutonNbEtoiles(ArrayList<Bouton> boutons, Partie partie){
		super("Nb étoiles pour composante", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {
		
	}
}
