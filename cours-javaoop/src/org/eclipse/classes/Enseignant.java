package org.eclipse.classes;

public class Enseignant extends Personne {

	private  double salaire;

	public Enseignant() {
		
	}

	// constructeur avec rappel du constructeur de la classe Personne 
	public Enseignant(String name, String forname, Adresse adresse , double salaire) {
		super(name, forname, adresse);
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	// methode toString avec rappel de la methode  ToString de la classe Personne 
	@Override
	public String toString() {
		return super.toString() + " et mon salaire est de "+ salaire +"€";
	}
	
	
	
	
	
}
