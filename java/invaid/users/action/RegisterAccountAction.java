package invaid.users.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.UserAccountBean;
import invaid.users.model.UserProfileBean;
import invaid.users.util.HibernateUtil;
import invaid.users.util.Mail;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial"})
public class RegisterAccountAction extends ActionSupport implements ModelDriven<UserAccountBean>, SessionAware, Runnable {
	private UserAccountBean userAccount = new UserAccountBean();
	private UserProfileBean userProfile;
	private Map<String, Object> sessionMap;
	private boolean isSuccess = false;

	public String execute() {
		userProfile = (UserProfileBean) sessionMap.get("sessionUser");
		
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			userAccount.setUser_profileId(userProfile.getUser_profileId());
			userAccount.setUser_status(00);
			userAccount.setUser_token(TokenUtil.generateToken(userProfile.getUser_firstname(), userProfile.getUser_lastname()));
			userAccount.encryptPassword();
			session.save(userAccount);
			session.save(userProfile);
			
			Mail.sendVerificationMail(userAccount);
			t.commit();
			return SUCCESS;
			//isSuccess = !isSuccess;
		} catch(HibernateException he) {
			t.rollback();
		}
		return ERROR;
//		Thread t = new Thread(this);
//		t.start();
//		if(isSuccess)
//			return SUCCESS;
//		else
//			return ERROR;
	}
	
	public void validate() {
		if(userAccount.getUser_password()!="Aaron") {
			addFieldError("user_password", "The password must be Aaron");
		}
	}
	
	@Override
	public void run() {
		
	}
	
	@Override
	public UserAccountBean getModel() {
		return userAccount;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}
