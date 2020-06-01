package invaid.users.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.util.HibernateUtil;

@SuppressWarnings("serial")
public class ChartPortfolioAction extends ActionSupport implements SessionAware, DBCommands {
	private Map<String, Object> sessionMap;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;		
	}
	
	@Override
	public List<Object[]> getRecords() {
		return null;
	}
	

}
