package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmp")
public class DeleteEmployeeServlets extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

int empId = Integer.parseInt(req.getParameter("emp_id"));
		
		Connection conn= null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		try {
			String url = "jdbc:mysql://localhost:3306/emp_db?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			
			preparedStatement = conn.prepareStatement("Delete from emp_info where emp_id = ?");
			
			preparedStatement.setInt(1, empId);
			
			resp.setContentType("text/html");
			int count = preparedStatement.executeUpdate();
			
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<body>");
			if(count > 0) {
				writer.println("<h3> Employee Deleted Successfully!</h3>");
			}else {
				writer.println("<h3> Failed to Delete Employee  !</h3>");
			}
			
			writer.println("</html>");
			writer.println("</body>");
			
		} catch (SQLException  e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				conn.close();
			}
			catch (SQLException  e) {
				e.printStackTrace();
			} 
		}
	}

}
