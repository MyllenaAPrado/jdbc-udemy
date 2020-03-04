package entities.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Department;
import entities.Seller;
import interfaces.SellerDao;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int it) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			//querrie for find the seller and the result of the search
			st = conn.prepareStatement(
					"SELECT seller.*,department.name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			
			//check if it's not null the result
			if (rs.next()) {
				
				//created a new department and  new seller
				Department department = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
				Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"),rs.getString("Email"),rs.getDate("BirthDate"),rs.getDouble("BaseSalary"), department);
				
				return seller;
			}
			
			
			//return null if don't find the seller
			return null;
			
		} catch (SQLException e) {
			
			throw new DbException(e.getMessage());
			
		} finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findByDepartment(String nameDepartment) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			List<Seller> listSeller = new ArrayList<Seller>();
			
			//querrie for find the seller and the result of the search
			st = conn.prepareStatement(
									"SELECT seller.*,department.Name as DepName "
									+"FROM seller INNER JOIN department "
									+"ON seller.DepartmentId = department.Id "
									+"WHERE department.name = ?");
			
			st.setString(1, nameDepartment);
			rs = st.executeQuery();
			
			//check if it's not null the result
			while (rs.next()) {
				
				//created a new department and  new seller
				Department department = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));
				Seller seller = new Seller(rs.getInt("Id"), rs.getString("Name"),rs.getString("Email"),rs.getDate("BirthDate"),rs.getDouble("BaseSalary"), department);
				listSeller.add(seller);
				
			}
			
			if(listSeller.isEmpty()) {
				//return null if don't find the seller
				return null;
			}
			return listSeller;
			
		} catch (SQLException e) {
			
			throw new DbException(e.getMessage());
			
		} finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
