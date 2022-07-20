package employes.classes;

public class Vendeur extends Employes {

	private int _turnover;
	final static private int PRIME= 400;
	final static private double POURCENTAGE = 0.2;
		
	public Vendeur() {
	}

	public Vendeur(String name, String forname, int age, String dateEntry,int turnover) {
		super(name, forname, age, dateEntry);
		this._turnover= turnover;
	}
	
	
	

	public int get_turnover() {
		return _turnover;
	}

	@Override
	public double calculSalaire() {
		return (get_turnover()*POURCENTAGE) + PRIME;
	}

	

}
