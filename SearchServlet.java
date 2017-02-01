package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		resp.setContentType("text/plain");
//		resp.getWriter().println("Hello, world");
		String searchId = req.getParameter("searchId");
		boolean flag=User.search(searchId);
		List <Message> messageList= User.getMessageList();
		if(flag){
			resp.setContentType("application/json");
			req.setAttribute("messageList", messageList);
	         resp.getWriter().write(searchId);
		}
//		else{
//			 resp.setContentType("application/json");
//	         resp.getWriter().write("file not found");
//		}
	}
}
