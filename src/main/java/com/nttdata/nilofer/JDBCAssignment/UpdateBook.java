package com.nttdata.nilofer.JDBCAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateBook {
	Scanner input = new Scanner(System.in);
	PreparedStatement pstmt = null;
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

			String addBook = "update books set price = ?,qty=? where id = ? ;";
			conn = DBConnection.getDBConnection();
			pstmt = conn.prepareStatement(addBook);

			pstmt.setInt(3, bookId);
			pstmt.setFloat(1, bookPrice);
			pstmt.setInt(2, bookQty);

			noOfRowsUpdated = pstmt.executeUpdate();

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
