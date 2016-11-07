import java.awt.Color;
import java.util.ArrayList;

public class BoutonColorier extends ChoixBouton {
	private Joueur j;
	
	public BoutonColorier(ArrayList<Bouton> b){
		super("Colorer une case", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
		//b.setBackground(Color.BLUE);
		b.setJoueur(j);
		b.setBackground(j.getCouleur());
	}
}
