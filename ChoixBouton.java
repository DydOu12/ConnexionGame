import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public abstract class ChoixBouton extends JButton implements ActionListener{
	
	protected ArrayList<Bouton> boutons_;
	protected ArrayList<ChoixBouton> actions_;
	protected Partie partie_;
	
	public ChoixBouton (String description, Partie partie) {
		super(description);
		boutons_ = new ArrayList<>();
		partie_ = partie;
		addActionListener(this);
		setEnabled(false);
	}
	public ChoixBouton (String description, ArrayList<Bouton> boutons, Partie partie) {
		this(description, partie);
		boutons_ = boutons;
	}
	
	public void actionClic(Bouton bouton) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Bouton bouton : boutons_)
			bouton.setChoixBouton(this);
		for (ChoixBouton action : actions_)
			action.setBackground(null);
		setBackground(Color.YELLOW);
	}

	public void setActions(ArrayList<ChoixBouton> actions) {
		actions_ = actions;
	}
}
