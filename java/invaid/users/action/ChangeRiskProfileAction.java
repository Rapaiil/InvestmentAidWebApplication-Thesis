package invaid.users.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.model.RPCharacteristics;
import invaid.users.model.UserRiskProfileBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class ChangeRiskProfileAction extends ActionSupport implements DBCommands, SessionAware {
	private Map<String, Object> sessionMap;
	private String riskProfileResult;
	private UserRiskProfileBean urp;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		String profileId = (String) sessionMap.get("loginId");
		
		List<Object[]> list = getRecords();
		
		if(list != null) {
			System.out.println("meron list");
//			for(Object[] record: list) {
//				System.out.println("meron record");
//				if(record[0].toString() != null && record[0].toString().equals(profileId)) {
//					System.out.println("update na lang");
//					if(updateRiskProfile())
//						session.getTransaction().commit();
//				} else {
//					System.out.println("add na lang");
//					int rpType = getRiskProfileType(riskProfileResult);
//					
//					urp = new UserRiskProfileBean();
//					urp.setUser_profileId(profileId);
//					urp.setUser_riskprofile(rpType);
//					
//					session.save(urp);
//					session.getTransaction().commit();
//				}
//				System.out.println("unreachable");
//				return SUCCESS;
//			}
		}
		System.out.println("walang list");
		session.getTransaction().rollback();
		return ERROR;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public String getRiskProfileResult() {
		return riskProfileResult;
	}

	public void setRiskProfileResult(String riskProfileResult) {
		this.riskProfileResult = riskProfileResult;
	}

	@Override
	public List<Object[]> getRecords() {
		String profileId = (String) sessionMap.get("loginId");
		
		try {
			Query query = session.createQuery(GET_USER_RP);
			query.setParameter("profid", profileId);
			
			return query.getResultList();
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
			session.getTransaction().rollback();
		}
		
		return null;
	}
		
	private boolean updateRiskProfile() {
		String profileId = (String) sessionMap.get("loginId");
		int rpType = getRiskProfileType(riskProfileResult);
		
		try {
			Query query = session.createQuery(UPDATE_RISKPROFILE);
			query.setParameter("rptype", rpType);
			query.setParameter("profid", profileId);
			
			if(query.executeUpdate() > 0)
				return true;
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
			session.getTransaction().rollback();
		}
		return false;
	}
	
	private int getRiskProfileType(String type) {
		switch(type) {
			case RPCharacteristics.CONSERVATIVE: return 1;
			case RPCharacteristics.MODERATELY_CONSERVATIVE: return 2;
			case RPCharacteristics.MODERATE: return 3;
			case RPCharacteristics.MODERATELY_AGGRESSIVE: return 4;
			case RPCharacteristics.AGGRESSIVE: return 5;
			default: return 0;
		}
	}
	
}
