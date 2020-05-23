package invaid.users.util;

import java.util.Hashtable;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import config.Configurations;
import invaid.users.mail.FeedbackMailUtil;
import invaid.users.mail.MailUtil;
import invaid.users.mail.MainMailUtil;
import invaid.users.model.LoginAccountModel;
import invaid.users.model.UserAccountBean;

public class Mail {
	private static Hashtable<String, MailUtil> mailUtilMap = new Hashtable<String, MailUtil>();
	
	
	static {
		loadCache();
	}
	
	private static MailUtil getMailUtility(String mailType) {
		MailUtil cachedMail = mailUtilMap.get(mailType);
		return (MailUtil) cachedMail.clone();
	}
	
	private static void loadCache() {
		MainMailUtil mmu = new MainMailUtil();
		mailUtilMap.put(mmu.getMailType(), mmu);
		
		FeedbackMailUtil fmu = new FeedbackMailUtil();
		mailUtilMap.put(fmu.getMailType(), fmu);
	}
	
	public static boolean sendPasswordResetMail(String user_email, String user_token) {
		MailUtil mailUtil = (MailUtil) getMailUtility("MAIN");
		Session session = mailUtil.getSession();
		
		try {
			MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(mailUtil.getEmail()));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(user_email));  
	         message.setSubject("InvAid Password Reset Request");  
	         message.setText("Please click the link to reset your password:\n\n" 
	        		 + "http://localhost:8080/www.invaid.com/renewpassword.action?token=" 
	        		 + user_token);  
	         
	         Transport.send(message);
	         System.out.println("Mail was sent successfully!");
	         return true;
		} catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		return false;
	}
	
	public static boolean sendVerificationMail(UserAccountBean userAccount) {
		MailUtil mailUtil = (MailUtil) getMailUtility("MAIN");
		Session session = mailUtil.getSession();
		
		try {
			MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(mailUtil.getEmail()));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(userAccount.getUser_email()));
	         message.setSubject("Verify Your InvAid Account");
	         message.setText("To verify your InvAid account, click the link below:\n\n" 
	        		 + "http://localhost:8080/www.invaid.com/verifyuser.action?token=" 
	        		 + userAccount.getUser_token());  
	         
	         Transport.send(message);
	         System.out.println("Mail was sent successfully!");
	         return true;
		} catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		return false;
	}
	
	public static boolean sendMultiFactorAuthentication(LoginAccountModel loginAccount) {
		MailUtil mailUtil = (MailUtil) getMailUtility("MAIN");
		Session session = mailUtil.getSession();
		
		try {
			MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(mailUtil.getEmail()));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(loginAccount.getLogin_email()));
	         message.setSubject("InvAid Account Security Code");
	         message.setText("Here you have your OTP to login to your InvAid account:\n"
	         		+ loginAccount.getLogin_otp() + "\n\n"
	         		+ "Please use the code above to verify the ownership of your account.\n" 
	        		+ "As a security measure, the code will expire in 5 minutes.");
	         
	         Transport.send(message);
	         System.out.println("Mail was sent successfully!");
	         return true;
		} catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		return false;
	}
	
	public static boolean resendMultiFactorAuthentication(String email, int otp) {
		MailUtil mailUtil = (MailUtil) getMailUtility("MAIN");
		Session session = mailUtil.getSession();
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailUtil.getEmail()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("InvAid Account Security Code");
	        message.setText("Here you have your OTP to login to your InvAid account:\n"
	         		+ otp + "\n\n"
	         		+ "Please use the code above to verify the ownership of your account.\n" 
	        		+ "As a security measure, the code will expire in 5 minutes.");
	         
	        Transport.send(message);
	        System.out.println("Mail was sent successfully!");
	        return true;
		} catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		
		return false;
	}

	public static boolean sendFeedback(String name, String email, String messageContent) {
		System.out.println("Sending feedback...");
		MailUtil mailUtil 	= (MailUtil) getMailUtility("FEEDBACK");
		Session session 	= mailUtil.getSession();
		
		try {
			
			 MimeMessage message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(mailUtil.getEmail()));  
			 message.addRecipient(Message.RecipientType.TO,new InternetAddress(Configurations.getAppEmail()));
	         message.setSubject("InvAid System Feedback");  
	         message.setText("From: " + name + "\n\n"
	        		 + messageContent + "\n\n"
	        		 + "Contact via this email address: " + email);  
	         Transport.send(message);
	         System.out.println("Mail was sent successfully!");
	         return true;
			
		}
		catch(MessagingException me) {
			System.err.println(me.getMessage());
		}
		return false;
	}
}
