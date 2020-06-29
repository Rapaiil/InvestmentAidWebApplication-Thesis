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
import invaid.users.model.RiskProfileModel;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class CheckRiskProfileAction extends ActionSupport implements SessionAware, DBCommands, RPCharacteristics{
	private Map<String, Object> sessionMap;
	private RiskProfileModel rpModel = null;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		String profileId = (String) sessionMap.get("loginId");
		List<Object[]> list = getRecords();
		
		rpModel = new RiskProfileModel();
		
		if(list != null && !list.isEmpty()) {
			for(Object[] record: list) {
				if(record[0].toString().equals(profileId)) {
					switch(Integer.parseInt(record[1].toString())) {
						case 1: rpModel.setRiskProfileResult(CONSERVATIVE);
								rpModel.setRiskProfileObjectives(C_OBJ);
								rpModel.setRiskProfileHorizon(C_HORIZON);
								rpModel.setRiskProfileDesc(C_DESC); break;
						case 2: rpModel.setRiskProfileResult(MODERATELY_CONSERVATIVE);
								rpModel.setRiskProfileObjectives(MC_OBJ);
								rpModel.setRiskProfileHorizon(MC_HORIZON);
								rpModel.setRiskProfileDesc(MC_DESC); break;
						case 3: rpModel.setRiskProfileResult(MODERATE);
								rpModel.setRiskProfileObjectives(M_OBJ);
								rpModel.setRiskProfileHorizon(M_HORIZON);
								rpModel.setRiskProfileDesc(M_DESC); break;
						case 4: rpModel.setRiskProfileResult(MODERATELY_AGGRESSIVE);
								rpModel.setRiskProfileObjectives(MA_OBJ);
								rpModel.setRiskProfileHorizon(MA_HORIZON);
								rpModel.setRiskProfileDesc(MA_DESC); break;
						case 5: rpModel.setRiskProfileResult(AGGRESSIVE);
								rpModel.setRiskProfileObjectives(A_OBJ);
								rpModel.setRiskProfileHorizon(A_HORIZON);
								rpModel.setRiskProfileDesc(A_DESC); break;
						default: rpModel.setRiskProfileResult(NO_COMPATIBLE); rpModel.setRiskProfileObjectives("NONE"); rpModel.setRiskProfileHorizon("NONE"); rpModel.setRiskProfileDesc("NONE");
					}
				}
			}
		}
		session.getTransaction().commit();
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public RiskProfileModel getRpModel() {
		return rpModel;
	}

	public void setRpModel(RiskProfileModel rpModel) {
		this.rpModel = rpModel;
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
}
