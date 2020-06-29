package invaid.users.action;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
import invaid.users.model.FundGainLossModel;
import invaid.users.model.PortfolioModel;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class PortfolioAction extends ActionSupport implements SessionAware, DBCommands{
	private double totalportfoliovalue = 0.0;
	private Map<String, Object> sessionMap;
	private PortfolioModel portfolioData = null;
	private List<FundGainLossModel> mfList = null, uitfList = null;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		DecimalFormat dfMon = new DecimalFormat("#.####"), dfPct = new DecimalFormat("#.##");
		dfMon.setRoundingMode(RoundingMode.CEILING);
		dfPct.setRoundingMode(RoundingMode.CEILING);
		
		portfolioData = new PortfolioModel();
		
		List<Object[]> mList = getMfRecords();
		double mogl = 0, moglp = 0;
		
		if(mList != null) {
			mfList = new ArrayList<FundGainLossModel>();
			FundGainLossModel fglm;
			
			for(Object[] record: mList) {
				fglm = new FundGainLossModel();
				fglm.setFundId(record[0].toString());
				fglm.setFundName(record[1].toString());
				fglm.setFundClassification(record[2].toString());
				fglm.setFundAmount(Double.parseDouble(record[3].toString()));
				fglm.setFundNav(Double.parseDouble(record[5].toString()));
				fglm.setFundShares(Double.parseDouble(record[4].toString()));
				fglm.setFundMarketPrice(Double.parseDouble(dfMon.format(fglm.getFundShares() * fglm.getFundNav())));
				
				fglm.setGainLossValue(dfMon.format(fglm.getFundMarketPrice() - fglm.getFundAmount()));
				fglm.setGainLossPctValue(dfPct.format(((fglm.getFundMarketPrice() / fglm.getFundAmount()) - 1) * 100.00));
				
				mfList.add(fglm);
				totalportfoliovalue += Double.parseDouble(dfMon.format(fglm.getFundMarketPrice()));
			}
			
			for(FundGainLossModel f: mfList) {
				mogl += Double.parseDouble(f.getGainLossValue());
				moglp += Double.parseDouble(f.getGainLossPctValue());
			}
		}
		
		List<Object[]> uList = getUitfRecords();
		double uogl = 0, uoglp = 0;
		
		if(uList != null) {
			uitfList = new ArrayList<FundGainLossModel>();
			FundGainLossModel fglm;
			
			for(Object[] record: uList) {
				fglm = new FundGainLossModel();
				fglm.setFundId(record[0].toString());
				fglm.setFundName(record[1].toString());
				fglm.setFundClassification(record[2].toString());
				fglm.setFundAmount(Double.parseDouble(record[3].toString()));
				fglm.setFundNav(Double.parseDouble(record[5].toString()));
				fglm.setFundShares(Double.parseDouble(record[4].toString()));
				fglm.setFundMarketPrice(Double.parseDouble(dfMon.format(fglm.getFundShares() * fglm.getFundNav())));
				
				fglm.setGainLossValue(dfMon.format(fglm.getFundMarketPrice() - fglm.getFundAmount()));
				fglm.setGainLossPctValue(dfPct.format(((fglm.getFundMarketPrice() / fglm.getFundAmount()) - 1) * 100.00));
				
				uitfList.add(fglm);
				totalportfoliovalue += Double.parseDouble(dfMon.format(fglm.getFundMarketPrice()));
			}
			
			for(FundGainLossModel f: uitfList) {
				uogl += Double.parseDouble(f.getGainLossValue());
				uoglp += Double.parseDouble(f.getGainLossPctValue());
			}
			
			
		}
		
		portfolioData.setOverallGainLoss(dfMon.format(mogl + uogl));
		portfolioData.setOverallGainLossPct(dfPct.format(moglp + uoglp));
			
		session.getTransaction().commit();
		return SUCCESS;
	}
	
	public PortfolioModel getPortfolioData() {
		return portfolioData;
	}

	public void setPortfolioData(PortfolioModel portfolioData) {
		this.portfolioData = portfolioData;
	}

	public List<FundGainLossModel> getMfList() {
		return mfList;
	}

	public List<FundGainLossModel> getUitfList() {
		return uitfList;
	}
	
	public double getTotalportfoliovalue() {
		return totalportfoliovalue;
	}

	public void setTotalportfoliovalue(double totalportfoliovalue) {
		this.totalportfoliovalue = totalportfoliovalue;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	@Override
	public List<Object[]> getRecords() {
		return null;
	}
	
	public List<Object[]> getMfRecords() {
		String profileId = (String) sessionMap.get("loginId");
		String date = new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now()));
		
		try {
			Query query = session.createQuery(GET_MF_PDATA);
			query.setParameter("profid", profileId);
			query.setParameter("date", date);
			
			return query.getResultList();
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	public List<Object[]> getUitfRecords() {
		String profileId = (String) sessionMap.get("loginId");
		String date = new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now()));
		
		try {
			Query query = session.createQuery(GET_UITF_PDATA);
			query.setParameter("profid", profileId);
			query.setParameter("date", date);
			
			return query.getResultList();
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
		}
		
		return null;
	}
}
