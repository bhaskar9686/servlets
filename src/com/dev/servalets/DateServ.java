package com.dev.servalets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dateServ")
public class DateServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("refresh", "1");
		PrintWriter out = resp.getWriter();
		out.println("<h1> The Current Date and Time is : "+ new Date() + " </h1>");
		
		ServletContext context = getServletContext();
		String myContextVal = context.getInitParameter("myContext");
		out.println("Config Parameter value is : "+ myContextVal);
	}
}
