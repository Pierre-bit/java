package com.formation.jdbc;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class FactureDaoMongoDB implements IFactureDao {

	MongoDBConnection db = new MongoDBConnection();
	
	@Override
	public boolean ajouterFacture(Facture f) {

		try {
			MongoDatabase database = db.getConnection().getDatabase("db");
			MongoCollection<Document> coll = database.getCollection("factures");
			
			Document doc = new Document();
			doc.append("id", f.getId());
			doc.append("id_client", f.getIdClient());			
			//Pas besoin de convertir car java.sql.Date hérite de java.util.Date
			doc.append("date", f.getDate());
			doc.append("montant", f.getMontant());
			
			InsertOneResult insertStatus = coll.insertOne(doc);
			if(insertStatus.wasAcknowledged()) {
				return true;
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void afficherListeFactures() {

		try {
			MongoDatabase database = db.getConnection().getDatabase("db");
			MongoCollection<Document> coll = database.getCollection("factures");
			MongoCursor<Document> cursor = coll.find().iterator();	
			
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				Facture f = new Facture();
				f.setId(doc.getInteger("id"));
				f.setIdClient(doc.getInteger("id_client"));
				//Convertir java.util.Date à java.sql.Date
				f.setDate(new java.sql.Date(doc.getDate("date").getTime()));
				f.setMontant(doc.getDouble("montant"));
				//Appel de la méthode toString() de Facture
				System.out.println(f);				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public boolean modifierFacture(Facture f) {
		
		try {
			MongoDatabase database = db.getConnection().getDatabase("db");
			MongoCollection<Document> coll = database.getCollection("factures");
			
			Document docReplacement = new Document();
			docReplacement.append("id", f.getId());
			docReplacement.append("id_client", f.getIdClient());			
			//Pas besoin de convertir car java.sql.Date hérite de java.util.Date
			docReplacement.append("date", f.getDate());
			docReplacement.append("montant", f.getMontant());
			
			Document doc = coll.findOneAndReplace(eq("id", f.getId()), docReplacement);
			if(doc != null) {
				return true;
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean supprimerFacture(int idFacture) {
		
		try {
			MongoDatabase database = db.getConnection().getDatabase("db");
			MongoCollection<Document> coll = database.getCollection("factures");
			
			Document doc = coll.findOneAndDelete(eq("id", idFacture));
			if(doc != null) {
				return true;
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void afficherFacture(int idFacture) {
		
		try {
			MongoDatabase database = db.getConnection().getDatabase("db");
			MongoCollection<Document> coll = database.getCollection("factures");
			
			Document doc = coll.find(eq("id", idFacture)).first();
			Facture f = new Facture();
			f.setId(doc.getInteger("id"));
			f.setIdClient(doc.getInteger("id_client"));
			//Convertir java.util.Date à java.sql.Date
			f.setDate(new java.sql.Date(doc.getDate("date").getTime()));
			f.setMontant(doc.getDouble("montant"));
			//Appel de la méthode toString() de Facture
			System.out.println(f);				
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
