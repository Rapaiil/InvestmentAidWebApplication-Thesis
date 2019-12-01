package invaid.users.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import config.Configurations;

public class MailUtil {
	private static Properties properties = new Properties();
	private static Authenticator auth;
	
	/*
	 * configures properties for mail sending
	 */
	static {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.port", "465");
	    
	    //create Authenticator object to pass in Session.getInstance argument
	  	auth = new Authenticator() {
	  		//override the getPasswordAuthentication method
	  		protected PasswordAuthentication getPasswordAuthentication() {
	  			return new PasswordAuthentication(Configurations.getAppEmail(), Configurations.getAppPass());
	  		}
	  	};
	}
	
	/*
	 * returns the Session mail
	 */
	public static Session getSession() {
		return Session.getInstance(properties, auth);
	}
}
