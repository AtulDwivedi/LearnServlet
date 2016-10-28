package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnrollmentJavaServlet
 */
@WebServlet(urlPatterns = { "/EnrollmentJavaServlet" }, initParams = {
		@WebInitParam(name = "trainerName", value = "Atul", description = "Name of Java trainer"),
		@WebInitParam(name = "trainerEmailId", value = "contact@atuldwivedi.com", description = "Email ID of Java trainer") })
public class EnrollmentJavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollmentJavaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get input parameter values
		String traineeName = request.getParameter("name");
		String[] jModules = request.getParameterValues("jModules");
		
		//Get config parameter values
		ServletConfig cfg = getServletConfig();
		String trainerName = cfg.getInitParameter("trainerName");
		String trainerEmailId = cfg.getInitParameter("trainerEmailId");
		
		//Get context parameter values
		ServletContext ctx = cfg.getServletContext();
		String instituteName = ctx.getInitParameter("institute");
		
		//Prepare output
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>Enrollment details for Java</h1>");
		
		out.print("<h2>Trainee details:</h2>");
		out.print("<label>Trainee Name: </label><b><label>" + traineeName + "</label></b> <br>");
		if(jModules != null){
			out.print("<label>Modules: </label>");
			for(int i = 0; i < jModules.length; i++){
				out.print("<b><label> " + jModules[i]
						+ "</label></b>");
			}
			out.println("<br>");
		}
		
		out.print("<h2>Trainer details:</h2>");
		out.print("<label>Trainer Name: </label><b><label>" + trainerName + "</label></b> <br>");
		out.print("<label>Trainer Email ID: </label><b><label>" + trainerEmailId + "</label></b> <br>");
		
		//Page break
		out.print("<hr>");
		out.print("<label>Institute Name: </label><b><label>" + instituteName + "</label></b> <br>");
		
	}
}
