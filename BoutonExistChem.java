import java.util.ArrayList;

public class BoutonExistChem extends ChoixBouton{
	public BoutonExistChem(ArrayList<Bouton> b, Partie p){
		super("Existence chemin", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
