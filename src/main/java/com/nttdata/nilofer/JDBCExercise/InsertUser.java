package com.nttdata.nilofer.JDBCExercise;

	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;



	public class InsertUser {
		
		Scanner sc = new Scanner(System.in);
		PreparedStatement pstmt = null;
		Connection con = null;
		public int addNewUser()
		{
			int noofrowsinserted = 0;
			int usrid;
			String usrname;
			String location;
			System.out.println("Enter the details to signup as new user");
			System.out.println("user id");
			usrid = sc.nextInt();
			System.out.println("user name");
			usrname = sc.next();
			System.out.println("enter location");
			location = sc.next();
			
			
			try{
				
			String addusr = "insert into user values (?,?,?);";
			con = DBConnection.getDBConnection();		
			pstmt = con.prepareStatement(addusr);
			
			pstmt.setInt(1, usrid);
			pstmt.setString(2, usrname);
			pstmt.setString(3, location);
			
			noofrowsinserted = pstmt.executeUpdate();
			
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return noofrowsinserted;
		}
		
}
