package in.co.rays.java.rb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {
	
	private static JDBCDataSource jds = null ;
	
	private ComboPooledDataSource cpds = null;
	
	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.java.bundle.system");

	public JDBCDataSource() {
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setInitialPoolSize(Integer.parseInt("initalpoolsize"));
			cpds.setAcquireIncrement(Integer.parseInt("acquireincrement"));
			cpds.setMaxPoolSize(Integer.parseInt("maxpoolsize"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static JDBCDataSource getInstance() {
		if(jds == null) {
			jds = new JDBCDataSource();
		}
		return jds;
	}
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		}catch (SQLException e) {
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

