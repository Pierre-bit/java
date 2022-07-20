package employes.classes;

public class Producteur extends Employes  {

	private int _nbUnites ;
	final static private int TAUX_PRODUCTION = 5;
	
	public Producteur() {
	}

	public Producteur(String name, String forname, int age, String dateEntry,int nbUnites) {
		super(name, forname, age, dateEntry);
		this._nbUnites=nbUnites;
	}
	
	public int get_nbUnites() {
		return _nbUnites;
	}

	@Override
	public double calculSalaire() {
		return get_nbUnites()*TAUX_PRODUCTION;
	}
	

}
