package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.interfaces.IFactureDAO;

public class FactureDaoJDBC implements IFactureDAO {
	
	private DbConnection db = new DbConnection();


	@Override
	public boolean ajouterFacture(Facture f) {
		try(Connection conn= db.getConnection();
			PreparedStatement stmt = conn.prepareStatement
					("INSERT INTO facture(id_client,date,montant) VALUES(?,?,?)"))
		{
			stmt.setInt(1,f.getIdClient());
			stmt.setDate(2, f.getDateEntree());
			stmt.setDouble(3,f.getMontant());
			int nbAjouts = stmt.executeUpdate();
			
			
			return nbAjouts>0;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void afficherListesFactures() {
		try(Connection conn= db.getConnection();
				Statement stmt = conn.createStatement())
		{
			String query = "SELECT * FROM facture";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				Facture f= new Facture();
				f.setId(rs.getInt("id"));
				f.setIdClient(rs.getInt("id_client"));
				f.setDateEntree(rs.getDate("date"));
				f.setMontant(rs.getDouble("montant"));
				
				System.out.println(f);
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}


	@Override
	public boolean modifierFacture(Facture f) {
		try (Connection conn = db.getConnection();
				PreparedStatement stmt = conn.prepareStatement("UPDATE facture SET id_client = ? , date = ?,montant = ? WHERE id = ? "))
		{
			stmt.setInt(1,f.getIdClient());
			stmt.setDate(2,f.getDateEntree());
			stmt.setDouble(3, f.getMontant());
			stmt.setInt(4, f.getId());
			int nbModifs= stmt.executeUpdate();
			return nbModifs > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;

	}


	@Override
	public boolean supprimerFacture(int idFacture) {
		try (Connection conn = db.getConnection())
		{
			String query = "DELETE FROM facture WHERE id = ? ";
			PreparedStatement stmt = conn.prepareStatement(query);
			//ATTENTION ON COMMENCE l'INDEX A 1
			//1er point d'int�rrogation dans la query
			stmt.setInt(1, idFacture);
			int nbSuppression= stmt.executeUpdate();
			return nbSuppression > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	}

	@Override
	public void afficherFacture(int idFacture) {
		try(Connection conn= db.getConnection();
				PreparedStatement stmt = conn.prepareStatement
						("SELECT * FROM facture where id = ?"))
			{
				stmt.setInt(1, idFacture);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					Facture f= new Facture();
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getInt("id_client"));
					System.out.println(rs.getDate("date"));
					System.out.println(rs.getDouble("montant"));
					
				}			
				stmt.close();
	
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
}
