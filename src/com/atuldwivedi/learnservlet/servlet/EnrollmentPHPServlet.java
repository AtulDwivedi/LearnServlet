package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnrollmentPHPServlet
 */
@WebServlet(urlPatterns = { "/EnrollmentPHPServlet" }, initParams = {
		@WebInitParam(name = "trainerName", value = "Siyaram", description = "Name of PHP trainer"),
		@WebInitParam(name = "trainerEmailId", value = "contact@siyaram.com", description = "Email ID of PHP trainer") })
public class EnrollmentPHPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig cfg;
	private ServletContext ctx;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollmentPHPServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.cfg = config;
		this.ctx = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1>Enrollment details for Java</h1>");
		
		out.print("<h2>Trainee details:</h2>");
		Enumeration<String> paramEnum = request.getParameterNames();
		List<String> paramList = Collections.list(paramEnum);
		for (String param : paramList) {
			out.print("<label>" + param + ": </label><b><label>"
					+ request.getParameter(param) + "</label></b> <br>");
		}

		out.print("<h2>Trainer details:</h2>");
		// Get config parameter values
		Enumeration<String> cfgParamEnum = cfg.getInitParameterNames();
		List<String> cfgParamList = Collections.list(cfgParamEnum);
		for (String cfgParam : cfgParamList) {
			out.print("<label>" + cfgParam + ": </label><b><label>"
					+ cfg.getInitParameter(cfgParam) + "</label></b> <br>");
		}

		// Page break
		out.print("<hr>");
		ServletContext ctx = cfg.getServletContext();
		Enumeration<String> ctxParamEnum = ctx.getInitParameterNames();
		List<String> ctxParamList = Collections.list(ctxParamEnum);
		for (String ctxParam : ctxParamList) {
			out.print("<label>" + ctxParam + ": </label><b><label>"
					+ ctx.getInitParameter(ctxParam) + "</label></b> <br>");
		}
	}

}
