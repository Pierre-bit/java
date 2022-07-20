package employes.main;

import org.joda.time.LocalDate;

import employes.classes.Manutentionnaire;
import employes.classes.ManutentionnaireProduitDangereux;
import employes.classes.Producteur;
import employes.classes.ProducteurProduitDangereux;
import employes.classes.Representant;
import employes.classes.Staff;
import employes.classes.Vendeur;

public class Main {

	

	public static void main(String[] args) {
		  final Staff myEmployees = new Staff();
		    myEmployees.add(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		    myEmployees.add(new Representant("Leon", "Ventout", 25, "2001", 20000));
		    myEmployees.add(new Producteur("Yves", "Ahalouest", 28, "1998", 1000));
		    myEmployees.add(new Manutentionnaire("Jeanne", "Stoktout", 32, "1998", 45));
		    myEmployees.add(new ProducteurProduitDangereux("Jean", "Flippe", 28, "2000", 1000));
		    myEmployees.add(new ManutentionnaireProduitDangereux("Al", "Abordage", 30, "2001", 45));
		    
		    myEmployees.displaySalaries();
		    myEmployees.displayAverageSalary();
		    LocalDate LocalDate = new LocalDate();
		    System.out.println(LocalDate);
		  }
	}


