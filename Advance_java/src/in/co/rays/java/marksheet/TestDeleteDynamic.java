package in.co.rays.java.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestDeleteDynamic {

	public static void main(String[] args) throws Exception {

		testDelete1();
		testDelete2();
		testDelete3(10);

	}

	public static void testDelete1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("delete from marksheet where id = 2");

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);

	}

	public static void testDelete2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(" delete from marksheet where id = ?");

		pstmt.setInt(1, 5);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);

	}

	public static void testDelete3(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(" deleted from marksheet where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted => " + i);

	}
}
