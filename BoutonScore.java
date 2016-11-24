import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class BoutonScore extends ChoixBouton {
	
	public BoutonScore(String s, Partie partie) {
		super(s, partie);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int [] scores = partie_.afficheScores();
		JOptionPane.showMessageDialog(null, "Score du joueur Bleu : "+scores[0]+"\nScore du joueur Rouge : "+scores[1], "Scores", JOptionPane.INFORMATION_MESSAGE);
	}

}
