package in.co.rays.java.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestInsertDynamic {

	public static void main(String[] args) throws Exception {

		testInsert1();
		testInsert2();
		testInsert3(14, 114, "sumit", 45, 58, 87);

		MarksheetBean bean = new MarksheetBean();

		bean.setId(19);
		bean.setRollno(119);
		bean.setName("prshun");
		bean.setPhysics(65);
		bean.setChemistry(61);
		bean.setMaths(56);

		testInsert4(bean);

	}

	public static void testInsert1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("insert into marksheet values(15,115,'shyam',55,64,73)");

		int i = pstmt.executeUpdate();

		System.out.println(" data inserted => " + i);
	}

	public static void testInsert2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		pstmt.setInt(1, 17);
		pstmt.setInt(2, 117);
		pstmt.setString(3, "rohit");
		pstmt.setInt(4, 77);
		pstmt.setInt(5, 65);
		pstmt.setInt(6, 89);

		int i = pstmt.executeUpdate();

		System.out.println(" data inserted => " + i);
	}

	public static void testInsert3(int id, int rollno, String name, int physics, int chemistry, int maths)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(" insert into marksheet values(?,?,?,?,?,?)");

		pstmt.setInt(1, id);
		pstmt.setInt(2, rollno);
		pstmt.setString(3, name);
		pstmt.setInt(4, physics);
		pstmt.setInt(5, chemistry);
		pstmt.setInt(6, maths);

		int i = pstmt.executeUpdate();

		System.out.println("data inserted => " + i);
	}

	public static void testInsert4(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(" insert into marksheet values(?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setInt(2, bean.getRollno());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println(" data inserted => " + i);
	}
}
