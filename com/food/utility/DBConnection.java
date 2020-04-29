package com.food.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection dbconnect=null;
	
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbconnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza_121", "root","root");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		return dbconnect;
	}
}
