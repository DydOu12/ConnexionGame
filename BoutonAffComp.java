import java.awt.Color;
import java.util.ArrayList;

public class BoutonAffComp extends ChoixBouton{
	public BoutonAffComp(ArrayList<Bouton> b, Partie p){
		super("Afficher la composante", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
		ArrayList<Case> composante = partie.afficherComposante(b.getCase());
		int tailleGrille = partie.getGrille().getTailleGrille();
		for (Bouton bo : boutons) {
			bo.setBackground(null);
		}
		for (Case ca : composante) {
			boutons.get(tailleGrille * ca.getX() + ca.getY()).setBackground(Color.BLACK);
		}
	}
}
