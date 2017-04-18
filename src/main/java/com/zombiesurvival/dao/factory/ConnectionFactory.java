package com.zombiesurvival.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/ZombieSurvival";
			Properties props = new Properties();
			props.setProperty("user","lucas");
			props.setProperty("password","12345678");
			Connection conn = DriverManager.getConnection(url, props);
			
			return conn;
		}catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
