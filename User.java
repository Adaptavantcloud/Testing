package com.full;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;


public class User {
	public static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	public static boolean createUpdateUser(String SuserName, String SuserPassword) {
		Entity user = new Entity("User");
		user.setProperty("userName", SuserName);
		user.setProperty("userPassword", SuserPassword);
		datastore.put(user);

		return true;
	}

	public static boolean storeMessage(String label, String message) {
		Entity messages = new Entity("Message",label);
		messages.setProperty("label", label);
		messages.setProperty("message", message);
		datastore.put(messages);


		return true;
	}
	public static String storeMessages(String label, String message) {
		Entity messages = new Entity("Messages",label);
		messages.setProperty("label", label);
		messages.setProperty("message", message);
		datastore.put(messages);

		return label+" file stored successfully";
	}

	public static List<Message> getMessageList() {
		List<Message> msglist = new ArrayList<Message>();
		String labelValue = "";
		String messageValue = "";
		Message m1 = null;
		Query q = new Query("Messages");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity messageContent : pq.asIterable()) {
			labelValue = (String) messageContent.getProperty("label");
			messageValue = (String) messageContent.getProperty("message");
			m1 = new Message();
			m1.setLabel(labelValue);
			msglist.add(m1);
		}

		return msglist;
	}

	public static boolean loginUser(String LuserName, String LuserPassword) {
		String uName = null;
		String uPass = null;
		Query q = new Query("User");
		boolean flag = false;
		PreparedQuery pq = datastore.prepare(q);
		// List<Entity> res = pq.asList(FetchOptions.Builder.withLimit(5));
		for (Entity user : pq.asIterable()) {
			uName = (String) user.getProperty("userName");
			uPass = (String) user.getProperty("userPassword");

			if (uName.equals(LuserName) && uPass.equals(LuserPassword)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static String userData(String label) {
		String labelValue = "";
		String messageValue = "";
		Query q = new Query("Messages");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity messageContent : pq.asIterable()) {
			labelValue = (String) messageContent.getProperty("label");
			messageValue = (String) messageContent.getProperty("message");
			if (labelValue.equals(label)) {
				break;
			}
		}

		return messageValue;
	}

//	public static String userDelete(String label) {
//		String labelValue = "";
//		String messageValue = "";
//		Key k = null;
//		Query q = new Query("Message");
//		PreparedQuery pq = datastore.prepare(q);
//		for (Entity messageContent : pq.asIterable()) {
//			labelValue = (String) messageContent.getProperty("label");
//			messageValue = (String) messageContent.getProperty("message");
//			if (labelValue.equals(label)) {
//				k = KeyFactory.createKey("Message","labelValue");
//				break;
//			}
//		}
//		datastore.delete(k);
//		return label;
//
//	}
	public static String userDelete(String label) {
	Key userkey=KeyFactory.createKey("Messages", label);
	System.out.println(label);
	System.out.println(userkey);
	datastore.delete(userkey);
	return label;
	}
	@SuppressWarnings("null")
	public static String userUpdate(String label,String message){
		Key userkey=KeyFactory.createKey("Messages", label);
		System.out.println(label);
		System.out.println(userkey);
		datastore.delete(userkey);
		Entity messages = new Entity("Messages",label);
		messages.setProperty("label", label);
		messages.setProperty("message", message);
		datastore.put(messages);


		
		return label;
	}

	public static boolean search(String searchId) {
		
		String labelValue = "";
		String messageValue = "";
		boolean flag=false;
		Query q = new Query("Messages");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity messageContent : pq.asIterable()) {
			labelValue = (String) messageContent.getProperty("label");
			messageValue = (String) messageContent.getProperty("message");
			if (labelValue.equals(searchId)) {
				flag=true;
				break;
			}
			
		}
		
		return flag;
		}

	public static String userEdit(String editFile) {
		Filter propertyFilter =new  FilterPredicate("label", FilterOperator.EQUAL, editFile);
		String messageValue="";
		String labelValue="";
				//System.out.println(propertyFilter);
				Query q = new Query("Messages").setFilter(propertyFilter);
				//Query q = new Query("contacts").setFilter(name);
				//System.out.println(q);
				PreparedQuery pq = datastore.prepare(q);
				//System.out.println(pq);
				for (Entity messageContent : pq.asIterable()) {
					 labelValue = (String) messageContent.getProperty("label");
					 messageValue = (String) messageContent.getProperty("message");
					break;
					
				}
				
		return messageValue;
	}

}