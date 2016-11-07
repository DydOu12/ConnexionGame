import java.util.ArrayList;

public class BoutonReliComp extends ChoixBouton{
	public BoutonReliComp(ArrayList<Bouton> b){
		super("Relier composantes", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
