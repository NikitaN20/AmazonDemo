package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.controller.ConnectionManager;

public class UserDaoImpl implements UserDao {
				private Connection connection = ConnectionManager.getConnection();
				private String query = "select * from users where userid=? and password=?";
				private PreparedStatement ps= null;
				private ResultSet rs = null;
			
				
				private String query1 = "insert into users values(?,?)";
				 private PreparedStatement ps1= null;
				
	@Override
	public boolean AddUser(User user) {
		try {
			ps1= connection.prepareStatement(query1);
			
			ps1.setString(1,user.getUname());
			ps1.setString(2, user.getPassword());
	
			int i = ps1.executeUpdate();
			if(i==1)
			{
				return true;
			}
		} catch (SQLException sq) {
		
			sq.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ValidateUser(User user) {
		try {
			ps= connection.prepareStatement(query);
			ps.setString(1,user.getUname());
			ps.setString(2, user.getPassword());
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} catch (SQLException sq) {
		
			sq.printStackTrace();
		}
		return false;
	}
	

}
