import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Bouton extends JButton implements ActionListener
{
	private int ligne;
	private int colonne;
	private String motif;
	private ChoixBouton cB;
	
	public Bouton(int l, int c)
	{
		this.ligne = l;
		this.colonne = c;
		this.addActionListener(this);
//		setEnabled(false);
	}
	
	public Bouton(int l, int c, String m, Color f)
	{
		this(l,c);
		this.motif = m;
		super.setBackground(f);
	}

	public String getMotif() {
		return motif;
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

	@Override
	public String toString() {
		return "Case [ligne=" + ligne + ", colonne=" + colonne + "]";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.cB.actionClic(this);
	}
}
