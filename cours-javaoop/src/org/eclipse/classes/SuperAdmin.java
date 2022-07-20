package org.eclipse.classes;

public class SuperAdmin extends User {

	public SuperAdmin() {
	}

	public SuperAdmin(String nom, String prenom) {
		super(nom, prenom);
	}

	@Override
	public void afficherNomComplet() {
		System.out.println("Je suis le Super Admin");
		System.out.println(this.getNom() + " " + this.getPrenom());
	}
	

	

}
