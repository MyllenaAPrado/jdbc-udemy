package aplication;

import entities.Seller;
import entities.factory.DaoFactory;
import interfaces.SellerDao;

public class App {

	public static void main(String[] args) {

		// for create a sellerDao and hide the method
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		//search for the seller 3
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

	}

}
