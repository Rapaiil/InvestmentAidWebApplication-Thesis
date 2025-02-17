package invaid.users.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import at.favre.lib.crypto.bcrypt.BCrypt;
import invaid.users.db.DBCommands;
import invaid.users.model.LoginAccountModel;
import invaid.users.util.AESEncryption;
import invaid.users.util.HibernateUtil;
import invaid.users.util.Mail;
import invaid.users.util.OTPUtil;
import invaid.users.util.TokenUtil;
import invaid.users.util.VerifyreCAPTCHA;

@SuppressWarnings({"serial", "rawtypes"})
public class LoginAccountAction extends ActionSupport implements ModelDriven<LoginAccountModel>, SessionAware, DBCommands, Runnable {
	private LoginAccountModel loginAccount = new LoginAccountModel();
	private Map<String, Object> sessionMap;
	private String token;
	Session session = HibernateUtil.getSession();
	String gRecaptchaResponse = ServletActionContext.getRequest().getParameter("g-recaptcha-response");
	
	public String execute() {
		session.getTransaction().begin();
		
		List<Object[]> list = getRecords();
		
		if(list != null) {
			for(Object[] record: list) {
				if(AESEncryption.decrypt(record[4].toString()).equals(loginAccount.getLogin_email())
					&& isPasswordMatch(loginAccount.getLogin_password(), record[5].toString())) {
					if(allowLogin(record[6].toString())) {
						token = TokenUtil.generateToken(AESEncryption.decrypt(record[1].toString()), AESEncryption.decrypt(record[2].toString()));
						loginAccount.setLogin_otp(new OTPUtil().generateOTP());
						if(updateUserToken(record[0].toString(), (int) record[6], token,
								loginAccount.getLogin_otp()) && Mail.sendMultiFactorAuthentication(loginAccount)) {
							sessionMap.put("loginToken", token);
							sessionMap.put("loginId", record[0].toString());
							sessionMap.put("loginFirstName", AESEncryption.decrypt(record[1].toString()));
							sessionMap.put("loginLastName", AESEncryption.decrypt(record[2].toString()));
							sessionMap.put("userStatus", getSessionStatus((int) record[6]));
							return SUCCESS;
						}
						return ERROR;
					}
					return "denied";
				}
			}
			System.err.println("Email or password is not equal");
			return "invalid";
		}
		return ERROR;
	}
	
	public void validate() {
		boolean recaptchaSuccess = false;
		try {
			recaptchaSuccess = VerifyreCAPTCHA.verify(gRecaptchaResponse);
		}
		catch(IOException ioe){
			ioe.getMessage();
		}
		
		if(!recaptchaSuccess) {
			addFieldError("lgrn","Invalid reCAPTCHA");
		}
	}
	
	@Override
	public void run() {
		
	}
	
	@Override
	public LoginAccountModel getModel() {
		return loginAccount;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private boolean allowLogin(String status) {
		int n = Integer.parseInt(status);
		return ((n %= 10) == 1 ? false : true);
	}
	
	private String getSessionStatus(int status) {
		int process = status % 10;
		if(process == 0) {
			status /= 10;
			switch(status) {
			case 1: return "verified";
			case 0: return "unverified";
			}
		}
		return "on-going";
	}
	
	private boolean isPasswordMatch(String inputPassword, String storedPassword) {
		return BCrypt.verifyer().verify(inputPassword.toCharArray(), storedPassword.toCharArray()).verified;
	}
	
	private boolean updateUserToken(String id, int status, String token, int otp) {
		try {
			Query query = session.createQuery(UPDATE_OTP_TOKEN);
			query.setParameter("tok", token);
			query.setParameter("status", status);
			query.setParameter("otp", otp);
			query.setParameter("id", id);
			
			if(query.executeUpdate() > 0) {
				session.getTransaction().commit();
				return true;
			}
		} catch(HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} catch(Exception e ) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getRecords() {
		try {
			Query<Object[]> query = session.createQuery(GET_LOGIN_RECORDS);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	public String getgRecaptchaResponse() {
		return gRecaptchaResponse;
	}

	public void setgRecaptchaResponse(String gRecaptchaResponse) {
		this.gRecaptchaResponse = gRecaptchaResponse;
	}

}
