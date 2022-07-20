package jdbc;

import java.sql.Date;

public class Facture {

	private int id;
	private int idClient;
	private Date dateEntree;
	private Double montant;

	

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getDateEntree() {
		return dateEntree;
	}


	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Facture [idClient=" + idClient + ", dateEntree=" + dateEntree + ", montant=" + montant + "]";
	}

	
	


	

}
