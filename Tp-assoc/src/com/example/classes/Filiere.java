package com.example.classes;

public class Filiere {

	private int id;
	private int code;
	private String libelle;
	private static int numId;
	 
	
	public Filiere() {
		super();
	}


	public Filiere(int code,String libelle)
	{
		this.id = ++numId;
		this.code = code;
		this.libelle = libelle;
	}


	public int getId() {
		return id;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return libelle+" ayant un code "+code;  
	}
	
	
	
	
}
