/**
 * 
 */
package org.eclipse.classes;


/**
 * @author Pierre
 *
 */
public class Personne {
	
	
	private int id;
	private String name;
	private String forname;
	private static int nbPersonnes;

	
	
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
	
	// constructeur avec 4 parametre (surcharge du constructeur)
	public Personne(String name, String forname) {
		this.id = ++nbPersonnes;
		this.name = name;
		this.forname = forname;
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
	
//	@Override
//	public String toString() {
//		return "Personne [id=" + id + ", name=" + name + ", forname=" + forname + ", adresse=" + adresse + "]";
//	}
	
	@Override
	public String toString() {
		return "Je m'appel "+name+" "+forname+"et mon id est "+id;
	}
	

	
	
	
	

	
}
