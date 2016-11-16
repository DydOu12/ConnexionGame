import java.awt.Color;
import java.util.ArrayList;

public class BoutonNbEtoiles extends ChoixBouton{
	public BoutonNbEtoiles(ArrayList<Bouton> b, Partie p){
		super("Nb étoiles pour composante", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
		
	}
}
