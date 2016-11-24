import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BoutonExistChem extends ChoixBouton{
	private Case case_;
	
	public BoutonExistChem(ArrayList<Bouton> boutons, Partie partie){
		super("Existence chemin", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {		
		if(case_ == null){
			case_ = b.getCase();
		}
		else{
			int x1 = b.getCase().getX();
			int y1 = b.getCase().getY();
			int x2 = case_.getX();
			int y2 = case_.getY();
			
			boolean existe = partie_.existeChemin(case_, b.getCase());
			if(existe)
				JOptionPane.showMessageDialog(null, "Il existe un chemin entre la Case("+x1+","+y1+") et la Case("+x2+","+y2+")", "Existe chemin ?", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Il n'existe pas de chemin entre la Case("+x1+","+y1+") et la Case("+x2+","+y2+")", "Existe chemin ?", JOptionPane.ERROR_MESSAGE);
			case_ = null;
		}
	}
}
