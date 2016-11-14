import java.util.ArrayList;

public class BoutonNbCasesMin extends ChoixBouton{
	public BoutonNbCasesMin(ArrayList<Bouton> b, Partie p){
		super("Nb cases min sur un chemin", b, p);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
