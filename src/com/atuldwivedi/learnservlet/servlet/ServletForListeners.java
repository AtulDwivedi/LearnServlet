package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForListeners
 */
@WebServlet("/ServletForListeners")
public class ServletForListeners extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForListeners() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName() + " service started");

		String msg = request.getParameter("msg");
		ServletContext ctx = getServletContext();
		ctx.setAttribute("msg", msg);
		ctx.setAttribute("msg", "My message");
		ctx.removeAttribute(msg);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(msg);

		System.out.println(this.getClass().getName() + " service completed");
	}

}
