package org.eclipse.classes;

import org.eclipse.enums.Sport;

public class Enseignant extends Personne {

	private  double salaire;

	public Enseignant() {
		
	}

	// constructeur avec rappel du constructeur de la classe Personne 
	public Enseignant(String name, String forname, Adresse adresse , Sport sport,double salaire) {
		super(name, forname, adresse,sport);
		this.salaire = salaire;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	//redefinition de la méthode 
	@Override
	public void afficherNomMajuscules() {
		System.out.println(super.getName().toLowerCase());
		
	}
	
	//redefinition de la méthode 
	@Override
	public void afficherPrenomMinuscules() {
		System.out.println(super.getForname().toUpperCase());
		
	}
	
	// methode toString avec rappel de la methode  ToString de la classe Personne 
	@Override
	public String toString() {
		return super.toString() + " et mon salaire est de "+ salaire +"€";
	}
	
	
	
	
	
}
