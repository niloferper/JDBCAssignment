package com.nttdata.nilofer.JDBCAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteBook {

	
		//wwwwwwwwwwwwwwwwwwwww
		
		Scanner input = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;;

		public int bookDelete() {
			int id;
			int num=0;
			String delBook = "delete from books where id = ?";

			System.out.println("Enter Book id to delete ");
			id = input.nextInt();

			try {
				conn = DBConnection.getDBConnection();
				pstmt = conn.prepareStatement(delBook);
				pstmt.setInt(1, id);
				 num = pstmt.executeUpdate();

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				if ( num > 0 ) System.out.println("book record deleted");

			return num;
	
	}

}
