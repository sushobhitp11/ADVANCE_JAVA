package in.co.rays.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete { 
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java","root","root");
		
		Statement stmt = cnn.createStatement();
		
		int i = stmt.executeUpdate("delete from emp where id = 2");
		
		System.out.println(" data deletes =>" + i);
		
		
	}

}
