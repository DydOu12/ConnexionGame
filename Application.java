import java.awt.Color;


public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Fenetre f = new Fenetre("Best Game Ever");
		Joueur j1 = new Joueur(Color.BLUE);
		Joueur j2 = new Joueur(Color.RED);
	}

}
