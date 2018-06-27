package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connection;
	private static final String databaseName = "dbaluno";
	private static final String databaseUser = "root";
	private static final String databasePwd = "";
	private static final int databasePort = 3306;
	private static final String databaseIp = "127.0.0.1";
	private static final String uriTemplate = "jdbc:mysql://%s:%s/%s";
	private static final String dbDriverClass = "com.mysql.jdbc.Driver";
	
	private DatabaseConnection() {
		
	}
	
	private static void setInstance() {
		try {
			Class.forName(dbDriverClass);
			System.out.println(
				"[INFO] DatabaseConnection.setInstance - Driver set successfully"
			);
		} catch (ClassNotFoundException e) {
			System.out.println(
				"[ERROR] DatabaseConnection.setInstance - No driver for " + dbDriverClass
			);
		}
		
		try {
			connection = DriverManager.getConnection(
				String.format(uriTemplate, databaseIp, databasePort, databaseName),
				databaseUser, databasePwd
			);
		} catch (SQLException e) {
			System.out.println(
				"[ERROR] DatabaseConnection.setInstance - SQL Exception"
			);
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			System.out.println(
				"[INFO] DatabaseConnection.getConnection - Creating connection instance"
			);
			setInstance();
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			System.out.println(
				"[ERROR] DatabaseConnection.closeConnection - SQL Exception"
			);
			e.printStackTrace();
		}
	}
}
