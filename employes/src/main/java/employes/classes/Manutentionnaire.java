package employes.classes;

public class Manutentionnaire extends Employes {

	final static private int TAUX_MANUTENTIONNAIRE = 65;
	private int _nbHeures;
	
	public Manutentionnaire() {
	}

	public Manutentionnaire(String name, String forname, int age, String dateEntry,int nbHeures) {
		super(name, forname, age, dateEntry);
		this._nbHeures = nbHeures;
	}

	
	public int get_nbHeures() {
		return _nbHeures;
	}

	@Override
	public double calculSalaire() {
		return get_nbHeures()*TAUX_MANUTENTIONNAIRE;
	}

}
