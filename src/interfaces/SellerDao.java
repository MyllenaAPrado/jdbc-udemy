package interfaces;

import java.util.List;

import entities.Seller;

public interface SellerDao {
	
	public void insert(Seller seller);
	public void update(Seller seller);
	public void delete(int it);
	public Seller findById(Integer id);
	public List<Seller> findByDepartment(String nameDepartment);
	public List<Seller> findAll();
	

}
