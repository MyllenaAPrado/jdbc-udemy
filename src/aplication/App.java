package aplication;

import java.util.Date;

import entites.Department;
import entites.Seller;

public class App {

	public static void main(String[] args) {
		
		Department department = new Department(2, "bolsas");
		Seller seller = new Seller(21,  "bob", "bob@gmail.com", new Date(), 3000.00, department);
		System.out.println(seller);

//		// DB is not instantiated because it's a service
//		Connection conn = null;
//		PreparedStatement st = null;
//		conn = DB.getConnection();
////		try {
////			// connect with the database
////			conn = DB.getConnection();
////			
////		} catch (SQLException e) {
////			throw new DbIntegrityException(e.getMessage());
////		}
//		//finally{
//		// close the connection
//		DB.closeStatement(st);
//		DB.closeConnection();
//	//}
}

}
