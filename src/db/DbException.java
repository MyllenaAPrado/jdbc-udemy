package db;

// personalize exception create by me
public class DbException extends RuntimeException{

		public DbException(String msg){
			super(msg);
		}
}
