import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public abstract class ChoixBouton extends JButton implements ActionListener{
	
	protected ArrayList<Bouton> boutons;
	protected Partie partie;
	
	public ChoixBouton (String s, ArrayList<Bouton> b, Partie p) {
		super(s);
		boutons = b;
		partie = p;
		super.setEnabled(false);
	}
	
	public abstract void actionClic(Bouton b);
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (Bouton b : this.boutons)
		{
			b.setEnabled(true);
			b.setcB(this);
		}
	}
}
