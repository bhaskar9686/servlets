package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp")
public class AddEmployeeServlets extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get form data
		String empIdVal = req.getParameter("emp_id");
		String empNameVal = req.getParameter("emp_name");
		String empAgeVal = req.getParameter("age");
		String empSalaryVal = req.getParameter("salary");
		String empPositionVal = req.getParameter("position");
		
		int empId = Integer.parseInt(empIdVal);
		int empAge = Integer.parseInt(empAgeVal);
		int empSalary = Integer.parseInt(empSalaryVal);
		
		Connection conn= null;
		PreparedStatement preparedStatement= null;
		try {
			String url = "jdbc:mysql://localhost:3306/emp_db?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			
			String sql = "INSERT into emp_info values(?,?,?,?,?)";
			
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			preparedStatement.setString(2, empNameVal);
			preparedStatement.setInt(3, empAge);
			preparedStatement.setDouble(4, empSalary);
			preparedStatement.setString(5, empPositionVal);
			
			resp.setContentType("text/html");
			int count = preparedStatement.executeUpdate();
			
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<body>");
			if(count > 0) {
				writer.println("<h3> Employee Added Successfully!</h3>");
			}else {
				writer.println("<h3> Failed to add Employee  !</h3>");
			}
			
			writer.println("</html>");
			writer.println("</body>");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
