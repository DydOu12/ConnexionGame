import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Bouton extends JButton implements ActionListener
{
	private ChoixBouton choixBouton_;
	private Color couleurBouton_;
	private Case case_;
	
	public Bouton(Case ca, ChoixBouton choixBouton)
	{
		case_ = ca;
		choixBouton_ = choixBouton;
		addActionListener(this);
		couleurBouton_ = null;
	}

	public Color getCouleurBouton() {
		return couleurBouton_;
	}

	public void setCouleurBouton(Color couleurBouton) {
		couleurBouton_ = couleurBouton;
		setBackground(couleurBouton);
	}
	
	public Case getCase() {
		return case_;
	}

	public void setChoixBouton(ChoixBouton choixBouton) {
		choixBouton_ = choixBouton;
		setBackground(couleurBouton_);
	}
	
	public void colorer(Joueur joueur){	
		setCouleurBouton(joueur.getCouleur());
	}

	@Override
	public String toString() {
		return "Case [ligne=" + case_.getX() + ", colonne=" + case_.getY() + "]";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		choixBouton_.actionClic(this);
	}

	public ChoixBouton getChoixBouton() {
		return choixBouton_;
	}
}
