package org.formation.hibernate.entity;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String street;
	private String city;
	private Long zipcode;
	
	public Adresse() {
		super();
	}

	public Adresse(String street, String city, Long zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Adresse [street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(city, other.city) && Objects.equals(street, other.street)
				&& Objects.equals(zipcode, other.zipcode);
	}	
	
}
