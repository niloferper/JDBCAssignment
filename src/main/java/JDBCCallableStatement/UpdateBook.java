package JDBCCallableStatement;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateBook {
	Scanner input = new Scanner(System.in);
	CallableStatement cstmt = null;
	Connection conn = null;

	public int bookUpdate() {
		
		
		int noOfRowsUpdated = 0;
		int bookId = 0;
		
		float bookPrice = 0;
		int bookQty = 0;
		
		try {
		System.out.println("Enter Book details :");
		System.out.println("Id");
		bookId = input.nextInt();
		System.out.println("price");
		bookPrice = input.nextFloat();
		System.out.println("Quantity");
		bookQty = input.nextInt();
		}catch(InputMismatchException ime) {
			ime.printStackTrace();
		}
		
		try {

			//String addBook = "update books set price = ?,qty=? where id = ? ;";
			conn = DBConnection.getDBConnection();
			cstmt = conn.prepareCall("{call UpdateBook(?,?,?)}");

			cstmt.setInt(3, bookId);
			cstmt.setFloat(1, bookPrice);
			cstmt.setInt(2, bookQty);

			noOfRowsUpdated = cstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noOfRowsUpdated;

	}

}
