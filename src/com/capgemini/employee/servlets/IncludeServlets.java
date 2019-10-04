package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlets extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h2>This is Include Servlets</h2>");
		writer.println("</html>");
		writer.println("</body>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/dateServ");
		dispatcher.include(req, resp);
	}

}
