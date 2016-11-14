import java.util.ArrayList;

public class BoutonAffComp extends ChoixBouton{
	public BoutonAffComp(ArrayList<Bouton> b, Partie p){
		super("Afficher la composante", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
		
	}
}
