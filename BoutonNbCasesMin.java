import java.util.ArrayList;

public class BoutonNbCasesMin extends ChoixBouton{
	public BoutonNbCasesMin(ArrayList<Bouton> b){
		super("Nb cases min sur un chemin", b);
		this.addActionListener(this);
	}
	
	@Override
	public void actionClic(Bouton b) {

	}
}
