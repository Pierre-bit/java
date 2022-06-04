package com.example.classes;

public class Etudiant {

	private int id;
	private String name;
	private String forname;
	private Filiere filiere;
	private static int numId;
	
	public Etudiant() {
		super();
	}

	public Etudiant(String name,String forname,Filiere filiere)
	{
		this.id= ++numId;
		this.name=name;
		this.forname=forname;
		this.filiere=filiere;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForname() {
		return forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {	
		return "L'etudiant s'appelle "+name+ " "+ forname+ " appartenant a la filiere "+filiere+" et son id est "+id;
	}
	
}
