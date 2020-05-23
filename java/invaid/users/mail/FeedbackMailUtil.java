package invaid.users.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import config.Configurations;

public class FeedbackMailUtil extends MailUtil {
	
	public FeedbackMailUtil() {
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.port", "465");
		
		auth = new Authenticator() {
	  		protected PasswordAuthentication getPasswordAuthentication() {
	  			return new PasswordAuthentication(Configurations.getAppFeedback(), Configurations.getAppPass());
	  		}
		};
		
		setMailType("FEEDBACK");
	}
	
	@Override
	public Session getSession() {
		return Session.getInstance(properties, auth);
	}

}
