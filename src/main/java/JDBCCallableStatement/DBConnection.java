package JDBCCallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
	
	private static Connection conn = null;
	private static final String url = "jdbc:mysql://localhost:3306/ebookshop"; 
	private static final String db = "ebookshop";
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
		
		conn = DriverManager.getConnection(url, user, password);
		
		if(conn!=null)
		{
			System.out.println("connection established successfully");
//			PreparedStatement pstmt = null;
//			String sql = "USE " + db + ";";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.executeUpdate();
		}
		else{
			System.out.println("connection not establish");
		}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
