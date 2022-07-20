package com.formation.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class FactureDaoJDBC implements IFactureDao {

	private JDBCConnection db = new JDBCConnection();

	@Override
	public boolean ajouterFacture(Facture f) {

		try (Connection conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO facture (id_client, date, montant) VALUES (?, ?, ?)");
			) {

			// 1er point d'intérrogation dans la query
			stmt.setInt(1, f.getIdClient());
			// 2ème point d'intérrogation dans la query
			stmt.setDate(2, f.getDate());
			// 3ème point d'intérrogation dans la query
			stmt.setDouble(3, f.getMontant());

			int nbAjouts = stmt.executeUpdate();

			return nbAjouts > 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public void afficherListeFactures() {

		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			) {

			ResultSet rs = stmt.executeQuery("SELECT id, id_client, date, montant FROM facture");
			while (rs.next()) {
				Facture f = new Facture();
				f.setId(rs.getInt("id"));
				f.setIdClient(rs.getInt("id_client"));
				f.setDate(rs.getDate("date"));
				f.setMontant(rs.getDouble("montant"));
				//Appel de la méthode toString() de Facture
				System.out.println(f);				
				/*
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getInt("id_client"));
				System.out.println(rs.getDate("date"));
				System.out.println(rs.getDouble("montant"));
				*/
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean modifierFacture(Facture f) {
		try (Connection conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("UPDATE facture SET id_client = ?, date = ?, montant = ? WHERE id = ?");
			) {

			// 1er point d'intérrogation dans la query
			stmt.setInt(1, f.getIdClient());
			// 2ème point d'intérrogation dans la query
			stmt.setDate(2, f.getDate());
			// 3ème point d'intérrogation dans la query
			stmt.setDouble(3, f.getMontant());
			// 4ème point d'intérrogation dans la query
			stmt.setInt(4, f.getId());

			int nbModifs = stmt.executeUpdate();

			return nbModifs > 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean supprimerFacture(int idFacture) {
		try (Connection conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM facture WHERE id = ?");
			) {

			// 1er point d'intérrogation dans la query
			stmt.setInt(1, idFacture);

			int nbSuppressions = stmt.executeUpdate();

			return nbSuppressions > 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public void afficherFacture(int idFacture) {
		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("SELECT id, id_client, date, montant FROM FACTURE WHERE id = ?");
			) {

			// 1er point d'intérrogation dans la query
			stmt.setInt(1, idFacture);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getInt("id_client"));
				System.out.println(rs.getDate("date"));
				System.out.println(rs.getDouble("montant"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
