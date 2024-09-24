package in.co.rays.java.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoreFunction {
	
	public static void main(String[] args)throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");
		
		CallableStatement callstmt = cnn.prepareCall("{?= CALL square(?)}");
		
		callstmt.setInt(2,10000);
		
		callstmt.registerOutParameter(1, Types.INTEGER);
		
		callstmt.execute();
		
		System.out.println(" square" + callstmt.getInt(1));
	}

}
