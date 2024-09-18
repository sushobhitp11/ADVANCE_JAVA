package in.co.rays.java.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public void add(UserBean bean) throws Exception {
		
		UserBean existBean = findByLoginId(bean.getLoginId());

		if (existBean != null) {
			throw new RuntimeException("login id already exist..!!");
		}
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getGender());
		pstmt.setString(5, bean.getLoginId());
		pstmt.setString(6, bean.getPassword());
		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(8, bean.getPhoneNo());
		pstmt.setString(9, bean.getAddress());

		int i = pstmt.executeUpdate();

		System.out.println("Data inserted => " + i);
	}

	public void update(UserBean bean) throws Exception {
		
		UserBean existBean = findByLoginId(bean.getLoginId());

		if (existBean != null &&  bean.getId() != existBean.getId()) {
			throw new RuntimeException("login id already exist..!!");
		}
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement(
				"UPDATE user SET firstName = ?, lastName = ?, gender = ?, loginId = ?, password = ?, dob = ?, phoneNo = ?, address = ? WHERE id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getGender());
		pstmt.setString(4, bean.getLoginId());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getPhoneNo());
		pstmt.setString(8, bean.getAddress());
		pstmt.setInt(9, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data updated => " + i);
	}

	public void delete(int id) throws Exception {
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("DELETE FROM user WHERE id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("Data deleted => " + i);
	}

	public UserBean findByPk(int id) throws Exception {
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("SELECT * FROM user WHERE id = ?");
		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setLoginId(rs.getString(5));
			bean.setPassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setPhoneNo(rs.getString(8));
			bean.setAddress(rs.getString(9));
		}
		return bean;
	}

	public UserBean findByLoginId(String loginId) throws Exception {
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		PreparedStatement pstmt = cnn.prepareStatement("SELECT * FROM user WHERE loginId = ?");
		pstmt.setString(1, loginId);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setGender(rs.getString(4));
			bean.setLoginId(rs.getString(5));
			bean.setPassword(rs.getString(6));
			bean.setDob(rs.getDate(7));
			bean.setPhoneNo(rs.getString(8));
			bean.setAddress(rs.getString(9));
		}
		return bean;
	}

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

		StringBuffer sql = new StringBuffer("SELECT * FROM user WHERE 1=1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" AND firstName LIKE '" + bean.getFirstName() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				sql.append(" AND dob LIKE '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" LIMIT " + pageNo + ", " + pageSize);
		}

		System.out.println("SQL => " + sql);

		PreparedStatement pstmt = cnn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		List<UserBean> list = new ArrayList<>();

		while (rs.next()) {
			UserBean resultBean = new UserBean();
			resultBean.setId(rs.getInt(1));
			resultBean.setFirstName(rs.getString(2));
			resultBean.setLastName(rs.getString(3));
			resultBean.setGender(rs.getString(4));
			resultBean.setLoginId(rs.getString(5));
			resultBean.setPassword(rs.getString(6));
			resultBean.setDob(rs.getDate(7));
			resultBean.setPhoneNo(rs.getString(8));
			resultBean.setAddress(rs.getString(9));
			list.add(resultBean);
		}
		return list;
	}
}
