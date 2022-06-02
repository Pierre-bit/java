package org.eclipse.main;



import org.eclipse.classes.Adresse;
import org.eclipse.classes.Enseignant;
import org.eclipse.classes.Etudiant;
import org.eclipse.classes.Personne;
import org.eclipse.classes.Methodes;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personne p1 = new Personne(1,"Wick","John");
		Personne p2 = new Personne();
		
		p2.setId(2);
		p2.setName("Weak");
		p2.setForname("Jon");
		
		
		System.out.println(p2);
		System.out.println(p1);
		System.out.println(Personne.getNbPersonnes());
		
		Adresse adresse = new Adresse("22 rue de la cité",58710,"Boto");
		Adresse adresse2 = new Adresse("22 rue de la cité",58710,"Poudlard");
		Adresse adresse3 = new Adresse("4 street Privet Drive",478,"Little Whinging");
		Personne p3 = new Personne ("Hogan","Paul",adresse);
		
		System.out.println(p3);
		System.out.println(Personne.getNbPersonnes());
		
		Etudiant etudiant = new Etudiant("Potter","Harry",adresse3,"3eme classe");
		System.out.println(etudiant);
		
		Enseignant enseignant = new Enseignant("Dumbledore","Albus",adresse2,14587d);
		System.out.println(enseignant);
		
		Etudiant etudiant2 = new Etudiant("Weasley","Ron",adresse3,"1ere Classe");
		
		etudiant2.afficherNomMajuscules();
		etudiant2.afficherPrenomMinuscules();
		System.out.println(etudiant2);
		
		
		Enseignant enseignant2 = new Enseignant("Severus","Rogue",adresse2,13475d);
		System.out.println(enseignant2);
		
		Personne [] personnes = {etudiant,etudiant2,enseignant,enseignant2};
		
		for (int i=0 ; i<personnes.length; i++)
		{
			System.out.print(personnes[i].getName()+ " ");
			if (personnes[i] instanceof Enseignant)
			{
				System.out.println(((Enseignant)personnes[i]).getSalaire()+" €");
			}
			else 
			{
				System.out.println(((Etudiant)personnes[i]).getNiveau());
			}
		}
		
		
		for (Personne perso : personnes)
		{
			System.out.println(perso.getName());
			if (perso instanceof Enseignant)
			{
				System.out.println(((Enseignant)perso).getSalaire());
			}
			else
			{
				System.out.println(((Etudiant)perso).getNiveau());
			}
		}
		
		Methodes met1 = new Methodes()	;
	
		System.out.println(met1.returnPgvalNumber(2 , 5));
		met1.repeatWord("test");
		System.out.println(met1.selectNumber(2,10)); 
		System.out.println(met1.contentValue(8)); 
		
		
		


	

	
		
	}

}
