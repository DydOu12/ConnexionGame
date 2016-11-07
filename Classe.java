import java.util.HashSet;


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
	
	
}
