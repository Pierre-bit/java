package jdbc.interfaces;

import jdbc.Facture;

public interface IFactureDAO {

	boolean ajouterFacture(Facture f);
	void afficherListesFactures();
	boolean modifierFacture(Facture f);
	boolean supprimerFacture(int idFacture);
	void afficherFacture( int idFacture);

}
