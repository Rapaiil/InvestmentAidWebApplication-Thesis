package invaid.users.action;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.util.Encrypt;
import invaid.users.util.HibernateUtil;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class RenewPasswordAction extends ActionSupport implements DBCommands, SessionAware, Runnable {
	private String token;
	private String reset_password;
	private String reset_confirmpassword;
	private Map<String, Object> sessionMap;
	Session session = HibernateUtil.getSession();
	private boolean isSuccess = false;
	
	public String execute() {
		token = (String) sessionMap.get("token");
		List<Object[]> list = null;
		session.getTransaction().begin();
		
		switch(givePermission()) {
			case "denied": return ERROR;
		}
		
		if(!arePasswordsMatch()) {
			return ERROR;
		}
		
		list = getRecords();
		
		if(list != null) {
			for(Object[] record: list) {
				if(record[0].toString().equals(token)) {
					if(updateUserPassword(record[1].toString(), (int) record[2])) {
						//isSuccess = !isSuccess;
						return SUCCESS;
					}
				}
			}
		}
		return ERROR;
//		Thread t = new Thread(this);
//		t.start();
//		if(isSuccess)
//			return SUCCESS;
//		else
//			return ERROR;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private boolean arePasswordsMatch() {
		return reset_password.equals(reset_confirmpassword);
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	private boolean updateUserPassword(String id, int stats) {
		int stat = getConvertedStatus(stats);
		
		try {
			Query query = session.createQuery(UPDATE_PASSWORD);
			query.setParameter("pass", String.valueOf(Encrypt.bcrypt(reset_password.toCharArray())));
			query.setParameter("tok", null);
			query.setParameter("status", stat);
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
	
	private int getConvertedStatus(int status) {
		status /= 10;
		status *= 10;
		return status;
	}
	
	public String givePermission() {
		try {
			TokenUtil.verifyUserToken().verify(token);
			if(sessionMap.isEmpty())
				sessionMap.put("token", token);
			return "granted";
		} catch(JWTDecodeException | AlgorithmMismatchException | SignatureVerificationException jwtve) {
			System.err.println("Invalid token! Access is denied.");
		} catch(InvalidClaimException jwtve) {
			System.err.println("Access is denied.");
		} catch(TokenExpiredException jwtve) {
			System.err.println("Session has expired!");
		} catch(JWTVerificationException jwtve) {
			System.err.println(jwtve.getMessage());
		}
		return "denied";
	}
	
	@Override
	public List<Object[]> getRecords() {
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			Root<UserAccountBean> root = cq.from(UserAccountBean.class);
			cq.multiselect(root.get("user_token"), root.get("user_profileId"), root.get("user_status"));
			
			Query<Object[]> query = session.createQuery(cq);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return null;
	}
}
