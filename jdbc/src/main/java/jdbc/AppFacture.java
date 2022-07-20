package jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.interfaces.IFactureDAO;

public class AppFacture {

	public static void main(String[] args) throws SQLException {
		IFactureDAO dao = new FactureDaoJDBC();
		
		Scanner sc = new Scanner(System.in);
		
		boolean isRunning = true;
		while(isRunning)
		{
			afficherMenu();
			String line = sc.nextLine();
			switch (line.toLowerCase())
			{
				case "exit":
					isRunning = false;
					break;
				case "1" :
					dao.afficherListesFactures();
					break;
				case "2" :
					int idFactures = demanderIdFacture(sc);
					dao.afficherFacture(idFactures);
					break;
				case "3":
					Facture fact = demanderAjoutFacture(sc);
					if (dao.ajouterFacture(fact))
					{
						System.out.println("Facture bien insérer");
					}
					else
					{
						System.out.println("Echec de l'insertion de la facture");
					}
					break;
				case "4":
					Facture fact1 = DemandeModificationFacture(sc);
					dao.modifierFacture(fact1);
					if (dao.modifierFacture(fact1))
					{
						System.out.println("Facture bien modifier");
					}
					else
					{
						System.out.println("Echec de la modification de la facture");
					}
					break;
				case "5":
					int idFactures1 = demanderIdFacture(sc);
					dao.supprimerFacture(idFactures1);
					if (dao.supprimerFacture(idFactures1))
					{
						System.out.println("Facture bien supprimer");
					}
					else
					{
						System.out.println("Echec de la suppresion de la facture");
					}
					break;
			}		
		}

	}
	private static Facture DemandeModificationFacture(Scanner sc) {
		System.out.println("Taper l'id de la facture :  ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Taper l'id du client de la facture :  ");
		int idClient = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Taper la date de la facture (yyyy-mm-dd) :  ");
		String dateStr = sc.next();
		Date date = Date.valueOf(dateStr);
		
		System.out.println("Taper le montant de la facture :  ");
		double montant = sc.nextDouble();
		
		
		Facture f = new Facture();
		f.setId(id);
		f.setIdClient(idClient);
		f.setDateEntree(date);
		f.setMontant(montant);
		//System.out.println(dateFormatter.format(localDate));
		return f;
		
	}
	private static Facture demanderAjoutFacture(Scanner sc) {
		
		System.out.println("Taper l'id du client de la facture :  ");
		int idClient = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Taper la date de la facture (yyyy-mm-dd) :  ");
		String dateStr = sc.next();
		Date date = Date.valueOf(dateStr);
		
		System.out.println("Taper le montant de la facture :  ");
		double montant = sc.nextDouble();
		
		Facture f = new Facture();
		f.setIdClient(idClient);
		f.setDateEntree(date);
		f.setMontant(montant);
		//System.out.println(dateFormatter.format(localDate));
		return f;
	}
	private static int demanderIdFacture(Scanner sc) {
		 System.out.println("Donner l'identifiant de la facture");
		 return sc.nextInt();
	}
	private static void afficherMenu()
	{
		System.out.println("Choisir dans le menu");
		System.out.println(" 1 - Afficher la liste des factures");
		System.out.println(" 2 - Afficher une facture(id)");
		System.out.println(" 3 - Ajouter une facture");
		System.out.println(" 4 - Modifier une facture");
		System.out.println(" 5 - Supprimer une facture");
		System.out.println(" Choisir votre base de données(PostgreSQL ou MongoDB ");
		System.out.println("EXIT");
	}

}
