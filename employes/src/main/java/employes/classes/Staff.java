package employes.classes;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class Staff {

	private List<Employes> listemp = new ArrayList();
	
	public Staff() {
		
		
	}
	public void add(Employes employes)
	{
		listemp.add(employes);
		//LocalDate LocalDate = new LocalDate();
	}
	
	public void displaySalaries()
	{
		System.out.println("listes des salaires des employes :");
		for (Employes emp: listemp)
		{
			System.out.println(	
					emp.getName()
					+ " "+ emp.getForname()+ "a un salaire de "+emp.calculSalaire()+ "€");
		}
		
	}
	
	
	

	public void displayAverageSalary()
	{
		
			System.out.println("Le salaire moyen est de  "+calculMoyenneSalaire()+"€");

	}
	public double calculMoyenneSalaire()
	{
		double sum = 0;
		for (Employes emp : listemp)
		{
			sum += emp.calculSalaire();
		}
		return sum/listemp.size();
	}

	
}
