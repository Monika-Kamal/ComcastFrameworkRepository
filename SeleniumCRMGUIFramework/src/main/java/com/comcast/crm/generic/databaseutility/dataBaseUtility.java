package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class dataBaseUtility {
	Connection con;
	
	public void getConnection(String url, String username , String Password) throws SQLException {
		try{
			Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(url,username,Password);
		}
		catch(Exception e) {
			
		}
	}public void getConnection() throws SQLException {//overloaded methos, using this because we only have one db so
		try{
			Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
		catch(Exception e) {
			
		}
	}
	
	public void closedbConnection() throws SQLException {
		try {
		con.close();
	}catch(Exception e) {
		
	}
}
	public ResultSet executeSelectQuery(String Query) throws SQLException {
		ResultSet query=null;
		try {
		Statement stat = con.createStatement();
		 query = stat.executeQuery(Query);
		}catch(Exception e) {
			
		}
		
		return query;
		}
	public int executeNonSelectQuery(String Query) throws SQLException {
		int query=0;
		try {
		Statement stat = con.createStatement();
		 query = stat.executeUpdate(Query);
		}catch(Exception e) {
			
		}
		
		return query;
		}
}
	
