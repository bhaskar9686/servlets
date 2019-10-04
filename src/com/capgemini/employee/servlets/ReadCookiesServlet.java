package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookiesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		for(Cookie cookie : cookies) {
			writer.println("Cookie Name : "+ cookie.getName());
			writer.println("Cookie Value : "+ cookie.getValue());
		}
	}

}
