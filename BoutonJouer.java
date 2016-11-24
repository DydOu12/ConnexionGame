import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class BoutonJouer extends JButton implements ActionListener{
	
	private ArrayList<ChoixBouton> actions_;
	private ArrayList<Bouton> boutons_;
	private Partie partie_;
	private ChoixBouton colorier_;
	
	public BoutonJouer(String s, ArrayList<ChoixBouton> actions, ArrayList<Bouton> boutons, Partie partie, ChoixBouton colorier){
		super(s);
		actions_ = actions;
		boutons_ = boutons;
		partie_ = partie;
		colorier_ = colorier;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (ChoixBouton action : actions_)
			action.setEnabled(true);
		
		colorier_.setBackground(Color.YELLOW);
		this.setEnabled(false);
		
		for(Bouton bouton : boutons_){
			bouton.setEnabled(true);
			ChoixBouton cB = new BoutonColorier(boutons_, partie_);
			bouton.setChoixBouton(cB);
		}
	}
}
