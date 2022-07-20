package employes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import employes.classes.Employes;
import employes.classes.Manutentionnaire;
import employes.classes.ManutentionnaireProduitDangereux;
import employes.classes.Producteur;
import employes.classes.ProducteurProduitDangereux;
import employes.classes.Representant;
import employes.classes.Staff;
import employes.classes.Vendeur;
import employes.interfaces.Prime;
import junit.framework.Assert;

public class EmployesTest {

	private Vendeur vend;
	private Staff staff;
	
	@Before
	public void setup()
	{
		vend = new Vendeur();
		staff= new Staff();
	}
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void TestGetFaille()
	{
		Prime prime = Mockito.mock(Prime.class);
		Assert.assertNull("Test getFaille avec mock", prime.getFaille());
	}
	@Test
	public void testGetTurnover()
	{
		staff.add(new Vendeur("Pierre", "Business", 45, "1995", 30000));
		assertEquals("le chiffre d'affaire est de ",vend.get_turnover(),30000);
	}
	
	@Test
	public void testCalculSalaire()
	{
		
		double resultatObtenue = vend.calculSalaire();
		assertEquals("Salaire moyen est de ",6400.0,resultatObtenue);
	}
	@Test
	public void testCalculerAverageSalary()
	{
		staff.add(new Vendeur("Pierre", "Business", 45, "1995", 30000));
	    staff.add(new Representant("Leon", "Ventout", 25, "2001", 20000));
	    staff.add(new Producteur("Yves", "Ahalouest", 28, "1998", 1000));
	    staff.add(new Manutentionnaire("Jeanne", "Stoktout", 32, "1998", 45));
	    staff.add(new ProducteurProduitDangereux("Jean", "Flippe", 28, "2000", 1000));
	    staff.add(new ManutentionnaireProduitDangereux("Al", "Abordage", 30, "2001", 45));
	    
	    double valeurAttendue = 4575.0;
	    Assert.assertEquals("testCalculerAverageSalary ", valeurAttendue, staff.calculMoyenneSalaire(),0.0001);
	}
	
	

}
