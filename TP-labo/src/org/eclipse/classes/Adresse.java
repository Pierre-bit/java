package org.eclipse.classes;

public class Adresse {

	private int id;
	private String street;
	private int zipCode;
	private String city;
	private static int count;
	
	public Adresse() {

	}
	
	public Adresse(String street,String city,int zipCode) {
		this.id = ++count;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public int getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return street+ " "+zipCode+" "+city;
	}
	
	
}
