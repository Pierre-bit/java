package com.formation.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class JDBCConnection {

	private static final Logger log = Logger.getLogger(JDBCConnection.class.getName());
	private Connection conn = null;

	public void close() {
		if (conn != null) {
			try {
				log.info("Closing database connection");
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//log.error("Unable to close connection", e);
			}
			conn = null;
		}
	}

	public Connection getConnection() throws SQLException {
		if (conn == null) {
			log.info("Opening connection to postgresql");
			String url = "jdbc:postgresql://localhost/postgres";
			String login = "postgres";
			String password = "postgres";
			
			conn = DriverManager.getConnection(url, login, password);
			if(conn != null) {
				log.info("connection sucessful to postgresql");
			}
		}
		return conn;
	}
}
