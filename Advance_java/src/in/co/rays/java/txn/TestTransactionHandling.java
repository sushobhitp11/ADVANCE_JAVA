package in.co.rays.java.txn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransactionHandling {

	public static void main(String[] args) throws Exception {

		Connection cnn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			 cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			cnn.setAutoCommit(false);

			Statement stmt = cnn.createStatement();

			int i = stmt.executeUpdate("insert into marksheet values(11,111,'annu',54,65,25)");

			i = stmt.executeUpdate("insert into marksheet values(12,112,'tonu',46,25,35)");

			i = stmt.executeUpdate("insert into marksheet values(13,113,'sonu',12,65,45)");

			cnn.commit();

			System.out.println("data inserted => " + i);

		} catch (Exception e) {
			cnn.rollback();
			System.out.println("exception:" + e.getMessage());

		} finally {
			cnn.close();
		}
	}

}
