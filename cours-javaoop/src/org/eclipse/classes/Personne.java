/**
 * 
 */
package org.eclipse.classes;

import org.eclipse.interfaces.IMiseEnForme;

/**
 * @author Pierre
 *
 */
public class Personne implements IMiseEnForme {
	
	
	private int id;
	private String name;
	private String forname;
	private static int nbPersonnes;
	private Adresse adresse;
	
	
	// constructeur vide
	public Personne() {
		nbPersonnes++;
	}
	// constructeur avec 3 parametre
	public Personne(int id, String name, String forname)
	{
		this.id=id;
		this.name=name;
		this.forname=forname;
		nbPersonnes++;
	}
	
	// constructeur avec 4 parametre
	public Personne(String name, String forname, Adresse adresse) {
		this.id = ++nbPersonnes;
		this.name = name;
		this.forname = forname;
		this.adresse = adresse;
		nbPersonnes++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public static int getNbPersonnes() {
		return nbPersonnes;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

//	@Override
//	public String toString() {
//		return "Personne [id=" + id + ", name=" + name + ", forname=" + forname + ", adresse=" + adresse + "]";
//	}
	
	@Override
	public String toString() {
		return "Je m'appel "+name+" "+forname+" "+adresse+" et mon id est "+id;
	}
	
	@Override
	public void afficherNomMajuscules() {
		System.out.println(name.toUpperCase());
		
	}
	@Override
	public void afficherPrenomMinuscules() {
		System.out.println(forname.toLowerCase());
		
	}

//	@Override
//	public String toString() {
//		return "Personne [id=" + id + ", name=" + name + ", forname=" + forname + "]";
//	}
	
	
	
	

	
}
