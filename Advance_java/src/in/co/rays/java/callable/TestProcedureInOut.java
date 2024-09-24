package in.co.rays.java.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureInOut {
	
	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		CallableStatement callstmt = cnn.prepareCall("{CALL empInOut(?)}");
		
		callstmt.setInt(1, 10);
		
		callstmt.registerOutParameter(1, Types.INTEGER);
		
		callstmt.execute();
		
		System.out.println(callstmt.getInt(1));
		
	}

}
