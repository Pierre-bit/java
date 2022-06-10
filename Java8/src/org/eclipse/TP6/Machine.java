package org.eclipse.TP6;

public class Machine  {

	
	private int year;
	private String name;
	
	public Machine() {
	}

	public Machine(int year, String name) {
		this.year = year;
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Machine [year=" + year + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
}
