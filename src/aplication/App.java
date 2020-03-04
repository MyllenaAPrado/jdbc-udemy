package aplication;

import java.util.List;

import entities.Seller;
import entities.factory.DaoFactory;
import interfaces.SellerDao;

public class App {

	public static void main(String[] args) {

		// for create a sellerDao and hide the method
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//findById method
		System.out.println("=== Testes1: ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);

		//findByDepartment method
		System.out.println("=== Testes2: ===");
		List<Seller> seller2 = sellerDao.findByDepartment("Electronics");
		for (Seller s : seller2) {
			System.out.println(s);
		}
		
		
		

	}

}
