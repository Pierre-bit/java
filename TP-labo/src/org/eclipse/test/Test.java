package org.eclipse.test;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.classes.Adresse;
import org.eclipse.classes.Bureau;
import org.eclipse.classes.Chercheur;
import org.eclipse.classes.Laboratoire;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("===============Adresse==========================");
		Adresse c1 = new Adresse("10 Downing Street","London",47856);
		System.out.println(c1);
		
		System.out.println("=========================================");
		c1.setZipCode(47125);
		System.out.println(c1);
		
		System.out.println("=========================================");
		Adresse c2 = new Adresse("201 rue de l'Elysee","Paris",47856);
		c2.setCity("Lille");
		System.out.println(c2);
		
		System.out.println("================Chercheur=========================");
		Chercheur ch1 = new Chercheur("Gates","Developpeur",587);
		System.out.println(ch1);
		
		System.out.println("=========================================");
		Chercheur ch2 = new Chercheur("Jobs","Analyste");
		
		System.out.println("=============Nombre de Chercheurs============================");
		System.out.println(ch1.countNbChercheur());
		ch1.setIdComputer(002);
		
		System.out.println("=========================================");
		Chercheur ch3 = new Chercheur();
		Chercheur ch4 = new Chercheur("Gates","Developpeur",587);
		Chercheur ch5 = new Chercheur("Gates","Developpeur",587);
		
		System.out.println("=============Compare===========================");
		boolean tes = ch5.comparer(ch4);
		System.out.println(tes);
		if (tes == true) {
			System.out.println("identique");
		}
		else 
		{
			System.out.println("Differents");
		}
		
		System.out.println("=========================================");
		ch3.setName("Torvalds");
		ch3.setJob("Batisseur");
		ch3.setIdComputer(47855);
		System.out.println("==============Collection de Chercheurs==========================");
		List<Chercheur> chercheurs = new ArrayList<>();
		chercheurs.add(ch1);
		chercheurs.add(ch2);
		chercheurs.add(ch3);
		
		System.out.println("================Bureau=========================");
		Bureau bureau1=  new Bureau(1,"Design",chercheurs);
		System.out.println(bureau1);
		Bureau bureau2 = new Bureau(2,"Working",chercheurs);
		// creation de collection
		
		System.out.println("=============Collection de Bureaux============================");
		List<Bureau> bureaux = new ArrayList<>();
		bureaux.add(bureau1);
		bureaux.add(bureau2);
		
		System.out.println("=============Laboratoire============================");
		Laboratoire laboratoire = new Laboratoire("Nasa","Espace",c2,bureaux);
		System.out.println(laboratoire);	
	}	
}
