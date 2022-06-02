package org.eclipse.classes;

public class Etudiant extends Personne {

	private String niveau;

	
	public Etudiant() {
		
	}
	// constructeur avec rappel du constructeur de la classe Personne 
	public Etudiant(String name, String forname, Adresse adresse,String niveau) {
		super(name, forname, adresse);
		this.niveau=niveau;
		// TODO Auto-generated constructor stub
	}
	
	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	// methode toString avec rappel de la methode  ToString de la classe Personne 
	@Override
	public String toString() {
		return super.toString() + " mon niveau est "+niveau;
	}
	
	
}
