package com.full;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
public class IncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IncludeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher;
		List <Message> messageList= User.getMessageList();
		
		//req.setAttribute("messageList", messageList);
		//ObjectMapper mapper = new ObjectMapper();
		//String messagesList = mapper.writeValueAsString(messageList);
		 resp.setContentType("application/html");
		 //resp.getWriter().write(messagesList);
         //resp.getWriter().writer(messageList);
		 String outPut="";
		 
		 for(int i=0;i<messageList.size();i++){
			Message message= messageList.get(i);
			 outPut=outPut + "<p onClick=showValue('"+message.getLabel()+"');>"+message.getLabel()+"<br></p>";
		 }
		PrintWriter out = resp.getWriter();
	      out.print(outPut);
		// dispatcher = getServletContext().getRequestDispatcher("/include.jsp");
		 //dispatcher.include(req, resp);
	}

}
