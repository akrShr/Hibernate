package com.jdbc.test.connection.coreJavanHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcURL="jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String password="hbstudent";
		
		try {
			System.out.println("Connecting to the database...");
			
			Connection conn=DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println("Connection successful!!");
			
			conn.close();
		
			} catch (SQLException e) {
					
					e.printStackTrace();
				}

	}

}
