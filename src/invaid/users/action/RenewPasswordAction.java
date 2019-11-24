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
>>>>>>> Stashed changes



@SuppressWarnings({ "serial", "rawtypes" })
public class RenewPasswordAction extends ActionSupport implements ModelDriven{
	//Variables
	private String 			token;
	private String 			password;
	private String 			confirmPassword;
	static 	Session 		session;
	static 	SessionFactory 	sessionFactory = new Configuration().configure().buildSessionFactory();
	
	//Execute
	public String execute() {
		if(verifyPasswords()) {
			if(checkRecords()) {
				//Update Password
				boolean passwordChanged = updatePassword();
				if(passwordChanged) {
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}	
	
	//Functions
	private boolean updatePassword() {
		boolean updateSuccess = false;
		try {
			sessionFactory 	= new Configuration().configure().buildSessionFactory();
			session 		= sessionFactory.openSession();
			
			session.beginTransaction();
			
			UserAccountBean updateUser = (UserAccountBean) session.get(UserAccountBean.class, token);
			updateUser.setUser_password(password);
			
			session.getTransaction().commit();
			updateSuccess = true;
		}
		catch(Exception sqle) {
			 if(null != session.getTransaction()) {
				 session.getTransaction().rollback();
	            }
			 sqle.printStackTrace();
		}
		finally {
            if(session != null) {
            	session.close();
            }
		}
		
		return updateSuccess;
	}
	private boolean verifyPasswords() {
		boolean passwordsMatch = false;
		
		if(password.equals(confirmPassword)) {
			passwordsMatch = true;
		}
		
		return passwordsMatch;
	}
<<<<<<< Updated upstream
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
		public 	void			changePassword() {
			List<UserBean> 	listResult	= getDataFromDatabase();
			UserBean 		user		= new UserBean();
			
		}
		public 	boolean			checkToken() {
			
=======
	public boolean checkRecords() {
		boolean recordsExist = false;
		
		List recordsList = getRecords();
		
		if(recordsList != null) {
			UserAccountBean temp;
			for(int i = 0; i < recordsList.size(); i++) {
				temp = (UserAccountBean) recordsList.get(i);
				if(temp.getUserProfile().equals(token)) {
					System.out.println("Token Match Email");
					recordsExist = true;
				}
			}
		}
		return recordsExist;
	}
	
	//DB Related Functions
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
			}
			sqle.printStackTrace();
		}
		finally{
			if(session != null) {
				session.close();
			}
>>>>>>> Stashed changes
		}
		return recordsList;
	}
	
	//Getters and Setters
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	//Implemented Methods
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
