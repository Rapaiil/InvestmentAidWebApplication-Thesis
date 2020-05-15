package invaid.users.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import invaid.users.model.AccountSettingDetail;
import invaid.users.util.HibernateUtil;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class AccountSettingsAction extends ActionSupport implements SessionAware, DBCommands {
	private Map<String, Object> sessionMap;
	Session session = HibernateUtil.getSession();
	private String token, loginId;
	private AccountSettingDetail account = null;
	
	@Override
	public String execute() {
		List<Object[]> list = null;
		token = (String) sessionMap.get("loginToken");
		loginId = (String) sessionMap.get("loginId");
		
		switch(givePermission()) {
			case "denied": return ERROR;
		}
		
		session.getTransaction().begin();
		list = getRecords();
		
		try {
			if(list != null) {
				for(Object[] record: list) {
					Date date = new SimpleDateFormat("yyyy/MM/dd").parse(record[3].toString());
					account = new AccountSettingDetail();
					account.setUser_firstName(record[1].toString());
					account.setUser_lastName(record[2].toString());
					account.setUser_birthday(new SimpleDateFormat("yyyy-MM-dd").format(date));
					account.setUser_telno(record[4].toString());
					account.setUser_cellno(record[5].toString());
					account.setUser_occupation(record[6].toString());
					account.setUser_company(record[7].toString());
					account.setUser_email(record[8].toString());
					
					return SUCCESS;
				}
			}
		} catch(ParseException pe) {
			System.err.println(pe.getMessage());
		}
		return ERROR;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	@Override
	public List<Object[]> getRecords() {
		try {
			Query query = session.createQuery(GET_ACCOUNT_RECORD);
			query.setParameter("id", loginId);
			
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	public AccountSettingDetail getAccount() {
		return this.account;
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

}
