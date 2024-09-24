package in.co.rays.java.callable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.CallableStatement;

public class TextProcedureIn {
	
	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		CallableStatement callstmt = (CallableStatement) cnn.prepareCall("{CALL empIn(?)}");
		
		callstmt.setInt(1, 10);
		
		callstmt.execute();
		
		ResultSet rs = callstmt.getResultSet();
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
		
	}
}
