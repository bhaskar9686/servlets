package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String empIdVal = req.getParameter("emp_id");
		String empPass= req.getParameter("password");
		int empId = Integer.parseInt(empIdVal);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?user=root&password=root");
			String sql = "SELECT * from emp_info where emp_id = ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			preparedStatement.setString(2, empPass);
			resp.setContentType("text/html");
			resultSet = preparedStatement.executeQuery();
			
			PrintWriter writer = resp.getWriter();
			if(resultSet.next()) {
				HttpSession session = req.getSession(true);
				writer.println("<a herf = \"/createCookies\">Click here</a> To Create Cookie <br/>");
				writer.println("<a herf = \"/readCookie\">Click here</a> To Read Cookie<br/>");
				writer.println("<a herf = \"/myServlet\">view</a> Servlet Contex and Config Parameter Value.<br/>");
//				RequestDispatcher dispatcher = req.getRequestDispatcher("homePage.html");
//				dispatcher.include(req, resp);
			}else {
				writer.println("Invalid Credential");
			}
		}catch (Exception e) {
			
		}

	}

}
