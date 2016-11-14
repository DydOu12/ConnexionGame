import java.util.ArrayList;

public class BoutonScore extends ChoixBouton{
	public BoutonScore(ArrayList<Bouton> b, Partie p){
		super("Scores", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
	
	}
}
