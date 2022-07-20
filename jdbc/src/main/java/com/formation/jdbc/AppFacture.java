package com.formation.jdbc;

import java.sql.Date;
import java.util.Scanner;

public class AppFacture {

	public static void main(String[] args) {
		
		IFactureDao dao = new FactureDaoJDBC();
		//IFactureDao dao = new FactureDaoMongoDB();
				
		Scanner input = new Scanner(System.in);
		
		boolean isRunning = true;
		while(isRunning){
			
			System.out.println("Connexion Utilisée : " + dao.getClass().getSimpleName());									
			afficherMenu();

			String line = input.nextLine();
			if(line.toLowerCase().equals("exit")) {
				isRunning = false;
				break;
			}
			
			if(line.toLowerCase().equals("1")) {
				dao.afficherListeFactures();
			
			} else if(line.toLowerCase().equals("2")) {
				int idFacture = demanderIdFacture(input);				
				dao.afficherFacture(idFacture);
			
			} else if(line.toLowerCase().equals("3")) {
				Facture fact = demanderAjoutFacture(input);
				if(dao.ajouterFacture(fact)) {
					System.out.println("Opération réussie");									
				} else {
					System.out.println("Pas d'insertion !!!");														
				}
				
			} else if(line.toLowerCase().equals("4")) {
				Facture fact = demanderModificationFacture(input);				
				if(dao.modifierFacture(fact)) {
					System.out.println("Opération réussie");									
				} else {
					System.out.println("Pas d'update !!!");														
				}
							
			} else if(line.toLowerCase().equals("5")) {
				int idFact = demanderSuppressionFacture(input);
				if(dao.supprimerFacture(idFact)) {
					System.out.println("Opération réussie");									
				} else {
					System.out.println("Pas de suppression !!!");														
				}

			} else if(line.toLowerCase().equals("6")) {
				System.out.println("Choisir PostgreSQL (1) ou MongoDB (2)");									
				
				String choixDb = input.nextLine();
				if(choixDb.equals("1")) {
					dao = new FactureDaoJDBC();
				} else if(choixDb.equals("2")) {
					dao = new FactureDaoMongoDB();					
				} else {
					System.out.println("Nous n'avons pas compris votre demande !!!");
				}
			} else {
				System.out.println("Nous n'avons pas compris votre demande !!!");				
			}
		}		
	}

	
	private static void afficherMenu() {
		System.out.println("Choisir dans le menu :");
		System.out.println("  1. Afficher la liste des factures");
		System.out.println("  2. Afficher une facture");
		System.out.println("  3. Ajouter une facture");
		System.out.println("  4. Modifier une facture");
		System.out.println("  5. Supprimer une facture");		
		System.out.println("  6. Changer la connexion de base de données");		
		System.out.println("  EXIT");		
	}
	
	private static int demanderIdFacture(Scanner input) {
		System.out.println("Taper l'id de la facture : ");
		return input.nextInt();		
	}


	private static Facture demanderAjoutFacture(Scanner input) {
		System.out.println("Taper l'id du client de la facture : ");
		int idClient = input.nextInt();	
		input.nextLine();
		System.out.println("Taper la date du client de la facture avec le format suivant : yyyy-mm-dd : ");
		//Example date
		//String str ="2015-03-31";
		//Date date=Date.valueOf(str);//converting string into sql date.
		String dateStr = input.nextLine();
		Date date = Date.valueOf(dateStr);
		
		System.out.println("Taper le montant de la facture : ");
		double montant = input.nextDouble();	

		Facture f = new Facture();
		f.setIdClient(idClient);
		f.setDate(date);
		f.setMontant(montant);
		return f;
	}

	
	private static Facture demanderModificationFacture(Scanner input) {
		System.out.println("Taper l'id de la facture : ");
		
		int id = input.nextInt();	

		System.out.println("Taper l'id du client de la facture : ");
		int idClient = input.nextInt();	
		input.nextLine();
		System.out.println("Taper la date du client de la facture avec le format suivant : yyyy-mm-dd : ");
		
		//Example date
		//String str ="2015-03-31";
		//Date date=Date.valueOf(str);//converting string into sql date.
		String dateStr = input.nextLine();
		Date date = Date.valueOf(dateStr);
		
		System.out.println("Taper le montant de la facture : ");
		double montant = input.nextDouble();	

		Facture f = new Facture();
		f.setId(id);
		f.setIdClient(idClient);
		f.setDate(date);
		f.setMontant(montant);
		return f;
	}
	
	private static int demanderSuppressionFacture(Scanner input) {
		System.out.println("Taper l'id de la facture : ");
		int idFact = input.nextInt();		
		return idFact;
	}
	
	
}
