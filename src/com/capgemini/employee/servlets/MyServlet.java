package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		
		PrintWriter writer = resp.getWriter();
		if(session != null) {
		resp.setContentType("text/html");
		writer.println("<h2>This is myServlet</h2>");
		
		// get config
		ServletConfig config = getServletConfig();
		String myParamVal = config.getInitParameter("myParam");
		writer.println("Config Parameter value is : "+ myParamVal);
		
		//get Context
		ServletContext context = getServletContext();
		String myContextVal = context.getInitParameter("myContext");
		writer.println("Config Parameter value is : "+ myContextVal);
		}else {
			writer.println("Please Login First");
		}
		
		
	}// End of doGet()

}// End of Myservlet
