import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public abstract class ChoixBouton extends JButton implements ActionListener{
	
	protected ArrayList<Bouton> boutons_;
	protected Partie partie_;
	
	public ChoixBouton (String description, ArrayList<Bouton> boutons, Partie partie) {
		super(description);
		boutons_ = boutons;
		partie_ = partie;
		addActionListener(this);
		super.setEnabled(false);
	}
	
	public abstract void actionClic(Bouton bouton);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Bouton bouton : boutons_)
			bouton.setChoixBouton(this);
	}
}
