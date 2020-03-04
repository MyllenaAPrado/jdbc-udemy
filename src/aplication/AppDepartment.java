package aplication;

import java.text.ParseException;

import entities.Department;
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

	}

}
