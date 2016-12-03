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
		setEnabled(false);
		couleurBouton_ = null;
	}

	public Color getCouleurBouton() {
		return couleurBouton_;
	}

	public void setCouleurBouton(Color couleurBouton) {
		couleurBouton_ = couleurBouton;
	}
	
	public Case getCase() {
		return case_;
	}

	public void setChoixBouton(ChoixBouton choixBouton) {
		choixBouton_ = choixBouton;
		setBackground(couleurBouton_);
	}
	
	public void colorer(Joueur joueur){	
		setBackground(joueur.getCouleur());
		couleurBouton_ = joueur.getCouleur();
	}
	
	public void colorer(Joueur joueur, Joueur joueurSuivant){	
		colorer(joueur);
		choixBouton_.setBackground(joueurSuivant.getCouleur());
	}

	@Override
	public String toString() {
		return "Case [ligne=" + case_.getX() + ", colonne=" + case_.getY() + "]";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		choixBouton_.actionClic(this);
	}
}
