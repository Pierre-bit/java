package com.formation.jdbc;

import java.util.logging.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBConnection {

	private static final Logger log = Logger.getLogger(MongoDBConnection.class.getName());
	private MongoClient conn = null;

	public void close() {
		if (conn != null) {
			log.info("Closing database connection");
			conn.close();
			conn = null;
		}
	}

	public MongoClient getConnection() {
		if (conn == null) {
			log.info("Opening connection to mongodb");
			String url = "mongodb://localhost:27017";
			//String login = "root";
			//String password = "root";
			
			conn = MongoClients.create(url);
			if(conn != null) {
				log.info("connection sucessful to mongodb");
			}
		}
		return conn;
	}
}
