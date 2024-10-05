package in.co.rays.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.java.bean.MarksheetBean;
import in.co.rays.java.util.JDBCDataSource;

public class MarksheetModel {

	public Integer nextPk() throws Exception {

		int pk = 0;

		Connection cnn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = cnn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
		}

		JDBCDataSource.closeConnection(cnn);

		return pk + 1;
	}

	public void add(MarksheetBean bean) throws Exception {

		int pk = nextPk();

		Connection cnn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = cnn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		pstmt.setInt(1, pk);
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(cnn);

		System.out.println("data inserted =>" + i);

	}

	public void update(MarksheetBean bean) throws Exception {

		Connection cnn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = cnn.prepareStatement(
				"update marksheet set rollNo = ?,name = ?,physics = ?,chemistry = ?,maths= ?,where id  = ?");

		pstmt.setInt(1, bean.getRollNo());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(cnn);

		System.out.println("data updated => " + i);

	}

	public void delete(int id) throws Exception {

		Connection cnn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = cnn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(cnn);

		System.out.println("data deleted => " + i);

	}

	public MarksheetBean findByPk(int id) throws Exception {

		Connection cnn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = cnn.prepareStatement("select * from marksheet where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}

		JDBCDataSource.closeConnection(cnn);

		return bean;
	}

	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection cnn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1 ");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like" + bean.getName() + "%'");
			}
			if (bean.getRollNo() > 0) {
				sql.append("and rollNo = " + bean.getRollNo());
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append("limit" + pageNo + "," + pageSize);
		}
		System.out.println(" sql => " + sql);

		PreparedStatement pstmt = cnn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);

		}

		JDBCDataSource.closeConnection(cnn);

		return list;
	}

}
