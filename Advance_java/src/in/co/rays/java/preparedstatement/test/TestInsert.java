package in.co.rays.java.preparedstatement.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("insert into marksheet values(11,111,'chg',88,95,73)");

		int i = pstmt.executeUpdate();

		System.out.println(" data inserted => " + i);

	}

}
