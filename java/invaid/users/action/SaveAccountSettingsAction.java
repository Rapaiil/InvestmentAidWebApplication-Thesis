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

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.util.Encrypt;
import invaid.users.util.HibernateUtil;

@SuppressWarnings("serial")
public class SaveAccountSettingsAction extends ActionSupport implements DBCommands, SessionAware, Runnable  {
	private String first_name;
	private String last_name;
	private String birthday;
	private String telephone_no;
	private String mobile_no;
	private String email_address;
	private String occupation;
	private String company;
	private String profile_id;
	Session session = HibernateUtil.getSession();
	private Map<String, Object> sessionMap;
	private boolean isSuccess = false;
	
	public String execute() {
		profile_id = (String) sessionMap.get("loginId");
		session.getTransaction().begin();
		boolean success = saveAccount();
		if(success) {
			System.out.println("updated");
		}
		else {
			System.out.println("failed");
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
	
	private boolean saveAccount() {
		try {
			Query query = session.createQuery(SAVE_ACCOUNT);
			query.setParameter("first_name", first_name);
			System.out.println(first_name);
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

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
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

}
