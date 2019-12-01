package invaid.users.model;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import config.Configurations;
import invaid.users.util.MailUtil;

public class Mail {
	
	public static boolean sendPasswordResetMail(UserAccountBean userAccount) {
		Session session = MailUtil.getSession();
		
		try {
			MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(Configurations.getAppEmail()));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(userAccount.getUser_email()));  
	         message.setSubject("Reset Password");  
	         message.setText("Please click the link to reset your password " 
	        		 + "http://localhost:8080/www.invaid.com/renew_password.jsp?token=" 
	        		 + userAccount.getReset_token());  
	         
	         Transport.send(message);
	         System.out.println("Mail was sent successfully!");
	         return true;
		} catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		return false;
	}
	
	public static boolean sendVerificationMail(UserAccountBean userAccount) {
		Session session = MailUtil.getSession();
		
		try {
			MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(Configurations.getAppEmail()));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(userAccount.getUser_email()));  
	         message.setSubject("Reset Password");  
	         message.setText("To verify your InvAid account, click the link below: \n" 
	        		 + "http://localhost:8080/www.invaid.com/accountVerified.jsp?token=" 
	        		 + userAccount.getReset_token());  
	         
	         Transport.send(message);
	         System.out.println("Mail was sent successfully!");
	         return true;
		} catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		return false;
	}

}
