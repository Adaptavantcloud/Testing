package com.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.mortbay.util.ajax.JSON;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;






public class UserData extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String responeseContent;
		String label = req.getParameter("label");
		responeseContent=User.userData(label);
		System.out.println(responeseContent);
		//dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		//req.setAttribute("responeseContent", responeseContent);
		//dispatcher.forward(req, resp);
		List <Message> messageList= User.getMessageList();
		ObjectMapper mapper = new ObjectMapper();
		
		 //String json = new JSON().toJSON(responeseContent);
	//String json=new ObjectMapper().readValue(responeseContent,responeseContent);
		//Convert object to JSON string
		String jsonInString = mapper.writeValueAsString(responeseContent);
		UsersData usersData = new UsersData();
		usersData.setMessage(responeseContent);
		System.out.println("String"+jsonInString);
		jsonInString =mapper.writeValueAsString(usersData);
		System.out.println("object"+jsonInString);
		//System.out.println(jsonInObject);
		//Gson g = new Gson();
		//String str = g.toJson(responeseContent);
		
		req.setAttribute("messageList", messageList);
         resp.setContentType("application/json");
         resp.getWriter().write(jsonInString);
		//resp.setContentType("text/plain");
		//resp.getWriter().write(responeseContent);
	}
}
