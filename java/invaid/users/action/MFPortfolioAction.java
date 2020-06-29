package invaid.users.action;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
		DecimalFormat dfMon = new DecimalFormat("#.####"), dfPct = new DecimalFormat("#.##");
		dfMon.setRoundingMode(RoundingMode.CEILING);
		dfPct.setRoundingMode(RoundingMode.CEILING);
		
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
					fund.setFundPrice(Double.parseDouble(dfMon.format(fund.getFundNumOfUnitsShares() * fund.getFundNav())));
					fund.setPctGainLoss(dfPct.format(((fund.getFundPrice()/fund.getFundAmount())-1) * 100));
					
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
		String date = new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now()));
		
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
