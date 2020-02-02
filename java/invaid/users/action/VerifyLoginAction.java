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
import invaid.users.util.HibernateUtil;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class VerifyLoginAction extends ActionSupport implements SessionAware, DBCommands, Runnable {
	private Map<String, Object> sessionMap;
	private String otp_login, token;
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
		String loginId;
		List<Object[]> list = null;
		
		switch(givePermission()) {
			case "denied": return;
		}
		
		loginId = (String) sessionMap.get("loginId");
		session.getTransaction().begin();
		
		list = getRecords();
		
		if(list != null) {
			for(Object[] record: list) {
				if(record[1].toString().equals(token)
					&& (record[2].toString().length() < 6 ? String.format("%02d", Integer.parseInt(record[2].toString())) : record[2].toString())
					.equals((otp_login.length() < 6 ? String.format("%02d", Integer.parseInt(otp_login)) : otp_login))) {
					
					token = TokenUtil.generateToken((String)sessionMap.get("loginFirstName"), (String)sessionMap.get("loginLastName"));
					
					if(updateUserToken(token, loginId, (int)record[3])) {
						sessionMap.replace("loginToken", token);
						isSuccess = !isSuccess;
						return;
					}
				}
			}
		}
		return;
	}
	
	public String getOtp_login() {
		return otp_login;
	}

	public void setOtp_login(String otp_login) {
		this.otp_login = otp_login;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	private String givePermission() {
		try {
			if(token == null)
				throw new NullPointerException("Token is empty!");
			TokenUtil.verifyUserToken().verify(token);
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
	
	private boolean updateUserToken(String token, String id, int status) {
		try {
			Query query = session.createQuery(UPDATE_OTP_TOKEN);
			query.setParameter("tok", token);
			query.setParameter("status", status);
			query.setParameter("otp", null);
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
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			Root<UserAccountBean> root = cq.from(UserAccountBean.class);
			cq.multiselect(root.get("user_profileId"), root.get("user_token"),
					root.get("user_otp"), root.get("user_status"));
			
			Query<Object[]> query = session.createQuery(cq);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
}
