package org.eclipse.classes;

public abstract class User {
	
	
	private int id;
	private String nom;
	private String prenom;
	private static int count;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom) {
		super();
		this.id = ++count;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	public abstract void afficherNomComplet();
	
	
}
