package invaid.users.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

<<<<<<< Updated upstream
import invaid.users.model.UserBean;

=======
import invaid.users.model.UserAccountBean;
import invaid.users.action.MailAction;
>>>>>>> Stashed changes
@SuppressWarnings("serial")
public class ForgotPasswordAction extends ActionSupport implements ModelDriven{
	//Variables
	private UserAccountBean user = new UserAccountBean();
	private MailAction mail;
	static 	Session 		session;
	static 	SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
<<<<<<< Updated upstream
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
=======
	//Execute
	public String execute() {
		boolean accountExist = checkRecords();
		if(accountExist) {
			mail.sendPasswordResetEmail(user);
			return SUCCESS;
		}
		return ERROR;
	}
	
	//Functions
	public boolean checkRecords() {
		boolean recordsExist = false;
		
		List recordsList = getRecords();
		
		if(recordsList != null) {
			UserAccountBean temp;
			for(int i = 0; i < recordsList.size(); i++) {
				temp = (UserAccountBean) recordsList.get(i);
				if(user.getUser_email().equalsIgnoreCase(temp.getUser_email())) {
					System.out.println("Valid Email");
					user = temp;
					recordsExist = true;
				}
			}
		}
		return recordsExist;
	}
	private List getRecords() {
		List recordsList = new ArrayList();
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			recordsList = session.createQuery("FROM UserAccountBean").list();
		}
		catch(Exception sqle) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
>>>>>>> Stashed changes
			}
			sqle.printStackTrace();
		}
		finally{
			if(session != null) {
				session.close();
			}
		}
		return recordsList;
	}


	//Getters and Setters
	public UserAccountBean getUser() {
		return user;
	}

	public void setUser(UserAccountBean user) {
		this.user = user;
	}
	
	//Implemented Functions
	@Override
	public Object getModel() {
		return user;
	}
}
