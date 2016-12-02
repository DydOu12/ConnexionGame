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
			boolean existe = partie_.existeChemin(case_, b.getCase());
			if(existe)
				JOptionPane.showMessageDialog(null, "Il existe un chemin entre la case "+b.getCase()+" et la case "+case_, "Existe chemin ?", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Il n'existe pas de chemin entre la case "+b.getCase()+" et la case "+case_, "Existe chemin ?", JOptionPane.ERROR_MESSAGE);
			case_ = null;
		}
	}
}
