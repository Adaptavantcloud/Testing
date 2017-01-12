package com.full;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

//@SuppressWarninsgs("serial")
public class JspServletServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		String index = req.getParameter("loginUsername");
		
		resp.getWriter().println("WELCOME :"+index);
		
	}
}
