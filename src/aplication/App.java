package aplication;

import java.util.List;

import entities.Seller;
import entities.factory.DaoFactory;
import interfaces.SellerDao;

public class App {

	public static void main(String[] args) {

		// for create a sellerDao and hide the method
		SellerDao sellerDao = DaoFactory.createSellerDao();

		// findById method
		System.out.println("=== Teste 1: ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);

		// findByDepartment method
		System.out.println();
		System.out.println("=== Teste 2: ===");
		List<Seller> listSeller = sellerDao.findByDepartment("Electronics");
		for (Seller s : listSeller) {
			System.out.println(s);
		}

		// findAll method
		System.out.println();
		System.out.println("=== Teste 3: ===");
		listSeller = sellerDao.findAll();
		for (Seller s : listSeller) {
			System.out.println(s);
		}

	}

}
