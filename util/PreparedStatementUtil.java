package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PreparedStatementUtil 
{
	private final static String URL ="jdbc:mysql://localhost:3306/java1";
	private final static String USERNAME="root";
	private final static String PASSWORD = "";
	
	private static PreparedStatement pstmt;
	private static Connection cn;
	
	public static PreparedStatement getConnectionData(String Query) throws ClassNotFoundException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection(URL , USERNAME , PASSWORD);
			System.out.println("Connection successfully established..");
			pstmt=cn.prepareStatement(Query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pstmt ;
	}
	
	public static void close() {
		if(cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				System.out.println("Problem Occured While Closing Connection Object.");
				e.printStackTrace();
			}
		}
	}
}

