package invaid.users.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class LogoutUserAction extends ActionSupport implements SessionAware, Runnable {
	private String token, id;
	private int status;
	private Map<String, Object> sessionMap;
	Session session = HibernateUtil.getSession();
	private boolean isSuccess = false;
	
	public String execute() {
		Thread t = new Thread(this);
		t.start();
		if(isSuccess)
			return SUCCESS;
		else
			return ERROR;
	}
	
	@Override
	public void run() {
		token = (String) sessionMap.get("loginToken");
		id = (String) sessionMap.get("loginId");
		status = getStatus((String) sessionMap.get("userStatus"));
		
		System.out.println("Token: " + token);
		System.out.println("Id: " + id);
		System.out.println("Stats: " + status);
		session.getTransaction().begin();
		
		if(updateUserToken(token, id, status)) {
			sessionMap.remove("loginToken");
			sessionMap.remove("loginId");
			sessionMap.remove("loginFirstName");
			sessionMap.remove("loginLastName");
			sessionMap.remove("loginEmail");
			sessionMap.remove("userStatus");
			sessionMap.clear();
			if(sessionMap.isEmpty()) {
				isSuccess = !isSuccess;
				return;
			}
		}
		return;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	private int getStatus(String status) {
		switch(status) {
		case "unverified": return 0;
		case "verified": return 10;
		default: return -1;
		}
	}
	
	private boolean updateUserToken(String token, String id, int status) {
		try {
			Query query = session.createQuery(DBCommands.UPDATE_TOKEN);
			query.setParameter("tok", null);
			query.setParameter("status", status);
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
}
