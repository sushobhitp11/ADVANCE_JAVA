package in.co.rays.java.TestJDBCDataSource;

import java.util.ResourceBundle;

public class TestResourceBundleApp {


	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.java.bundle.app");

		System.out.println(rb.getString("greeting"));
		System.out.println(rb.getString("hello"));

	}

}

