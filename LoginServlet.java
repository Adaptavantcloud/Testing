package com.full;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		boolean flag;
		RequestDispatcher dispatcher;
		String LuserName=req.getParameter("loginUsername");
		String LuserPassword=req.getParameter("loginPassword");
		flag=User.loginUser(LuserName,LuserPassword);
		if(flag)
		{
			dispatcher=getServletContext().getRequestDispatcher("/Home.html");
			dispatcher.forward(req,resp);
		}
		else
		{
			dispatcher=getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req,resp);
		}
		
	}

	
}
