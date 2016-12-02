import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
			int nbCases = partie_.relierCasesMin(case1, b.getCase());
			if(nbCases < 0 || nbCases == Integer.MAX_VALUE)
				JOptionPane.showMessageDialog(null, "Impossible de relier les cases "+case1+" et "+b.getCase(), "Nombre de cases minimums", JOptionPane.INFORMATION_MESSAGE);
			else 
				JOptionPane.showMessageDialog(null, "Il faut colorier "+nbCases+" case(s) pour pouvoir relier les cases "+case1+" et "+b.getCase(), "Nombre de cases minimums", JOptionPane.INFORMATION_MESSAGE);
			case1 = null;
		}
		
	}
}
