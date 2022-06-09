package org.eclipse.classes;

public class Salles {
	
	private int id;
	private String code;
	private String libelle;
	private static int count;
	
	
	public Salles() {

	}
	
	public Salles(String code, String libelle) {

		this.id=++count;
		this.code = code;
		this.libelle = libelle;
	}
	
	public Salles(int id, String code, String libelle) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Salles [code=" + code + ", libelle=" + libelle + "]";
	}
	
	
	
	
	

}
