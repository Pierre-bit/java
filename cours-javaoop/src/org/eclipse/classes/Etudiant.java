package org.eclipse.classes;

import org.eclipse.enums.Sport;

public class Etudiant extends Personne {

	private String niveau;

	
	public Etudiant() {
		
	}
	// constructeur avec rappel du constructeur de la classe Personne 
	public Etudiant(String name, String forname, Adresse adresse,String niveau, Sport sport) {
		super(name, forname, adresse,sport);
		this.niveau=niveau;
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
