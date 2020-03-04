package aplication;

import java.text.ParseException;

import entities.Department;
import entities.Seller;
import entities.factory.DaoFactory;
import interfaces.DepartmentDao;

public class AppDepartment {

	public static void main(String[] args) throws ParseException {

		// for create a sellerDao and hide the method
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		// insert method
		System.out.println("=== Teste 1: ===");
		Department department = new Department(0, "Filmes");
		departmentDao.insert(department);

		// delete method
		System.out.println();
		System.out.println("=== Teste 2: ===");
		departmentDao.deleteById(7);
		System.out.println("Delete completed");

		// findById method
		System.out.println("=== Teste 3: ===");
		department = departmentDao.findById(2);
		System.out.println(department);

	}

}
