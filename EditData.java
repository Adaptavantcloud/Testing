package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;


public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String editFile = req.getParameter("editFile");
		String editMessage="";
		String JsonEditValue="";
		editMessage=User.userEdit(editFile);
		List <Message> messageList= User.getMessageList();
		UsersData usersData = new UsersData();
		
		usersData.setMessage(editMessage);
		ObjectMapper mapper = new ObjectMapper();
		JsonEditValue=mapper.writeValueAsString(usersData);
		req.setAttribute("messageList", messageList);
		 resp.setContentType("application/json");
		// resp.getWriter().write(JsonEditValue);
         resp.getWriter().write(editMessage);
	}

	
}
