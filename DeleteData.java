package com.full;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;


public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteData() {
        super();
           }

		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag;
		RequestDispatcher dispatcher;
		String retVal = req.getParameter("retVal");
		//retVal="priya";
		String JsonValue;
		System.out.println(retVal);
		flag=User.userDelete(retVal);
		// resp.getWriter().write(flag+ " file deleted");
		UsersData usersData = new UsersData();
		flag=flag+" file deleted";
		usersData.setMessage(flag);
		ObjectMapper mapper = new ObjectMapper();
		JsonValue=mapper.writeValueAsString(usersData);
		 resp.setContentType("application/json");
         resp.getWriter().write(JsonValue);
	}

}
