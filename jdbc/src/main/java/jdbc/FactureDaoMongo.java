package jdbc;




import java.sql.Connection;
import java.sql.Date;
import java.util.Collection;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import jdbc.interfaces.IFactureDAO;

public class FactureDaoMongo implements IFactureDAO {

	private DbConnection db = new DbConnection();
	public MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

    public String url = "mongodb://localhost:27017/FacturesDB";

    MongoDatabase db1 = mongoClient.getDatabase(url);

         MongoCollection<Document> collection = db1.getCollection("coll");

	@Override
	public boolean ajouterFacture(Facture f) {
	try {
		
		Document doc = new Document();
	    InsertOneResult  result = doc.insertOne(doc.append("id", f.getId());
        doc.append("idclient", f.getIdclient());
        doc.append("date", f.getDate());
        doc.append("montant", f.getMontant());
              System.out.println("Success! Inserted document id: " + result.getInsertedId());
       
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Erreur lors de l'insertion "+e);
		}
		return false;
	}

	@Override
	public void afficherListesFactures() {
		
	}

	@Override
	public boolean modifierFacture(Facture f) {
		return false;
	}

	@Override
	public boolean supprimerFacture(int idFacture) {
		return false;
	}

	@Override
	public void afficherFacture(int idFacture) {
		
	}

}
