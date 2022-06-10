package org.eclipse.classes;

public class Salles {
	
	private int id;
	private String code;
	private String libelle;
	private static int count;
	private String dispo;
	
	
	public Salles() {

	}
	
	public Salles(String code, String libelle) {

		this.id=++count;
		this.code = code;
		this.libelle = libelle;
	}
	
	public Salles(int id, String code, String libelle,String dispo) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.dispo = dispo;
	}
	
	public Salles(String code, String libelle,String dispo) {

		this.id=++count;
		this.code = code;
		this.libelle = libelle;
		this.dispo=dispo;
	}

	
	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
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
