package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Control login of an user", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean isLoginSuccess = false;

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName.equals("servlet") && password.equals("123")) {
			isLoginSuccess = true;
		} else {
			isLoginSuccess = false;
		}

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.println("<h1>Hello, " + userName + "!</h1>");
		if (isLoginSuccess) {
			pw.println("Login Success!");
		} else {
			pw.println("Login Failed! Please <a href=\"login.html\">Retry...</a>");
		}
	}

}
