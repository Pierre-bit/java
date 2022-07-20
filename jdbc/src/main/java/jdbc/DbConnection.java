package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.sql.DriverManager;



public class DbConnection {

	private static final Logger log = Logger.getLogger(DbConnection.class.getName());
	private Connection conn = null;

	public void close() {
		if (conn != null ) {
			try {
				log.info("Closing database connection to sampleDB");
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//log.error("Unable to close connection", e);
			}
			conn = null;
		}
	}

	public Connection getConnection() throws SQLException {
		if (conn == null|| conn.isClosed()) {
			log.info("Opening connection to postgresql");
			String url = "jdbc:postgresql://localhost/postgres";
			String login = "postgres";
			String password = "admin";
			
			conn = DriverManager.getConnection(url, login, password);
			if(conn != null) {
				log.info("connection sucessful to postgresql");
			}
		}
		return conn;
	}
	
	
	public Connection getConnectionMongo() {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        if (conn == null) {
            log.info("Opening connection to MongoDB");
            String url = "mongodb://localhost:27017/FacturesDB";

            MongoDatabase db = mongoClient.getDatabase(url);

            MongoCollection<Document> collection = db.getCollection("coll");


        }
        return conn;
    }

	
}


