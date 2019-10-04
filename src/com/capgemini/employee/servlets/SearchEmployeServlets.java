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

@WebServlet("/Employee")
public class SearchEmployeServlets  extends HttpServlet{

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
			
			preparedStatement = conn.prepareStatement("SELECT * from emp_info where emp_id = ?");
			
			preparedStatement.setInt(1, empId);
			
			resp.setContentType("text/html");
			 resultSet = preparedStatement.executeQuery();
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<body>");
			
			if(resultSet.next()) {
				writer.println("<h2> Employee Details fro EmpId : "+ empId + "</h2>");
				writer.println("Emp_Id : "+ resultSet.getInt("emp_id"));
				writer.println("<br/>Emp_Name : "+ resultSet.getString("emp_name"));
				writer.println("<br/>Emp_Age : "+ resultSet.getInt("age"));
				writer.println("<br/>Emp_Salary : "+ resultSet.getDouble("salary"));
				writer.println("<br/>Emp_Position : "+ resultSet.getString("position"));
			}else {
				writer.println("<h2>Employee details with given Id : "+empId+" Not found</h2>");
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
