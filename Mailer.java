package com.full;



import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
    
  
public class Mailer {  
public static void send(String to){  
  
final String user="kuttlu27@gmail.com";//change accordingly  
final String pass="9788835216";  
  
//1st step) Get the session object    
Properties props = new Properties();  
props.put("mail.smtp.host", "mail.gmail.com");//change accordingly  
props.put("mail.smtp.auth", "true");  
  
Session session = Session.getDefaultInstance(props,  
 new javax.mail.Authenticator() {  
  protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(user,pass);  
   }  
});  
//2nd step)compose message  
try {  
 MimeMessage message = new MimeMessage(session);  
 message.setFrom(new InternetAddress(user));  
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
 //message.setSubject(subject);  
 message.setText(to);  
   
 //3rd step)send message  
 Transport.send(message);  
  
 System.out.println("Done");  
  
 } catch (MessagingException e) {  
    throw new RuntimeException(e);  
 }  
      
}  
}  