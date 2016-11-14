import java.util.ArrayList;

public class BoutonReliComp extends ChoixBouton{
	public BoutonReliComp(ArrayList<Bouton> b, Partie p){
		super("Relier composantes", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
