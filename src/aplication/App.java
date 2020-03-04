package aplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class App {

	public static void main(String[] args) {
		// DB is not instantiated because it's a service
		Connection conn = null;
		PreparedStatement st = null;
		conn = DB.getConnection();
//		try {
//			// connect with the database
//			conn = DB.getConnection();
//			
//		} catch (SQLException e) {
//			throw new DbIntegrityException(e.getMessage());
//		}
		//finally{
		// close the connection
		DB.closeStatement(st);
		DB.closeConnection();
	//}
}

}
