package com.nttdata.nilofer.JDBCExercise;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection con = null;
	private static final String url = "jdbc:mysql://localhost:3306/ntt_practice"; //ntt - database in mysql
	private static final String user = "nttdata123"; //user name of mysql
	private static final String password = "ntt123"; //password of mysql
	
	/**
	 * This method is used to establish the connection and
	 * @return connection of database
	 */
	
	
	public static  Connection getDBConnection()
	
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url, user, password);
		
		if(con!=null)
		{
			System.out.println("connection established successfully");
		}
		else{
			System.out.println("connection not establish");
		}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			System.out.println("close connections here");
		}
		return con;
		
	}

}
