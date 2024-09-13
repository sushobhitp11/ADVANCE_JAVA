package in.co.rays.java.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdateDynamic {

	public static void main(String[] args) throws Exception {

		testUpdate1();
		testUpdate2();
		testUpdate3(117, "ubon", 45, 85, 69, 17);

		MarksheetBean bean = new MarksheetBean();
		bean.setId(25);
		bean.setRollno(225);
		bean.setName("apple");
		bean.setPhysics(25);
		bean.setChemistry(34);
		bean.setMaths(49);

		testUpdate4(bean);

	}

	public static void testUpdate1() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(
				"update marksheet set rollno = 108,name = 'jkl',physics = 36,chemistry = 56, maths = 58 where id = 8 ");

		int i = pstmt.executeUpdate();

		System.out.println(" data updated => " + i);

	}

	public static void testUpdate2() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(
				" update marksheet set rollno = ?,name = ?,physics = ?,chemistry =?,maths =? where id =?");

		pstmt.setInt(1, 102);
		pstmt.setString(2, "anu");
		pstmt.setInt(3, 45);
		pstmt.setInt(4, 45);
		pstmt.setInt(5, 75);
		pstmt.setInt(6, 2);

		int i = pstmt.executeUpdate();

		System.out.println("data updated => " + i);

	}

	public static void testUpdate3(int rollno, String name, int physics, int chemistry, int maths, int id)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(
				"update marksheet set rollno = ? , name = ? , physics = ? , chemistry = ?, maths = ?  where id = ?");

		pstmt.setInt(1, rollno);
		pstmt.setString(2, name);
		pstmt.setInt(3, physics);
		pstmt.setInt(4, chemistry);
		pstmt.setInt(5, maths);
		pstmt.setInt(6, id);

		int i = pstmt.executeUpdate();

		System.out.println(" data updated => " + i);

	}

	public static void testUpdate4(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(
				" update marksheet set rollno = ?, name = ? ,physics =? , chemistry = ? , maths = ?  where id = ? ");

		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(" data updated => " + i);

	}
}
