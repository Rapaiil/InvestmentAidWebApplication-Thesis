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

@SuppressWarnings({"serial", "rawtypes"})
public class RegisterAccountAction extends ActionSupport implements ModelDriven, SessionAware {
	private UserAccountBean userAccount = new UserAccountBean();
	private UserProfileBean userProfile;
	private Map<String, Object> sessionMap;

	public String execute() {
		userProfile = (UserProfileBean) sessionMap.get("sessionUser");
		
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		
		try {
			userAccount.setUser_profileId(userProfile.getUser_profileId());
			userAccount.setUser_status(00);
			userAccount.setUser_token(TokenUtil.generateUnverifiedToken(userProfile.getUser_firstname(), userProfile.getUser_lastname()));
			session.save(userAccount);
			session.save(userProfile);
			
			Mail.sendVerificationMail(userAccount);
			
			t.commit();
			return SUCCESS;
		} catch(HibernateException he) {
			t.rollback();
		}
		return ERROR;
	}
	
	@Override
	public Object getModel() {
		return userAccount;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}
