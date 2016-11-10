import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Bouton extends JButton implements ActionListener
{
	private int ligne;
	private int colonne;
	private ChoixBouton cB;
	//private Joueur joueur;
	
	public Bouton(int l, int c /*ControleurBouton ctrlB*/)
	{
		this.ligne = l;
		this.colonne = c;
		this.addActionListener(this);
		//joueur = null;
		/*init controleur*/
		setEnabled(false);
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}
	
	public void setcB(ChoixBouton cB) {
		this.cB = cB;
	}
	
//	public Joueur getJoueur() {
//		return joueur;
//	}
//	
//	public void setJoueur(Joueur joueur) 
//	{
//		this.joueur = joueur;
//	}
	
	public void colorer(/*Joueur j*/){	
		//this.setBackground(j retourné du controleur);
	}

	@Override
	public String toString() {
		return "Case [ligne=" + ligne + ", colonne=" + colonne + "]";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cB.actionClic(this,new Joueur(Color.BLUE));
	}
}
