package employes.classes;

abstract public class Employes {
	
	private String name;
	private String forname;
	private int age;
	private String dateEntry;
	
	
	public Employes() {
		super();
	}

	public Employes(String name, String forname, int age, String dateEntry) {
		super();
		this.name = name;
		this.forname = forname;
		this.age = age;
		this.dateEntry = dateEntry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForname() {
		return forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateEntry() {
		return dateEntry;
	}

	public void setDateEntry(String dateEntry) {
		this.dateEntry = dateEntry;
	}

	@Override
	public String toString() {
		return "Liste des salaires des employés:"
				+ "L'employé " + name + " "
				+ forname + " a un salaire de "
				+ calculSalaire() + "€";
	}
	
	abstract public double calculSalaire();
	
	
	
	
	

}
