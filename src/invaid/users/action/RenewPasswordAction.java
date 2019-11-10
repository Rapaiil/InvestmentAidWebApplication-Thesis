package invaid.users.action;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.model.UserBean;

@SuppressWarnings("serial")
public class RenewPasswordAction extends ActionSupport {
	
	private String password;
	private String confirm_password;
	
	public String execute() {
		return SUCCESS;
	}	
	public boolean verifyPassword() {
		boolean passwords_match = false;
		if(this.password == this.confirm_password) {
			passwords_match = true;
		}
		
		return passwords_match;
		
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
		public 	void			changePassword() {
			List<UserBean> 	listResult	= getDataFromDatabase();
			UserBean 		user		= new UserBean();
			
		}
		public 	boolean			checkToken() {
			return false;
		}
}
