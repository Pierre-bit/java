package employes.classes;

import employes.interfaces.Prime;

public class ProducteurProduitDangereux extends Producteur implements Prime {

	public ProducteurProduitDangereux() {
	}

	public ProducteurProduitDangereux(String name, String forname, int age, String dateEntry, int nbUnites) {
		super(name, forname, age, dateEntry, nbUnites);
	}
	
	@Override
	public double calculSalaire() {
		return super.calculSalaire()+PRIMEARISQUE;
	}

	@Override
	public String getFaille() {
		return null;
	}

}
