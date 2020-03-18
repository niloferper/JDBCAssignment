package JDBCCallableStatement;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindBook {

	Scanner input = new Scanner(System.in);

	Connection conn = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	public int showBookById() throws BookIdInvalidException {
		int id;

		//String selectBook = "select * from books where id = ?";

		System.out.println("Enter Book id to search ");
		id = input.nextInt();

		try {
			conn = DBConnection.getDBConnection();
			cstmt = conn.prepareCall("{call FindBook(?)}");
			cstmt.setInt(1, id);
			rs = cstmt.executeQuery();

		}

		catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		int count = 0;

		try {
			while (rs.next()) {
				count++;

				String makePrntStrng = String.format("%-8s", "Id") + String.format("%-40s", "Title")
						+ String.format("%-20s", "Author") + String.format("%-10s", "Price")
						+ String.format("%-10s", "Quantity");
				System.out.println(makePrntStrng);
				System.out.print(String.format("%-8s", rs.getInt("id")));
				System.out.print(String.format("%-40s", rs.getString("title")));
				System.out.print(String.format("%-20s", rs.getString("author")));
				System.out.print(String.format("%-10s", rs.getFloat("price")));
				System.out.print(String.format("%-10s", rs.getInt("qty")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//System.out.println(count);
		if (count == 0) {
			
			//System.out.println("book not found...check book id");
			throw new BookIdInvalidException("No books exist with given id ");
		}
			
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
