package invaid.users.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.LoginAccountView;

@SuppressWarnings({"serial", "rawtypes"})
public class LoginAccountAction extends ActionSupport implements ModelDriven, SessionAware {
	private LoginAccountView loginAccount = new LoginAccountView();
	private Map<String, Object> sessionMap;
	
	public String execute() {
		sessionMap.put("loginAccount", loginAccount);
		
		return SUCCESS;
	}
	
	@Override
	public Object getModel() {
		return loginAccount;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}

}
