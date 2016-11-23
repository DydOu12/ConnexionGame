import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BoutonScore extends ChoixBouton{
	public BoutonScore(ArrayList<Bouton> boutons, Partie partie){
		super("Scores", boutons, partie);
	}
	
	@Override
	public void actionClic(Bouton b) {
		int [] scores = partie_.afficheScores();
		JOptionPane.showMessageDialog(null, "Score du joueur Bleu : "+scores[0]+"\nScore du joueur Rouge : "+scores[1], "Scores", JOptionPane.INFORMATION_MESSAGE);

	}
}
