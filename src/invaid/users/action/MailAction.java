package invaid.users.action;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import invaid.users.model.UserAccountBean;

public class MailAction {
	//Should be moved to web.xml or an external file
	private String systemEmail = "raphaelfeliciano7@gmail.com";
	private String systemPassword = "KuyaRFF7!";
	
	//For forgot password
	public boolean sendPasswordResetEmail(UserAccountBean user) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.port", "465");
	    
	    //create Authenticator object to pass in Session.getInstance argument
	  	Authenticator auth = new Authenticator() {
	  	
	  		//override the getPasswordAuthentication method
	  		protected PasswordAuthentication getPasswordAuthentication() {
	  			return new PasswordAuthentication(systemEmail, systemPassword);
	  		}
	  	};
	  		javax.mail.Session session = javax.mail.Session.getInstance(properties, auth);
	    
	    try {  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(systemEmail));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(user.getUser_email()));  
	         message.setSubject("Reset Password");  
	         message.setText("Please click the link to reset your password " + "http://localhost:8080/www.invaid.com/renew_password.jsp?token=" + user.getUserProfile());  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("Mail was sent successfully....");
	         return true;
	         
	      } catch (MessagingException mex) {
	    	  mex.printStackTrace();
	      }
	    return false;
	}
}
