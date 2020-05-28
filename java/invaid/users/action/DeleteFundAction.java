package invaid.users.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.db.DBCommands;
import invaid.users.model.FundTransactionBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class DeleteFundAction extends ActionSupport implements SessionAware, DBCommands {
	private Map<String, Object> sessionMap;
	private FundTransactionBean fundtrans;
	private String fundId;
	Session session = HibernateUtil.getSession();
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		fundtrans = new FundTransactionBean();
		List<Object[]> list = getRecords();
		
		try {
			if(list != null) {
				for(Object record: list) {
					if(record.toString().equals(fundId)) {
						deleteFund(fundId);
						addFundTransaction(fundId);
						
						session.getTransaction().commit();
						return SUCCESS;
					}
				}
			}
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
		} catch(UnsupportedEncodingException uee) {
			System.err.println(uee.getMessage());
		}
		
		session.getTransaction().rollback();
		return ERROR;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	@Override
	public List<Object[]> getRecords() {
		String profileId = (String) sessionMap.get("loginId");
		
		try {
			Query query = session.createQuery(GET_USERFUND);
			query.setParameter("profid", profileId);
			
			return query.getResultList();
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
			session.getTransaction().rollback();
		}
		
		return null;
	}
	
	private void deleteFund(String fundId) throws HibernateException {
		Query query = session.createQuery(DELETE_USERFUND);
		query.setParameter("fundid", fundId);
		
		if(query.executeUpdate() < 1)
			throw new HibernateException("Error! Fund was not deleted.");
	}
	
	private void addFundTransaction(String fundId) throws UnsupportedEncodingException {
		String profileId = (String) sessionMap.get("loginId");
		
		fundtrans.setFund_transactionId(getTransactionId());
		fundtrans.setUser_fundId(fundId);
		fundtrans.setUser_profileId(profileId);
		fundtrans.setFund_transactionType(getTransactionType());
		fundtrans.setFund_transactionDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		fundtrans.setFund_transactionTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		
		session.save(fundtrans);
	}
	
	private int getTransactionType() {
		return 3;
	}
	
	private String getTransactionId() throws UnsupportedEncodingException {
		String id = String.valueOf(System.currentTimeMillis());
		return UUID.nameUUIDFromBytes(id.getBytes("UTF-8")).toString();
	}
}
