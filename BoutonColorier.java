import java.util.ArrayList;

public class BoutonColorier extends ChoixBouton {

	public BoutonColorier(ArrayList<Bouton> b, Partie p){
		super("Colorer une case", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
		if(b.getCoulBouton() == null){
			// on colorie la vue
			b.colorer(partie.getJoueurCour());
			// on colorie le modèle
			partie.colorerCase(b.getCase());
		}
	}
}
