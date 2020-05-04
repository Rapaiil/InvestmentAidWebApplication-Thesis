package invaid.users.action;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.model.UserProfileBean;
import invaid.users.util.HibernateUtil;
import invaid.users.util.Mail;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial"})
public class RegisterAccountAction extends ActionSupport implements ModelDriven<UserAccountBean>, SessionAware, Runnable, DBCommands {
	private UserAccountBean userAccount = new UserAccountBean();
	private UserProfileBean userProfile;
	private Map<String, Object> sessionMap;
	private boolean isSuccess = false;
	//Database Related
	Session session = HibernateUtil.getSession();

	public String execute() {
		userProfile = (UserProfileBean) sessionMap.get("sessionUser");
		
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			userAccount.setUser_profileId(userProfile.getUser_profileId());
			userAccount.setUser_status(00);
			userAccount.setUser_token(TokenUtil.generateToken(userProfile.getUser_firstname(), userProfile.getUser_lastname()));
			userAccount.encryptPassword();
			session.save(userAccount);
			session.save(userProfile);
			
			Mail.sendVerificationMail(userAccount);
			t.commit();
			return SUCCESS;
			//isSuccess = !isSuccess;
		} catch(HibernateException he) {
			t.rollback();
		}
		return ERROR;
//		Thread t = new Thread(this);
//		t.start();
//		if(isSuccess)
//			return SUCCESS;
//		else
//			return ERROR;
	}
	
	public void validate() {
		//Database Related
		List<Object[]> list = null;
		
		
		//Email Validation
		if(userAccount.getUser_email().trim() == null || userAccount.getUser_email().trim() == "") {
			addFieldError("user_email", "This field is required");
		} else {
			// Will be moved to configurations
			String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
			Pattern emailPattern = Pattern.compile(emailRegex);
			Matcher emailMatcher = emailPattern.matcher(userAccount.getUser_email().trim());
			if (!emailMatcher.matches()) {
				addFieldError("user_email", "Please enter a valid email");
			} else {
				// Compare the email to the database if it already exist

				 list = getRecords();
				 boolean isValid = true;
				 if(list != null) {
						for(Object record: list) {
							if(userAccount.getUser_email().equals(record)) { 
								isValid = false; 
							}
						}
						if(!isValid) {
							addFieldError("user_email","Email already useds");
						}
				 }
			}
		}
		
		//Password Validation
		if(userAccount.getUser_password().trim() == null || userAccount.getUser_password().trim() == "") {
			addFieldError("user_password", "This field is required");
			if(userAccount.getUser_repassword() == null || userAccount.getUser_repassword().trim() == "") {
				addFieldError("user_repassword", "This field is required");
			}
		}
		else {
			if(userAccount.getUser_repassword() == null || userAccount.getUser_repassword().trim() == "") {
				addFieldError("user_repassword", "This field is required");
			}
			else {
				String 	passwordRegex 	= "(?=^.{8,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s)[0-9a-zA-Z!@#$%^&*()]*$";
				Pattern passwordPattern = Pattern.compile(passwordRegex);
				Matcher passwordMatcher = passwordPattern.matcher(userAccount.getUser_password().trim());
				if(!passwordMatcher.matches()) {
					addFieldError("user_password", "Password should contain at least 1 capital, 1 small and 1 numeric characters");
				}
				else {
					if(!(userAccount.getUser_password().trim().equals(userAccount.getUser_repassword().trim()))) {
						addFieldError("user_password", "Passwords do not match");
					}
				}
			}
		}
		
		/*
		 * //Email Validation String emailRegex =
		 * "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"; Pattern pattern =
		 * Pattern.compile(emailRegex); Matcher matcher =
		 * pattern.matcher(userAccount.getUser_email());
		 * 
		 * if(!matcher.matches()) { System.out.println("result:" + matcher.matches());
		 * addFieldError("user_email", "Please enter a valid email"); }
		 * 
		 * //Password Validation
		 */	}

	
	//Database Related
	public List<Object[]> getRecords() {
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			Root<UserAccountBean> root = cq.from(UserAccountBean.class);
			cq.multiselect(root.get("user_email"));
			
			Query<Object[]> query = session.createQuery(cq);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	@Override
	public void run() {
		
	}
	
	@Override
	public UserAccountBean getModel() {
		return userAccount;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

}
