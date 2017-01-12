package com.full;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;


public class User {
	public static DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
	public static boolean createUpdateUser(String SuserName,String SuserPassword){
		Entity user=new Entity("User",SuserName);
		user.setProperty("userName", SuserName);
		user.setProperty("userPassword",SuserPassword);
		datastore.put(user);
		Entity e=new Entity("vvv");
		e.setProperty("name","vicky");
		Key k =datastore.put(e);
		return true;
	}
	public static Iterable<Entity> listUsers(String kind,String userid)
	{
		Query q=new Query(kind).addSort("UserId",Query.SortDirection.ASCENDING);
		Iterable<Entity> pq=datastore.prepare(q).asIterable(FetchOptions.Builder.withLimit(5));
		return pq;
		
	}

	
	public static boolean loginUser(String LuserName,String LuserPassword){
	String uName=null;
	String uPass=null;
	Query q=new Query("User");
	PreparedQuery pq=datastore.prepare(q);
	List<Entity> res=pq.asList(FetchOptions.Builder.withLimit(5));
	for(Entity user:pq.asIterable())
	{
		uName=(String)user.getProperty("LuserName");
		uPass=(String)user.getProperty("LuserPassword");
	}
	if(uPass != null && uPass.equalsIgnoreCase(LuserPassword))
	{
		return true;
	}
	else
	{
		return false;
	}
}
}



