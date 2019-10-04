package com.capgemini.employee.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	static Connection connection = null;

	static {
		try {
			String url = "jdbc:mysql://localhost:3306/emp_db?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 static Connection getConnection() {
	 return connection;
 }
}
