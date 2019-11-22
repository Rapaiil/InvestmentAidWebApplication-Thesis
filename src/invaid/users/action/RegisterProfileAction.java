package invaid.users.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.UserProfileBean;

@SuppressWarnings({"serial", "rawtypes"})
public class RegisterProfileAction extends ActionSupport implements ModelDriven, SessionAware {
	private UserProfileBean temp_user = new UserProfileBean();
	private Map<String, Object> sessionMap;

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return temp_user;
	}
	
	public String addProfile() {
		//validation here
		sessionMap.put("sessionUser", temp_user);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}
}
