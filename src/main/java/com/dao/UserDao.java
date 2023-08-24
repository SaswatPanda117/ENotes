package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.user.UserDetails;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	// connection is created and pass through this constructor, then 
	// the code (or data) will be stored in the database
	
	public boolean addUser (UserDetails us) {
		
		boolean dataStore = false;
		
		try {
			String query = "insert into user (name, email, password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				dataStore = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataStore;
	}
	
	public UserDetails loginUser(UserDetails us) {
		
		UserDetails user = null;
		try {
			String query = "select * from user where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {

				// if the data is available & correct, retrieve it
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));				
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}
}
