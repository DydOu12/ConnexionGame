import java.util.ArrayList;

public class BoutonNbEtoiles extends ChoixBouton{
	public BoutonNbEtoiles(ArrayList<Bouton> b){
		super("Nb �toiles pour composante", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
