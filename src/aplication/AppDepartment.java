package aplication;

import java.text.ParseException;
import java.util.List;

import entities.Department;
import entities.factory.DaoFactory;
import interfaces.DepartmentDao;

public class AppDepartment {

	public static void main(String[] args) throws ParseException {

		// for create a sellerDao and hide the method
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		// insert method
		System.out.println("=== Teste 1: ===");
		Department department = new Department(0, "moda");
		departmentDao.insert(department);

		// delete method
		System.out.println();
		System.out.println("=== Teste 2: ===");
		departmentDao.deleteById(8);
		System.out.println("Delete completed");

		// findById method
		System.out.println("=== Teste 3: ===");
		department = departmentDao.findById(2);
		System.out.println(department);
		System.out.println();

		// Update method
		System.out.println();
		System.out.println("=== Teste 4: ===");
		department = departmentDao.findById(11);
		department.setName("musica");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		
		// findAll method
		System.out.println();
		System.out.println("=== Teste 5: ===");
		List<Department> listDep = departmentDao.findAll();
		for (Department dep : listDep) {
			System.out.println(dep);
		}
		
	}

}
