package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RDE2HomeServlet
 */
@WebServlet("/RDE2HomeServlet")
public class RDE2HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String path = "/WEB-INF/request-dispatcher-example/include/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RDE2HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		
		RequestDispatcher rd1 = request.getRequestDispatcher(path+"header.html");
		rd1.include(request, response);
		
		RequestDispatcher rd2 = request.getRequestDispatcher(path+page+".html");
		rd2.include(request, response);
		
		RequestDispatcher rd3 = request.getRequestDispatcher(path+"footer.html");
		rd3.include(request, response);
	}

}
