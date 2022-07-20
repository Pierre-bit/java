package org.eclipse.classes;

public class Admin extends User {

	
	public Admin() {
	}

	public Admin(String nom, String prenom) {
		super(nom, prenom);
	}

	@Override
	public void afficherNomComplet() {
		System.out.println("Je suis l'admin");
		System.out.println(this.getNom() + " " + this.getPrenom());
	}
}
