package com.atuldwivedi.learnservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LearnServletRequestParam
 */
@WebServlet(description = "Demostrate ServletRequaet Params", urlPatterns = { "/LearnServletRequestParam" })
public class LearnServletRequestParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LearnServletRequestParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1>ServletRequest parameters</h1>");

		// Case 1
		out.println("<h2>Case 1</h2>");
		out.print("<h3>Using: HttpServletRequest.getParameter and HttpServletRequest.getParameterValues methods</h3>");
		String name = request.getParameter("name");
		String jModules[] = request.getParameterValues("jModules");
		out.println("<label>" + name + "</label> <br>");
		if (jModules != null) {
			for (int i = 0; i < jModules.length; i++) {
				out.print("<label> " + jModules[i] + "</label>");
			}
			out.println("<br>");
		}

		// Case 2
		out.println("<h2>Case 2</h2>");
		out.print("<h3>Using: HttpServletRequest.getParameterMap method</h3>");
		Map<String, String[]> map = request.getParameterMap();
		Set paramNames = map.keySet();
		Iterator it = paramNames.iterator();
		while (it.hasNext()) {
			String paramName = (String) it.next();
			Object paramValue = map.get(paramName);
			String[] paramValueArray = (String[]) paramValue;
			for (int i = 0; i < paramValueArray.length; i++) {
				out.println("<label>" + paramValueArray[i] + " </label>");
			}
			out.println("<br>");
		}

		// Case 3
		out.println("<h2>Case 3</h2>");
		out.print("<h3>Using: <i>HttpServletRequest.getParameterName</i> and HttpServletRequest.getParameter methods</h3>");
		Enumeration<String> paramEnum = request.getParameterNames();
		List<String> paramList = Collections.list(paramEnum);
		for (String param : paramList) {
			out.println(request.getParameter(param) + "<br>");
		}
	}

}
