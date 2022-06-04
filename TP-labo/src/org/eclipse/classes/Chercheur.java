package org.eclipse.classes;

public class Chercheur {

	private int id;
	private String name;
	private String job;
	private int idComputer;
	private static int count;
	
	public Chercheur() {
		
	}
	
	public Chercheur( String name, String job) {
		this.id = ++count;
		this.name = name;
		this.job = job;
	}

	public Chercheur(String name, String job, int idComputer) {
		this.id = ++count;
		this.name = name;
		this.job = job;
		this.idComputer = idComputer;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getIdComputer() {
		return idComputer;
	}
	
	public void setIdComputer(int idComputer) {
		this.idComputer = idComputer;
	}

	public int countNbChercheur()
	{
		return count;
	}
	
	//Ajouter dans la classe Chercheur la méthode comparer() qui permet de tester l’égalité entre deux chercheurs : public void comparer (Chercheur ch){…
	public boolean comparer(Chercheur ch)
	{
		if (this.name == ch.name && this.job == ch.job && this.idComputer == ch.idComputer )
		{
			return true;
		}
		return false;
		
	}

	@Override
	public String toString() {
		return name+" a un poste de chercheur en "+job +" et a acces à l'ordinateur numéro "+idComputer; 
	}
	
	
	
	
}
