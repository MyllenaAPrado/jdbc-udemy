package interfaces;

import java.util.List;

import entities.Department;

public interface DepartmentDao{
	
	public void insert(Department department);
	public void update(Department department);
	public void deleteById(int id);
	public Department findById(int id);
	public List<Department> findAll();
}
