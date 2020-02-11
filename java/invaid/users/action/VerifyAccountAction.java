package invaid.users.action;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

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
public class VerifyAccountAction extends ActionSupport implements DBCommands, Runnable {
	private String token;
	Session session = HibernateUtil.getSession();
	private boolean isSuccess = false;
	
	public String execute() {
		List<Object[]> list = null;
		session.getTransaction().begin();
		
		/*
		 * Steps on verifying the JWT:
		 *  0) General check for token (JWTVerificationException)
		 *  1) Check the structure including header, payload and signature formats (JWTDecodedException)
		 *  2) Check the signature (AlgorithmMismatchException, SignatureVerificationException)
		 *  3) Check for private claims (InvalidClaimException)
		 *  4) Check for expiration (TokenExpiredException)
		 */
		try {
			TokenUtil.verifyUserToken().verify(token);
		} catch(JWTDecodeException | AlgorithmMismatchException | SignatureVerificationException jwtve) {
			System.err.println("Invalid token! Access is denied.");
		} catch(InvalidClaimException jwtve) {
			System.err.println("Access is denied.");
		} catch(TokenExpiredException jwtve) {
			System.err.println("Session has expired!");
		} catch(JWTVerificationException jwtve) {
			System.err.println(jwtve.getMessage());
		}
		
		list = getRecords();
		
		if(list != null) {
			for(Object[] record: list) {
				if(record[0].toString().equals(token)) {
					if(updateUserStatus(token)) {
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
		//
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public List<Object[]> getRecords() {
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			Root<UserAccountBean> root = cq.from(UserAccountBean.class);
			cq.multiselect(root.get("user_token"), root.get("user_profileId"));
			
			Query<Object[]> query = session.createQuery(cq);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return null;
	}
	
	public boolean updateUserStatus(String token) {
		try {
			Query query = session.createQuery(VERIFY_USER);
			query.setParameter("status", 10);
			query.setParameter("newtok", null);
			query.setParameter("tok", token);
			
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
