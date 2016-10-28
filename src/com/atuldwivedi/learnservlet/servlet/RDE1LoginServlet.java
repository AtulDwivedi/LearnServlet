package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RDE1LoginServlet
 */
@WebServlet("/RDE1LoginServlet")
public class RDE1LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String path = "/WEB-INF/request-dispatcher-example/forward/";
	private String page = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RDE1LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName.equals(password)) {
			page = "home.html";
		} else {
			page = "error.html";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path + page);
		rd.forward(request, response);
	}

}
