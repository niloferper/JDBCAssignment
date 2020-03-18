package JDBCCallableStatement;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

	
		
		Scanner input = new Scanner(System.in);

		Connection conn = null;
		CallableStatement cstmt = null;;

		public int bookDelete() {
			int id;
			int num=0;
			//String delBook = "delete from books where id = ?";

			System.out.println("Enter Book id to delete ");
			id = input.nextInt();

			try {
				conn = DBConnection.getDBConnection();
				cstmt = conn.prepareCall("{call DeleteBook(?)}");
				cstmt.setInt(1, id);
				 num = cstmt.executeUpdate();

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				if ( num > 0 ) System.out.println("book record deleted");
				else System.out.println("no such book exist ");

			return num;
	
	}

}
