package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "Controls user registration", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		// This will fetch only last selected value not all
		// String modules = request.getParameter("modules");
		
		// This will fetch all selected values in string array
		String modules[] = request.getParameterValues("modules");
		String timing = request.getParameter("timing");
		String comment = request.getParameter("comment");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h1>Hello " + name + "!</h1>");
		out.println("<h2>You are registered with below details:</h2>");

		out.println("<label>Name: </label><label>" + name + "</label> <br>");
		out.println("<label>Email: </label><label>" + email + "</label> <br>");
		out.println("<label>Phone: </label><label>" + phone + "</label> <br>");
		out.println("<label>Gender: </label><label>" + gender + "</label> <br>");
		
		if(modules != null){
			out.print("<label>Modules: </label>");
			for(int i = 0; i < modules.length; i++){
				out.print("<label> " + modules[i]
						+ "</label>");
			}
			out.println("<br>");
		}
		
		out.println("<label>Timing: </label><label>" + timing + "</label> <br>");
		out.println("<label>Comment: </label><label>" + comment
				+ "</label> <br>");
	}

}
