import java.util.ArrayList;

import javax.swing.JButton;

public class BoutonNbCasesMin extends ChoixBouton{
	
	private Case case1;
	
	public BoutonNbCasesMin(ArrayList<Bouton> boutons, Partie partie){
		super("Nb cases min sur un chemin", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {
		if(case1 == null)
			case1 = b.getCase();
		else {
			System.out.println(partie_.relierCasesMin(case1, b.getCase()));
			case1 = null;
		}
		
	}
}
