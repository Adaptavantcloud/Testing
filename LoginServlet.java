package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		boolean flag;
		RequestDispatcher dispatcher;
		String LuserName = req.getParameter("loginUsername");
		String LuserPassword = req.getParameter("loginPassword");
		flag = User.loginUser(LuserName, LuserPassword);
		List <Message> messageList= User.getMessageList();
		//messageList= User.getMessageList();
		if (flag) {
			dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			req.setAttribute("messageList", messageList);
			dispatcher.forward(req, resp);
		} else {
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
