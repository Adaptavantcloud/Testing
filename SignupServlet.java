package com.full;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher;
		boolean flag;
		String SuserName=req.getParameter("SuserName");
		String SuserPassword=req.getParameter("SuserPassword");
		flag=User.createUpdateUser(SuserName, SuserPassword);
		if(flag)
		{
			dispatcher=getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			dispatcher=getServletContext().getRequestDispatcher("/signup.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
