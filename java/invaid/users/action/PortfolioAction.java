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
import invaid.users.model.FundGainLossModel;
import invaid.users.model.PortfolioModel;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class PortfolioAction extends ActionSupport implements SessionAware, DBCommands{
	private int totalportfoliovalue = 0;
	private Map<String, Object> sessionMap;
	private PortfolioModel portfolioData = null;
	private List<FundGainLossModel> mfList = null, uitfList = null;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		
		List<Object[]> mList = getMfRecords();
		List<Object[]> uList = getUitfRecords();
		
		if(mList != null || uList != null) {
			portfolioData = new PortfolioModel();
			double ogl = 0;
			double oglp = 0;
			
			DecimalFormat df = new DecimalFormat("#.##");
			df.setRoundingMode(RoundingMode.CEILING);
			
			if(mList != null) {
				mfList = new ArrayList<FundGainLossModel>();
				FundGainLossModel fglm;
				
				for(Object[] record: mList) {
					fglm = new FundGainLossModel();
					fglm.setFundId(record[0].toString());
					fglm.setFundName(record[1].toString());
					fglm.setFundClassification(record[2].toString());
					fglm.setFundAmount(Double.parseDouble(record[3].toString()));
					fglm.setFundNav(Double.parseDouble(record[3].toString()));
					fglm.setFundShares(Double.parseDouble(record[4].toString()));
					fglm.setFundMarketPrice(Double.parseDouble(df.format(fglm.getFundShares() * fglm.getFundNav())));
					
					fglm.setGainLossValue(df.format(fglm.getFundMarketPrice() - fglm.getFundAmount()));
					fglm.setGainLossPctValue(df.format(((fglm.getFundMarketPrice() / fglm.getFundAmount()) - 1) * 100.00));
					
					mfList.add(fglm);
					totalportfoliovalue += fglm.getFundMarketPrice();
				}
				
				ogl = 0;
				oglp = 0;
				for(FundGainLossModel f: mfList) {
					ogl += Double.parseDouble(f.getGainLossValue());
					oglp += Double.parseDouble(f.getGainLossPctValue());
				}
				portfolioData.setOverallGainLoss(String.valueOf(ogl));
				portfolioData.setOverallGainLossPct(String.valueOf(oglp));
			}

			if(uList != null) {
				uitfList = new ArrayList<FundGainLossModel>();
				FundGainLossModel fglm;
				
				for(Object[] record: uList) {
					fglm = new FundGainLossModel();
					fglm.setFundId(record[0].toString());
					fglm.setFundName(record[1].toString());
					fglm.setFundClassification(record[2].toString());
					fglm.setFundAmount(Double.parseDouble(record[3].toString()));
					fglm.setFundNav(Double.parseDouble(record[3].toString()));
					fglm.setFundShares(Double.parseDouble(record[4].toString()));
					fglm.setFundMarketPrice(Double.parseDouble(df.format(fglm.getFundShares() * fglm.getFundNav())));
					
					fglm.setGainLossValue(df.format(fglm.getFundMarketPrice() - fglm.getFundAmount()));
					fglm.setGainLossPctValue(df.format(((fglm.getFundMarketPrice() / fglm.getFundAmount()) - 1) * 100.00));
					
					uitfList.add(fglm);
					totalportfoliovalue += fglm.getFundMarketPrice();
				}
				
				if(portfolioData.getOverallGainLoss() == null)
					ogl = 0;
				else
					ogl = Double.parseDouble(portfolioData.getOverallGainLoss());
				
				if(portfolioData.getOverallGainLossPct() == null)
					oglp = 0;
				else
					oglp = Double.parseDouble(portfolioData.getOverallGainLossPct());
				
				for(FundGainLossModel f: uitfList) {
					ogl += Double.parseDouble(f.getGainLossValue());
					oglp += Double.parseDouble(f.getGainLossPctValue());
				}
				
				portfolioData.setOverallGainLoss(String.valueOf(ogl));
				portfolioData.setOverallGainLossPct(String.valueOf(oglp));
			}
		}
		
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
	
	public int getTotalportfoliovalue() {
		return totalportfoliovalue;
	}

	public void setTotalportfoliovalue(int totalportfoliovalue) {
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
		String date = new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now().minus(1, ChronoUnit.DAYS)));
		
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
		String date = new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now().minus(1, ChronoUnit.DAYS)));
		
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
