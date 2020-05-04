package invaid.users.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.util.HibernateUtil;

@SuppressWarnings("serial")
public class SaveAccountSettingsAction extends ActionSupport implements DBCommands, SessionAware, Runnable  {
	private String first_name;
	private String last_name;
	private String birthday;
	private String telephone_no;
	private String cellphone_no;
	private String email_address;
	private String occupation;
	private String company;
	private String profile_id;
	
	//
	//
	//Regex Reference
	//^(09|\+639|639)\d{9}$
	//
	//

	Session session = HibernateUtil.getSession();
	private Map<String, Object> sessionMap;
	private boolean isSuccess = false;
	
	public String execute() {
		profile_id = (String) sessionMap.get("loginId");
		boolean success = saveAccountSettings();
		if(success) {
			System.out.println("success");
		}
		else {
			System.out.println("fail");
		}
		return SUCCESS;
	}
	
	public void validate() {
		
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
}
