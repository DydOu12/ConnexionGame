import java.util.ArrayList;

public class BoutonExistChem extends ChoixBouton{
	public BoutonExistChem(ArrayList<Bouton> b){
		super("Existence chemin", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b, Joueur j) {

	}
}
