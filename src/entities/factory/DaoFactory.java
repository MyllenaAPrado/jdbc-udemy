package entities.factory;

import db.DB;
import entities.JDBC.DepartmentDaoJDBC;
import entities.JDBC.SellerDaoJDBC;
import interfaces.DepartmentDao;
import interfaces.SellerDao;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC();
	}
	
}
