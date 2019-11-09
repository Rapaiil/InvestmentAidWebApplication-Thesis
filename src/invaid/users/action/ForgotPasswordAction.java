package invaid.users.action;

import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.model.UserBean;

@SuppressWarnings("serial")
public class ForgotPasswordAction extends ActionSupport {
	//Not sure but if ever, will be needed to change the name in the forgot_password.jsp
	//To match this variable and the variable in UserBean
	private String token;
	private String user_email;
	private String mailTo = user_email;
	private String mailFrom = "raphaelfeliciano7@gmail.com";
	private String password = "KuyaRFF7!";

	public String execute() {
		if(checkDataFromDatabase()) {
			//Call send email function
			if(sendMail()) {
				return "success";
			}
			else {
				return "emailerror";
			}
			
		}
		else {
			return "inputerror";	
		}
	}
	
	
	//Email Sending Related
	public boolean sendMail() {
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
	  			return new PasswordAuthentication(mailFrom, password);
	  		}
	  	};
	  		javax.mail.Session session = javax.mail.Session.getInstance(properties, auth);
	    
	    try {  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(mailFrom));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailTo));  
	         message.setSubject("Received sample mail");  
	         message.setText("Hello, this is example of sending email. Click the link below to proceed:\n\n"
	         		+ "http://www.facebook.com/");  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("Mail was sent successfully....");
	         return true;
	         
	      } catch (MessagingException mex) {
	    	  mex.printStackTrace();
	      }
	    return false;
	}
	
	
	
	//Database Related
	private List<UserBean> 	getDataFromDatabase() {
		//**********DONT REMOVE COMMENTS PLEASE THANKS**********//
		
		//Retrieve Data in Database to check if input user_email matches a existing account
		//in the database
		//UserBean user = new UserBean();
		//user = null;
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//Session session = sessionFactory.openSession();
		//
		//session.beginTransaction();
		//
		////First Param User Class, Second Param Primary Key(@Id in UserBean)
		//user = (UserBean) session.get(UserBean.class, 1);
		
		///////////////////////////////////////////////////////////////////
		//String queryString = "from tablename where user_email = : user_email";
		String queryString = "from tablename";
		
		Configuration config = new Configuration();
		config.addAnnotatedClass(UserBean.class);
		
		SessionFactory 	sessionFactory 	= config.configure().buildSessionFactory();
		Session 		session 		= sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query 	queryResult = session.createQuery(queryString);
		List<UserBean>	listResult	= (List<UserBean>) queryResult.list();	
		
		session.close();
		return listResult;
	}
	public 	boolean			checkDataFromDatabase() {
		boolean 		userExist 	= false;
		List<UserBean> 	listResult	= getDataFromDatabase();
		UserBean 		user		= new UserBean();
		
		for(int i = 0; i < listResult.size(); i++) {
			user = (UserBean) listResult.get(i);
			if(user.getUser_email().equalsIgnoreCase(this.user_email)) {
				userExist = true;
			}
		}
		
		return userExist;
	}

}
