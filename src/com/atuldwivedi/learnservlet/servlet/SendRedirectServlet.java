package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Demostrate HttpServletResponse.sendRedirect feature", urlPatterns = { "/SendRedirectServlet" })
public class SendRedirectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String enteredURL = request.getParameter("url");

		if (enteredURL == null || enteredURL.length() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

}
