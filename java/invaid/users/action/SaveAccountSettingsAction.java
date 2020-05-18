package invaid.users.action;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings("serial")
public class SaveAccountSettingsAction extends ActionSupport implements ModelDriven<UserAccountBean>, DBCommands, SessionAware, Runnable  {
	private String first_name;
	private String last_name;
	private String birthday;
	private String telephone_no;
	private String cellphone_no;
	private String email_address;
	private String occupation;
	private String company;
	private String profile_id;
	
	private UserAccountBean userAccount = new UserAccountBean();
	private Map<String, Object> sessionMap;
	private boolean isSuccess = false;
	Session session = HibernateUtil.getSession();
	
	public String execute() {
		profile_id = (String) sessionMap.get("loginId");
		int cnLength = cellphone_no.length();
		if(cnLength == 11) {
			cellphone_no = cellphone_no.substring(cnLength-10, cnLength);
		}
		else if(cnLength == 12) {
			cellphone_no = cellphone_no.substring(cnLength-10, cnLength);
		}
		else if(cnLength == 13) {
			cellphone_no = cellphone_no.substring(cnLength-10, cnLength);
		}
		int tnLength = telephone_no.length();
		telephone_no = telephone_no.substring(tnLength-8, tnLength);
		
		boolean success = saveAccountSettings();
		
		if(success) { System.out.println("success"); } else {
		System.out.println("fail"); }
		
		return SUCCESS;
	}
	
	public void validate() {
		boolean fnValid = ValidateEmpty(first_name);
		boolean lnValid = ValidateEmpty(last_name);
		boolean tnValid = ValidateEmpty(telephone_no);
		boolean cnValid = ValidateEmpty(cellphone_no);
		boolean eaValid = ValidateEmpty(email_address);
		boolean occValid = ValidateEmpty(occupation);
		boolean cmpValid = ValidateEmpty(company);
		
		//First Name
		if(!fnValid) {
			addFieldError("first_name", "This field is required");
		}
		else {
			fnValid = ValidateName(first_name);
			if(!fnValid) {
				addFieldError("first_name", "Please enter a valid name");
			}
		}
		
		//Last Name
		if(!lnValid){
			addFieldError("last_name", "This field is required");
		}
		else {
			lnValid = ValidateName(last_name);
			if(!lnValid) {
				addFieldError("last_name", "Please enter a valid name");
			}
		}
		
		//Telephone Number
		if(!tnValid){
			addFieldError("occupation", "This field is required");
		}
		else {
			tnValid = ValidateTel(telephone_no);
			if(!cnValid) {
				addFieldError("telephone_no", "Please enter a valid telephone no");
			}
		}
		
		//Cellphone Number
		if(!cnValid){
			addFieldError("cellphone_no", "This field is required");
		}
		else {
			cnValid = ValidateCell(cellphone_no);
			if(!cnValid) {
				addFieldError("cellphone_no", "Please enter a valid cellphone no");
			}
		}
		
		//Email Address
		if(!eaValid){
			addFieldError("email_address", "This field is required");
		}
		else {
			eaValid = ValidateEmail(email_address);
			if(!eaValid) {
				addFieldError("email_address", "Please enter a valid email address");
			}
			else {
				eaValid = EmailExist(email_address);
				if(!eaValid) {
					addFieldError("email_address", "This email is already used");
				}
			}
		}
		
		//Occupation
		if(!occValid){
			addFieldError("occupation", "This field is required");
		}
		
		//Company
		if(!cmpValid){
			addFieldError("company", "This field is required");
		}
		
	}

	@Override
	public void run() {
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	@Override
	public List<Object[]> getRecords() {
		try {
			//String GET_LOGIN_RECORDSs = "SELECT user_email FROM UserAccountBean";
			Query<Object[]> query = session.createQuery(GET_EMAILS);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	private boolean saveAccountSettings() {
		session.getTransaction().begin();
		boolean isSaveAccountSuccess = saveAccount();
		session.getTransaction().begin();
		boolean isSaveProfileSuccess = saveProfile();
		
		if(isSaveAccountSuccess && isSaveProfileSuccess) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean saveAccount() {
		try {
			Query query = session.createQuery(SAVE_ACCOUNT);
			query.setParameter("email", email_address);
			query.setParameter("profid", profile_id);
			
			if(query.executeUpdate() > 0) {
				session.getTransaction().commit();
				return true;
			}
		}
		catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return false;
	}
	
	private boolean saveProfile() {
		try {
			Query query = session.createQuery(SAVE_PROFILE);
			query.setParameter("first_name", first_name);
			query.setParameter("last_name", last_name);
			query.setParameter("birthday", birthday);
			query.setParameter("cellphone_no", cellphone_no);
			query.setParameter("telephone_no", telephone_no);
			query.setParameter("occupation", occupation);
			query.setParameter("company", company);
			query.setParameter("profid", profile_id);

			if(query.executeUpdate() > 0) {
				session.getTransaction().commit();
				return true;
			}
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return false;
	}
	
	private boolean ValidateEmpty(String string) {
		if(string.trim() != "" || string.trim() != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean ValidateName(String string) {
		String nameRegex = "^[A-Za-z_-]*$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(string.trim());
		if (nameMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean ValidateEmail(String string) {
		String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(string.trim());
		if (emailMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean ValidateTel(String string) {
		String telRegex = "^(\\d{2})\\d{8}$/";
		Pattern telPattern = Pattern.compile(telRegex);
		Matcher telMatcher = telPattern.matcher(string.trim());
		if (telMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean ValidateCell(String string) {
		String cellRegex = "^(09|\\+639|639)\\d{9}$";
		Pattern cellPattern = Pattern.compile(cellRegex);
		Matcher cellMatcher = cellPattern.matcher(string.trim());
		if (cellMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean EmailExist(String string) {
		List<Object[]> list = getCurrentEmail();
		 boolean isSame = false;
		 if(list != null) {
				for(Object record: list) {
					if(string.equals(record)) { 
						isSame = true; 
					}
				}
				if(isSame) {
					return true;
				}
				else {
					List<Object[]> list2 = getRecords();
					 boolean isValid = true;
					 if(list2 != null) {
							for(Object record: list2) {
								if(string.equals(record)) { 
									isValid = false; 
								}
							}
							if(!isValid) {
								return false;
							}
					 }
				}
		 }
		 return true;
	}
	
	private List<Object[]> getCurrentEmail() {
		try {
			Query<Object[]> query = session.createQuery(GET_CURRENT_EMAIL);
			query.setParameter("profid", profile_id);
			
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	//getters and setters
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTelephone_no() {
		return telephone_no;
	}

	public void setTelephone_no(String telephone_no) {
		this.telephone_no = telephone_no;
	}

	public String getCellphone_no() {
		return cellphone_no;
	}

	public void setCellphone_no(String cellphone_no) {
		this.cellphone_no = cellphone_no;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	@Override
	public UserAccountBean getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
