import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BoutonScore extends JButton implements ActionListener{
	private Fenetre fen;
	
	public BoutonScore(String s, Fenetre f) {
		super(s);
		fen = f;
		super.setEnabled(false);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int [] scores = fen.getPartie().afficheScores();
		JOptionPane.showMessageDialog(null, "Score du joueur Bleu : "+scores[0]+"\nScore du joueur Rouge : "+scores[1], "Scores", JOptionPane.INFORMATION_MESSAGE);
	}
}
