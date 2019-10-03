package com.controller;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class ConnectionManager {

		private static Connection connection;
		private ConnectionManager() {}
		
		public static Connection getConnection()
		{
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username= "hr";
			String password = "hr";
			 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(url,username,password);
				
			} catch (SQLException sq) {
				
				sq.printStackTrace();
			}
			 catch(ClassNotFoundException e)
			 {
				 e.printStackTrace();
			 }
			
			return connection;
		}



}
