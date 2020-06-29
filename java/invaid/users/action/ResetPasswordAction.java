package invaid.users.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.util.Encrypt;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class ResetPasswordAction extends ActionSupport implements DBCommands, SessionAware, Runnable {
	private String reset_password;
	private String reset_confirmpassword;
	private Map<String, Object> sessionMap;
	Session session = HibernateUtil.getSession();
	
	public String execute() {
		String id = (String) sessionMap.get("loginId");
		session.getTransaction().begin();
		
		if(arePasswordsMatch()) {
			if(updateNewUserPassword(id))
				return SUCCESS;
		}
		
		return ERROR;
	}
	
	@Override
	public void run() {
		
	}

	public String getReset_password() {
		return reset_password;
	}

	public void setReset_password(String reset_password) {
		this.reset_password = reset_password;
	}

	public String getReset_confirmpassword() {
		return reset_confirmpassword;
	}

	public void setReset_confirmpassword(String reset_confirmpassword) {
		this.reset_confirmpassword = reset_confirmpassword;
	}
	
	private boolean arePasswordsMatch() {
		return reset_password.equals(reset_confirmpassword);
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	private boolean updateNewUserPassword(String id) {
		try {
			Query query = session.createQuery(UPDATE_NEW_PASSWORD);
			query.setParameter("pass", String.valueOf(Encrypt.bcrypt(reset_password.toCharArray())));
			query.setParameter("id", id);
			
			if(query.executeUpdate() > 0) {
				session.getTransaction().commit();
				return true;
			}
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public List<Object[]> getRecords() {
		// TODO Auto-generated method stub
		return null;
	}
}
