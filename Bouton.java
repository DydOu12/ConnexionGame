import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Bouton extends JButton implements ActionListener
{
	private ChoixBouton cB;
	private Color coulBouton_;
	private Case case_;
	
	public Bouton(Case ca)
	{
		case_ = ca;
		this.addActionListener(this);
		setEnabled(false);
		coulBouton_ = null;
	}

	public Color getCoulBouton() {
		return coulBouton_;
	}

	public void setCoulBouton(Color coulBouton) {
		this.coulBouton_ = coulBouton;
	}
	
	public Case getCase() {
		return case_;
	}

	public void setcB(ChoixBouton cB) {
		this.cB = cB;
		this.setBackground(coulBouton_);
	}
	
	public void colorer(Joueur j){	
		this.setBackground(j.getCouleur());
		coulBouton_ = j.getCouleur();
	}

	@Override
	public String toString() {
		return "Case [ligne=" + case_.getX() + ", colonne=" + case_.getY() + "]";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cB.actionClic(this);
	}
}
