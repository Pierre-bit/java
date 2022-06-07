package org.eclipse.main;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.classes.Salles;
import org.eclipse.services.SalleService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		o Créer cinq salles.
//		o Afficher la liste des salles.
//		o Supprimer une salle.
//		o Modifier les informations d'une salle.
//		o Afficher la liste des salles
		
		SalleService salleService = new SalleService();
		
		// create 
		Salles salle1 = new Salles("1","master");
		Salles salle2 = new Salles("2","princier");
		Salles salle3 = new Salles("3","dortoir");
		Salles salle4 = new Salles("4","gardien");
		Salles salle5 = new Salles("5","prison");
		salleService.create(salle1);
		salleService.create(salle2);
		salleService.create(salle3);
		salleService.create(salle4);
		salleService.create(salle5);
		
		
		List<Salles> sallesAll = salleService.findAll();
			
		for(Salles s: sallesAll)
		{
			System.out.println(s);
		}
		
		//delete
		salleService.delete(salleService.findById(4));
		
		// update
		Salles s = salleService.findById(2);
		s.setLibelle("tresor");
		s.setCode("8");
		salleService.update(s);
		
		for(Salles sa: sallesAll)
		{
			System.out.println(sa);
		}
		
	}

}
