package com.full;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.apache.tools.ant.taskdefs.email.Mailer;

public class ForgotPassword extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String to = request.getParameter("to");
		
		Mailer.send(to);
		out.print("message has been sent successfully");
		out.close();
	}

}
