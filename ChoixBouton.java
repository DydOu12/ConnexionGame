import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public abstract class ChoixBouton extends JButton implements ActionListener{
	
	private ArrayList<Bouton> boutons;
	
	public ChoixBouton (String s, ArrayList<Bouton> b) {
		super(s);
		boutons = b;
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
