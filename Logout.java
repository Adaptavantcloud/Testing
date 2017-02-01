package com.full;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ServletRequest session = null;
		Object userId = session.getAttribute("userId");
		   if(userId.equals(null)) {
		      resp.sendRedirect("/homemain.html");
		   }
		
	}
}
