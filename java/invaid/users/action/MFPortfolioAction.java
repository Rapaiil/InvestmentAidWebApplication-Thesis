package invaid.users.action;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.model.UserPortfolioFundModel;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class MFPortfolioAction extends ActionSupport implements SessionAware, DBCommands {
	private List<UserPortfolioFundModel> mfList = new ArrayList<UserPortfolioFundModel>();
	private Map<String, Object> sessionMap;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		UserPortfolioFundModel fund;
		
		List<Object[]> list = getRecords();
		
		try {
			if(list != null) {
				for(Object[] record: list) {
					fund = new UserPortfolioFundModel();
					
					fund.setFundId(record[0].toString());
					fund.setFundName(record[1].toString());
					fund.setFundClassification(record[2].toString());
					fund.setFundNumOfUnitsShares(Double.parseDouble(record[3].toString()));
					fund.setFundNav(Double.parseDouble(record[6].toString()));
					fund.setFundAmount(Double.parseDouble(record[5].toString()));
					fund.setFundPrice(fund.getFundNumOfUnitsShares() * fund.getFundNav());
					fund.setPctGainLoss(String.valueOf(((fund.getFundPrice()/fund.getFundAmount())-1) / 100.0));
					
					mfList.add(fund);
				}
			}
			
			session.getTransaction().commit();
			return SUCCESS;
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
		}
		
		session.getTransaction().rollback();
		return ERROR;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	@Override
	public List<Object[]> getRecords() {
		String profid = (String) sessionMap.get("loginId");
		String date = new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now().minus(1, ChronoUnit.DAYS)));
		
		try {
			Query query = session.createQuery(GET_MF_USERFUND);
			query.setParameter("profid", profid);
			query.setParameter("date", date);
			
			return query.getResultList();
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
		}
		
		return null;
	}

	public List<UserPortfolioFundModel> getMfList() {
		return mfList;
	}
		
}
