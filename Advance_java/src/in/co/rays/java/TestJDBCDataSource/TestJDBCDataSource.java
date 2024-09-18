package in.co.rays.java.TestJDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.java.util.JDBCDataSource;

public class TestJDBCDataSource {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i <= 50; i++) {

			System.out.println("Connection = " + i);

			testGet();
		}
	}

	private static void testGet() throws Exception {

		Connection cnn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = cnn.prepareStatement("select * from marksheet where id = 10");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
		
		JDBCDataSource.closeConnection(cnn);

	}

}
