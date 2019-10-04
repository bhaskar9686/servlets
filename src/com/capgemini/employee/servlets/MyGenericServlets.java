package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myGeneric")
public class MyGenericServlets extends GenericServlet{

	@Override
	public void service(ServletRequest requset, ServletResponse response) throws ServletException, IOException {

		if(requset instanceof HttpServletRequest  && response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) requset;	
			HttpServletResponse resp = (HttpServletResponse) response;	
			
			PrintWriter writer = resp.getWriter();
			resp.setContentType("text/html");
			writer.println("<h2>It is MyGeneric Servlets</h2>");
		}
	}
} //  End of MyGeneric Servlets
