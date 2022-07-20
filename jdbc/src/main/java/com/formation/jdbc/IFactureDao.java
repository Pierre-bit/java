package com.formation.jdbc;

public interface IFactureDao {

	boolean ajouterFacture(Facture f);

	void afficherListeFactures();

	boolean modifierFacture(Facture f);

	boolean supprimerFacture(int idFacture);

	void afficherFacture(int idFacture);

}