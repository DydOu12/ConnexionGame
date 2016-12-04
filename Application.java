public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new FenetreParametre();
//		new FenetreJeu(8, 3);
		
		// Test pour la cardinalite
		/*
		Case r = new Case(0, 0);
		Case c1 = new Case(1, 0);
		Case c2 = new Case(1, 1);
		Case c3 = new Case(2, 0);
		Case c4 = new Case(2, 1);
		Case c5 = new Case(2, 2);
		
		c1.setParent(r);
		c2.setParent(r);
		c3.setParent(c1);
		c4.setParent(c1);
		c5.setParent(c1);
		c5.setParent(c2);
				
		System.out.println(r.cardinaliteCase()); // 6
		System.out.println(c1.cardinaliteCase()); // 3
		System.out.println(c2.cardinaliteCase()); // 2
		System.out.println(c3.cardinaliteCase()); // 1
		System.out.println(c4.cardinaliteCase()); // 1
		System.out.println(c5.cardinaliteCase()); // 1
		*/
		
		// Test pour la classe
		/*
		Case r = new Case(0, 0);
		Case c1 = new Case(1, 0);
		Case c2 = new Case(1, 1);
		Case c3 = new Case(2, 0);
		Case c4 = new Case(2, 1);
		Case c5 = new Case(2, 2);
		Case c6 = new Case(3,1);
		
		// r a comme fils c1 et c2
		c1.setParent(r);
		c2.setParent(r);
		// c1 a comme fils c3, c4 et c5
		c3.setParent(c1);
		c4.setParent(c1);
		c5.setParent(c1);
		// c2 a comme fils c5
		c5.setParent(c2);
		// c5 a comme fils c6
		c6.setParent(c5);
		
		c5.getClasse();
		
		System.out.println(r.getFils());
		System.out.println(c5.getFils());
		*/
	}
}
