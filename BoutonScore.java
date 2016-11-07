import java.util.ArrayList;

public class BoutonScore extends ChoixBouton{
	public BoutonScore(ArrayList<Bouton> b){
		super("Scores", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {
		
	}
}
