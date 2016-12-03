import java.awt.Color;

public class Joueur 
{
	private Color couleur;
	private String pseudo_;

	public Joueur(Color c, String pseudo)
	{
		couleur = c;
		pseudo_ = pseudo;
	}
	
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		return true;
	}
	
	public String getPseudo() {
		return pseudo_;
	}
	
	@Override
	public String toString() {
		return "Joueur [couleur=" + couleur + "]";
	}
}

