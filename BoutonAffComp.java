import java.util.ArrayList;

public class BoutonAffComp extends ChoixBouton{
	public BoutonAffComp(ArrayList<Bouton> b){
		super("Afficher la composante", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b, Joueur j) {
		
	}
}
