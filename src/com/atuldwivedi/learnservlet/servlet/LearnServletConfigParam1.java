package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LearnServletConfigParam
 */
@WebServlet(
		description = "Demostrate ServletConfig parameter", 
		urlPatterns = { "/LearnServletConfigParam" }, 
		initParams = { 
				@WebInitParam(name = "trainerName", value = "Atul Dwivedi", description = "Atul is trainer for all Java Modules"), 
				@WebInitParam(name = "trainerEmailId", value = "contact@atuldwivedi.com", description = "Email ID of java Trainer")
		})
public class LearnServletConfigParam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnServletConfigParam1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Student's enrollment details for Java</h2>");
		String name = request.getParameter("name");
		String jModules[] = request.getParameterValues("jModules");
		out.println("<label>Student Name: </label><label>" + name + "</label> <br>");
		out.println("<label>Modules: </label>");
		if (jModules != null) {
			for (int i = 0; i < jModules.length; i++) {
				out.print("<label> " + jModules[i] + "</label>");
			}
			out.println("<br>");
		}
		out.println("<hr>");
		
		/**
		 * ServletConfig object by ServletConfig.getServletConfig
		 */
		ServletConfig cfg = getServletConfig();
		String trainerName = cfg.getInitParameter("trainerName");
		String trainerEmailId = cfg.getInitParameter("trainerEmailId");
		
		out.println("<label>Trainer Name: </label><label>" + trainerName + "</label> <br>");
		out.println("<label>Traine Email ID: </label><label>" + trainerEmailId + "</label> <br>");
	}

}
