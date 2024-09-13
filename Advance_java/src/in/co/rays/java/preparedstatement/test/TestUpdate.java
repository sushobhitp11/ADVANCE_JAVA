package in.co.rays.java.preparedstatement.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		PreparedStatement pstmt = cnn.prepareStatement(" update marksheet set name = 'ram' where id = 1");
		
		int i = pstmt.executeUpdate();
		
		System.out.println("data updated => " + i);
	}

}
