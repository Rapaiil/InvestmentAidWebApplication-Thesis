package invaid.users.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.Mail;
import invaid.users.model.UserAccountBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class ForgotPasswordAction extends ActionSupport implements ModelDriven{
	private UserAccountBean user = new UserAccountBean();
	Session session = HibernateUtil.getSession();
	
	//Execute
	public String execute() {
		if(checkRecords()) {
			System.out.println("Account exist");
			//Generate token
			//Needed from Raph's Part
			
			//Update account status to forgot password
			//Neede from Raph's Part
			
			//Send email
			//Mail.sendPasswordResetMail(user);
			
			return SUCCESS;
		}
		System.out.println("Account does not exist");
		return ERROR;
	}

	//Functions
	/* This is for object retrieval
	 * public boolean checkRecords() { boolean recordsExist = false; List
	 * recordsList = getRecords();
	 * 
	 * if(recordsList != null) { //System.out.println("No. of Records:" +
	 * recordsList.size()); UserAccountBean temp; for(int i = 0; i <
	 * recordsList.size(); i++) { temp = (UserAccountBean) recordsList.get(i);
	 * if(user.getUser_email().equals(temp.getUser_email())) {
	 * //System.out.println("Record Exist"); //Token should be set here from temp to
	 * user //temp.setUser_accountId(user.getUser_accountId()); //Update account
	 * status //temp.setUser_accountStatus(1,0,-1); recordsExist = true; } } }
	 * return recordsExist; }
	 */
	
	public boolean checkRecords() {
		boolean recordsExist = false;
		List recordsList = getRecords();
		
		if(recordsList!=null) {
			String resultEmail;
			
			for(int i=0; i< recordsList.size(); i++) {
				resultEmail = (String) recordsList.get(i);
				if(resultEmail.equals(user.getUser_email())) {
					recordsExist = true;
				}
			}
		}
		return recordsExist;
	}
	
	private List getRecords() {
		List recordsList = new ArrayList();
		
		try {
			session.beginTransaction();
			recordsList = session.createQuery("SELECT account.user_email from UserAccountBean as account").list();
		}
		catch(Exception sqle) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			System.out.println("Stack trace here");
			sqle.printStackTrace();
		}
		finally {
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
	
	//Implemented Methods
	@Override
	public Object getModel() {
		return user;
	}
}