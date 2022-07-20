package employes.classes;

import employes.interfaces.Prime;

public class ManutentionnaireProduitDangereux extends Manutentionnaire implements Prime {

	public ManutentionnaireProduitDangereux() {
	}

	public ManutentionnaireProduitDangereux(String name, String forname, int age, String dateEntry, int nbHeures) {
		super(name, forname, age, dateEntry, nbHeures);
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
