package invaid.users.action;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.util.HibernateUtil;
import invaid.users.util.Mail;

@SuppressWarnings({"serial"})
public class ResendOTPAction extends ActionSupport implements SessionAware, DBCommands {
	private Map<String, Object> sessionMap;
	private List<Object[]> otprecords;
	Session session = HibernateUtil.getSession();
	private String token;
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		token = (String) sessionMap.get("loginToken");
		
		otprecords = getRecords();
		if(otprecords != null) {
			for(Object[] record: otprecords) {
				if(record[0] != null && record[0].toString().equals(token)) {
					if(Mail.resendMultiFactorAuthentication(record[2].toString(), Integer.parseInt(record[1].toString())))
						return SUCCESS;
					return ERROR;
				}
			}
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
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
			Root<UserAccountBean> root = cq.from(UserAccountBean.class);
			cq.multiselect(root.get("user_token"), root.get("user_otp"),
					root.get("user_email"));
			
			Query<Object[]> query = session.createQuery(cq);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		
		return null;
	}
}
