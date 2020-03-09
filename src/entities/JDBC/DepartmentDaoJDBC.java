package entities.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Department;
import interfaces.DepartmentDao;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department department) {
		PreparedStatement st = null;

		try {
			// query for insert the seller
			st = conn.prepareStatement("INSERT INTO department " + "(Name )" + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, department.getName());

			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {

				System.out.println("Done! Rows affected:" + rowsAffected);
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					int id = rs.getInt(1);
					department.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new SQLException("Unexpected error!");
			}

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Department department) {
		PreparedStatement st = null;

		try {

			// querrie for uptade the department
			st = conn.prepareStatement("UPDATE department " + "SET Name = ? " + "WHERE ID = ?");

			st.setString(1, department.getName());
			st.setInt(2, department.getId());

			st.executeUpdate();

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(int id) {
		PreparedStatement st = null;
		try {
			// querie for delete the department
			st = conn.prepareStatement("DELETE FROM department " + "WHERE Id = ?");
			st.setInt(1, id);

			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Done! Rows affected:" + rowsAffected);

			} else {
				throw new SQLException("Unexpected error!");

			}
		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public Department findById(int id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			// query for find the department and the result of the search
			st = conn.prepareStatement("SELECT * FROM department " + "WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			// check if it's not null the result
			if (rs.next()) {

				// created a new department
				Department department = new Department(rs.getInt("Id"), rs.getString("Name"));
				return department;
			}

			// return null if don't find the department
			return null;

		} catch (SQLException e) {

			throw new DbException(e.getMessage());

		} finally {

			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			// querrie for find the seller and the result of the search
			st = conn.prepareStatement("select * from department");
			rs = st.executeQuery();
			List<Department> list = new ArrayList<>(); 
			while(rs.next()) {
				Department dep = new Department(rs.getInt("Id"), rs.getString("Name"));
				list.add(dep);
			}
			if(list.isEmpty()) {
				return null;
				
			}else {
				return list;
			}
		
		}catch (SQLException e) {
	
			throw new DbException(e.getMessage());
	
		} finally {
	
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

}
}
