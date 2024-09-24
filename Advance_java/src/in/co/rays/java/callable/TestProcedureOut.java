package in.co.rays.java.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureOut {
	
	public static void main(String[] args)throws Exception {
		
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		CallableStatement callstmt = cnn.prepareCall("{CALL empOut(?)}");
		
		callstmt.registerOutParameter(1, Types.INTEGER);
		
		callstmt.execute();
		
		int resultValue = callstmt.getInt(1);
		
		System.out.println("Result from empOut stored procedure");
		
		
		
	}catch (Exception e) {
		   e.printStackTrace();
	}
  }

}
