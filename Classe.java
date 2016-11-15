import java.util.HashSet;
import java.util.Iterator;


public class Classe 
{
	private HashSet<Case> classeCase;
	
	public Classe(Case c)
	{
		classeCase = new HashSet<>();
		classeCase.add(c);
	}
	
	public Classe()
	{
		classeCase = new HashSet<>();
	}
	
	public void union (Classe c) {
		classeCase.addAll(c.getClasseCase());
	}

	@Override
	public String toString() {
		return "Classe [classeCase=" + classeCase + "]\n";
	}

	public HashSet<Case> getClasseCase() {
		return classeCase;
	}

	public void setClasseCase(HashSet<Case> classeCase) {
		this.classeCase = classeCase;
	}
	
	
	// si la classe possède au moins une case(x,y) autour d'elle
	public boolean caseAutour(Case ca, Joueur j){
		boolean caseAutour = false;
		Iterator<Case> it = classeCase.iterator();
		int x = ca.getX();
		int y = ca.getY();
		
		Case c;
		while (it.hasNext() && !caseAutour) {
			c = it.next();
			if ((	(j.equals(c.getJoueur()))       && 
					(Math.abs(c.getX()-x)<=1) 		&& 
					(Math.abs(c.getY()-y)<=1))) 
			{
				caseAutour = true;
			}
			
		}
		return caseAutour;
	}

	public boolean possede(Case c) {
		return classeCase.contains(c);
	}

	
}
