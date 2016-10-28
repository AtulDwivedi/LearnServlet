package com.atuldwivedi.learnservlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class Myfilter
 */
@WebFilter(description = "Demostrate how to use filter", 
urlPatterns = { "*.do" }, 
initParams = { @WebInitParam(name = "filterName", 
							value = "MyFilter", 
							description = "The filter name") })
public class Myfilter implements Filter {

	/**
	 * Default constructor.
	 */
	public Myfilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// Pre-processing
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("lastName"));
		System.out.println(request.getRemoteAddr());

		// pass the request along the filter chain
		// servlet core request processing - control goes to servlet
		chain.doFilter(request, response);

		// Post-processing
		Object obj = request.getAttribute("msg");
		String msg = obj.toString();
		System.out.println(msg);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String filterName = fConfig.getInitParameter("filterName");
		System.out.println(filterName);
	}

}
