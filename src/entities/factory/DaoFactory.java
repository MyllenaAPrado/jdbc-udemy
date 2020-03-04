package entities.factory;

import entities.JDBC.DepartmentDaoJDBC;
import entities.JDBC.SellerDaoJDBC;
import interfaces.DepartmentDao;
import interfaces.SellerDao;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC();
	}
	
}
