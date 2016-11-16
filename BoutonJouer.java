import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoutonJouer extends JButton implements ActionListener{
	private Fenetre fen;
	
	public BoutonJouer(String s, Fenetre f){
		super(s);
		fen = f;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fen.getbColor().setEnabled(true);
		fen.getbAffComp().setEnabled(true);
		fen.getbExistChem().setEnabled(true);
		fen.getbNbCasesMin().setEnabled(true);
		fen.getbNbEtoiles().setEnabled(true);
		fen.getbReliComp().setEnabled(true);
		fen.getbScore().setEnabled(true);
		this.setEnabled(false);
		for(Bouton b : fen.getBoutons()){
			b.setEnabled(true);
			b.setcB(new BoutonColorier(fen.getBoutons(), fen.getPartie()));
		}
	}
}
