package in.co.rays.java.preparedstatement.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(" delete from marksheet where id = 11");

		int i = pstmt.executeUpdate();

		System.out.println(" data deleted => " + i);
	}

}
