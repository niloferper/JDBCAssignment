package com.nttdata.nilofer.JDBCAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListBook {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int showBooks() {

		String selectallbook = "select * from books";

		try {
			conn = DBConnection.getDBConnection();
			pstmt = conn.prepareStatement(selectallbook);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int rowCount = 0;

		if (rs != null) {
			System.out.println("Books Available");
			String makePrntStrng = String.format("%-8s", "Id") + String.format("%-40s", "Title")
					+ String.format("%-20s", "Author") + String.format("%-10s", "Price")
					+ String.format("%-10s", "Quantity");
			System.out.println(makePrntStrng);
			// System.out.println("Id \tTitle \t\t\t\tAuthor \t\tPrice\tNo. of Copies");
			try {
				while (rs.next()) {
					rowCount++;
					System.out.print(String.format("%-8s", rs.getInt("id")));
					System.out.print(String.format("%-40s", rs.getString("title")));
					System.out.print(String.format("%-20s", rs.getString("author")));
					System.out.print(String.format("%-10s", rs.getFloat("price")));
					System.out.print(String.format("%-10s", rs.getInt("qty")));
					System.out.println();

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No books Availabe");
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
