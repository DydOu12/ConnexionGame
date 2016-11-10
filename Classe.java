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
	
	public void union (Classe c) {
		classeCase.addAll(c.getClasseCase());
	}

	@Override
	public String toString() {
		return "Classe [classeCase=" + classeCase + "]";
	}

	public HashSet<Case> getClasseCase() {
		return classeCase;
	}

	public void setClasseCase(HashSet<Case> classeCase) {
		this.classeCase = classeCase;
	}
	
	public boolean caseAutour(int x, int y, Joueur j){
		boolean caseAutour = false;
		Iterator<Case> it = classeCase.iterator();
		
		Case c;
		while (it.hasNext() && !caseAutour) {
			c = it.next();
			if ((	(c.getJoueur().equals(j))       && 
					(Math.abs(c.getX()-x)<=1) 		|| 
					(Math.abs(c.getY()-y)<=1))) 
			{
				caseAutour = true;
			}
		}
		return caseAutour;
	}

	
}
