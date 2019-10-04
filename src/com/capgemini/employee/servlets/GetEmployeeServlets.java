package com.capgemini.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getEmp")
public class GetEmployeeServlets extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idVal = req.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idVal);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		PrintWriter writer = null;
		try {
			writer = resp.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}

		writer.println("<html>");
		writer.println("		<body>");
		if(id == 1) {

			writer.println("				<h1>Employee Details</h1><br>");
			writer.println("				Emp ID : 1<br>");
			writer.println("				Emp Name : Bhaskar<br>");
			writer.println("				Emp Salary : 89768<br>");
		} else {
			writer.println("<h1>Employee ID  " + id + " Not found</h1>");
		}
		writer.println("		</body>");
		writer.println("</html>");

	}// End of doGet()


}//End of GetEmployeeServlets
