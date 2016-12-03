import java.util.ArrayList;

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
			if(nbCases == Integer.MAX_VALUE)
				JOptionPane.showMessageDialog(null, "Un obstacle bloque la liaison des cases "+case1+" et "+b.getCase(), "Liaison impossible", JOptionPane.ERROR_MESSAGE);
			else if (nbCases == -2)
				JOptionPane.showMessageDialog(null, "Les cases "+case1+" et "+b.getCase()+ " n'appartiennent pas au même joueur", "Liaison impossible", JOptionPane.ERROR_MESSAGE);
			else 
				JOptionPane.showMessageDialog(null, "Il faut colorier "+nbCases+" case(s) pour pouvoir relier les cases "+case1+" et "+b.getCase(), "Nombre de case(s) minimum(s)", JOptionPane.INFORMATION_MESSAGE);
			case1 = null;
		}
		
	}
}
