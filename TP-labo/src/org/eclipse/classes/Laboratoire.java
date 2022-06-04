package org.eclipse.classes;

import java.util.List;

public class Laboratoire {

	private int id;
	private String name;
	private String specialite;
	private Adresse adresse;
	private List<Bureau> office;
	private static int count;
	
	public Laboratoire() {
		
	}

	public Laboratoire(String name, String specialite, Adresse adresse, List<Bureau> office) {
		this.id = ++count;
		this.name = name;
		this.specialite = specialite;
		this.adresse = adresse;
		this.office = office;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Bureau> getOffice() {
		return office;
	}

	public void setOffice(List<Bureau> office) {
		this.office = office;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Le laboratoire "+name+" spécialisé en "+specialite+ 
				" situe au "+adresse+" contient des bureaux"+office;
	}
	
	
	
	
}
