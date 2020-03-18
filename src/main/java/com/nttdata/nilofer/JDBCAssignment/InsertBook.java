package com.nttdata.nilofer.JDBCAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertBook {

	Scanner input = new Scanner(System.in);
	PreparedStatement pstmt = null;
	Connection conn = null;

	public int bookInsert() {
		
		int noofrowsinserted = 0;
		int bookId = 0;
		String bookTitle = null;
		String bookAuthor = null;
		float bookPrice = 0;
		int bookQty = 0;
		
		try {
		System.out.println("Enter Book details :");
		System.out.println("Id");
		bookId = input.nextInt();
		input.nextLine();
		System.out.println("Book Title");
		bookTitle = input.nextLine();
		System.out.println("Author");
		bookAuthor = input.nextLine();
		System.out.println("price");
		bookPrice = input.nextFloat();
		System.out.println("Quantity");
		bookQty = input.nextInt();
		}catch(InputMismatchException ime) {
			ime.printStackTrace();
		}
		
		try {

			String addBook = "insert into books values (?,?,?,?,?);";
			conn = DBConnection.getDBConnection();
			pstmt = conn.prepareStatement(addBook);

			pstmt.setInt(1, bookId);
			pstmt.setString(2, bookTitle);
			pstmt.setString(3, bookAuthor);
			pstmt.setFloat(4, bookPrice);
			pstmt.setInt(5, bookQty);

			noofrowsinserted = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return noofrowsinserted;
	}

}
