package in.co.rays.java.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Four steps to make a class singleton.

//1.Make class final so that child class cannot be created for single class.
public final class JDBCDataSource {

	private static JDBCDataSource jds = null;

	private ComboPooledDataSource cpds = null;
	
//2. Make default constructor private so that no one other class can instantiate single class.
	
	private JDBCDataSource() {

		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/advance_java");
			cpds.setUser("root");
			cpds.setPassword("root");
			cpds.setInitialPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(30);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
//3.Declare a static variable of self type in single class . Static variables have only one copy in their lifetime .
	
//4.Make a getInsatance() static method in singleton class that will return instance of same single class .
	
	public static JDBCDataSource getInstance() {

		if (jds == null) {
			
			jds = new JDBCDataSource();
		}
		return jds;
	}

	public static Connection getConnection() {
		
		try {
			
			return getInstance().cpds.getConnection();
			
		} catch (Exception e) {
			
			return null;
		}
	}

	public static void closeConnection(Connection cnn, Statement stmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (cnn != null) {
				cnn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection(Connection cnn, Statement stmt) {
		closeConnection(cnn, stmt, null);
	}

	public static void closeConnection(Connection cnn) {
		closeConnection(cnn, null);
	}
}