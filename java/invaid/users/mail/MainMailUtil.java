package invaid.users.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import config.Configurations;

public class MainMailUtil extends MailUtil {
	
	public MainMailUtil() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.port", "465");
		
		auth = new Authenticator() {
	  		protected PasswordAuthentication getPasswordAuthentication() {
	  			return new PasswordAuthentication(Configurations.getAppEmail(), Configurations.getAppPass());
	  		}
		};
		
		email = Configurations.getAppEmail();
		
		setMailType("MAIN");
	}	
	
	@Override
	public Session getSession() {
		return Session.getInstance(properties, auth);
	}
	
	@Override
	public String getEmail() {
		return email;
	}
}
