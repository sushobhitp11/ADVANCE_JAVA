package in.co.rays.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn =DriverManager.getConnection("jdbc:mysql://localhost:3306/Advance_java","root", "root");
		
		Statement stmt = cnn.createStatement();
		
		int i = stmt.executeUpdate(" insert into emp values(12,'new',7000,1)");
		
		System.out.println("data inserted =>" + i );
		
	}

}
