import java.awt.Color;

import javax.swing.JButton;


public class Bouton extends JButton 
{
	private int ligne;
	private int colonne;
	private String motif;
	private Color fond;
	
	public Bouton(int l, int c)
	{
		this.ligne = l;
		this.colonne = c;
	}
	
	public Bouton(int l, int c, String m, Color f)
	{
		this(l,c);
		this.motif = m;
		this.fond = f;
	}

	public Color getFond() {
		return fond;
	}

	public void setFond(Color fond) {
		this.fond = fond;
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

	@Override
	public String toString() {
		return "Case [ligne=" + ligne + ", colonne=" + colonne + "]";
	}
}
