package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class App {

	public static void main(String[] args) throws SQLException {
		//readClients();
		
		Client client = new Client();
		client.setPrenom("Winnie");
		client.setNom("Ourson");
		client.setDateEntree(new Date(new GregorianCalendar(1993, 9, 3).getTimeInMillis()));
		//writeClient(client);
		writeClientWithPreparedStatement(client);
		
		readClientsWithPreparedStatement("Winnie", "Ourson");
		DeleteClientWithPreparedStatement(client, 19);
	}

	public static void readClients() throws SQLException {

		DbConnection db = new DbConnection();

		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection()) {

			Statement stm = conn.createStatement();

			List<Client> lclients = new ArrayList<>();

			// Ex�cuter une requ�te SQL
			// de type lecture donc de type Query
			String query = "SELECT * FROM client";
			ResultSet rs = stm.executeQuery(query);
			// It�rer sur les lignes de r�sultats
			while (rs.next()) {
				/*
				 * int id = rs.getInt(0); //Colonne de l'index 0 String prenom =
				 * rs.getString(1); //Colonne de l'index 1 String nom = rs.getString(2);
				 * //Colonne de l'index 2 Date dateEntree = rs.getDate(3); //Colonne de l'index
				 * 3
				 */
				int id = rs.getInt("id"); // Colonne id
				String prenom = rs.getString("prenom"); // Colonne prenom
				String nom = rs.getString("nom"); // Colonne nom
				Date dateEntree = rs.getDate("date_entree"); // Colonne date_entree
				// System.out.println(id + " - " + prenom + " - " + nom + " - " + dateEntree);

				Client client = new Client();
				client.setId(id);
				client.setPrenom(prenom);
				client.setNom(nom);
				client.setDateEntree(dateEntree);

				lclients.add(client);

			}

			lclients.stream().forEach(cl -> System.out.println(cl));

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	
	public static void readClientsWithPreparedStatement(String prenomParam, String nomParam) throws SQLException {

		DbConnection db = new DbConnection();

		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection()) {


			List<Client> lclients = new ArrayList<>();

			// Ex�cuter une requ�te SQL
			// de type lecture donc de type Query
			String query = "SELECT * FROM client WHERE prenom = ? AND nom = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			//ATTENTION ON COMMENCE l'INDEX A 1
			//1er point d'int�rrogation dans la query
			stm.setString(1, prenomParam);
			//2�me point d'int�rrogation dans la query
			stm.setString(2, nomParam);
			
			ResultSet rs = stm.executeQuery();
			// It�rer sur les lignes de r�sultats
			while (rs.next()) {
				/*
				 * int id = rs.getInt(0); //Colonne de l'index 0 String prenom =
				 * rs.getString(1); //Colonne de l'index 1 String nom = rs.getString(2);
				 * //Colonne de l'index 2 Date dateEntree = rs.getDate(3); //Colonne de l'index
				 * 3
				 */
				int id = rs.getInt("id"); // Colonne id
				String prenom = rs.getString("prenom"); // Colonne prenom
				String nom = rs.getString("nom"); // Colonne nom
				Date dateEntree = rs.getDate("date_entree"); // Colonne date_entree
				// System.out.println(id + " - " + prenom + " - " + nom + " - " + dateEntree);

				Client client = new Client();
				client.setId(id);
				client.setPrenom(prenom);
				client.setNom(nom);
				client.setDateEntree(dateEntree);

				lclients.add(client);

			}

			lclients.stream().forEach(cl -> System.out.println(cl));

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	
	public static void writeClient(Client cl) throws SQLException {

		DbConnection db = new DbConnection();

		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection()) {

			Statement stm = conn.createStatement();


			// Ex�cuter une requ�te SQL
			// de type �criture 
			String query = "INSERT INTO client (prenom, nom, date_entree) VALUES ("
					+ "'" + cl.getPrenom() + "'," 
					+ "'" + cl.getNom() + "'," 
					+ "'" + cl.getDateEntree() + "'" 
					+ ")";
			System.out.println("REQUETE SQL : " + query);
			int nbRecords = stm.executeUpdate(query);
			
			if(nbRecords > 0) {
				System.out.println("L'insertion a bien ete execute");				
			} else {
				System.out.println("Probleme avec l'insertion");								
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	public static void writeClientWithPreparedStatement(Client cl) throws SQLException {

		DbConnection db = new DbConnection();

		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection()) {

			// Ex�cuter une requite SQL
			// de type �criture avec une query param�tr�
			String query = "INSERT INTO client (prenom, nom, date_entree) "
					+ " VALUES (?,?,?)";
			System.out.println("REQUETE SQL : " + query);
			PreparedStatement stm = conn.prepareStatement(query);
			//ATTENTION ON COMMENCE l'INDEX A 1
			//1er point d'int�rrogation dans la query
			stm.setString(1, cl.getPrenom());
			//2�me point d'int�rrogation dans la query
			stm.setString(2, cl.getNom());
			//3�me point d'int�rrogation dans la query
			stm.setDate(3, cl.getDateEntree());

			int nbRecords = stm.executeUpdate();
			
			if(nbRecords > 0) {
				System.out.println("L'insertion a bien ete execute");				
			} else {
				System.out.println("Probleme avec l'insertion");								
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void DeleteClientWithPreparedStatement(Client cl,int id) throws SQLException
	{
		DbConnection db = new DbConnection();

		// try with ressources
		/*
		 * equivalent try { Connection c = db.getConnection() } finally { c.close(); }
		 */
		try (Connection conn = db.getConnection()) {

			// Ex�cuter une requite SQL
			// de type �criture avec une query param�tr�
			String query = "DELETE FROM client WHERE id = ? ";
			System.out.println("REQUETE SQL : " + query);
			PreparedStatement stm = conn.prepareStatement(query);
			//ATTENTION ON COMMENCE l'INDEX A 1
			//1er point d'int�rrogation dans la query
			stm.setInt(1, id);

			stm.executeUpdate();
			if (id == cl.getId() )
			{
				System.out.println("La ligne a bien été supprimé");				
			}
			else
			{
				System.out.println("id introuvable");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
