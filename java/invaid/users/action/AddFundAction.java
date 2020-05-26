package invaid.users.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.FundTransactionBean;
import invaid.users.model.UserFundBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial"})
public class AddFundAction extends ActionSupport implements ModelDriven<UserFundBean>, SessionAware {
	private UserFundBean userFund = new UserFundBean();
	private FundTransactionBean fundtrans;
	private List<UserFundBean> fundList = new ArrayList<UserFundBean>();
	Session session = HibernateUtil.getSession();
	private Map<String, Object> sessionMap;
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		fundtrans = new FundTransactionBean();
		
		try {
			String profileId = (String) sessionMap.get("loginId"),
			       fundType = userFund.getUser_fundType() == 0 ? "MF" : "UF",
				   fundId = (String.valueOf(userFund.getFundNumber()).length() == 1) ? "00".concat(String.valueOf(userFund.getFundNumber())) : (String.valueOf(userFund.getFundNumber()).length() == 2) ? "0".concat(String.valueOf(userFund.getFundNumber())) : (String.valueOf(userFund.getFundNumber()).length() == 3) ? String.valueOf(userFund.getFundNumber()) : null;
			
			userFund.setUser_profileId(profileId);			
			userFund.setUser_fundId(fundType+(profileId.substring(profileId.length()-5))+fundId);
			userFund.setUser_fundDatePurchased(LocalDate.parse(userFund.getUser_fundDatePurchased(), DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			
			userFund.convertUnitsShares();
			userFund.convertFundAmount();
			userFund.convertFundType();
			
			session.save(userFund);
			addFundTransaction();
			
			session.getTransaction().commit();
			return SUCCESS;
		} catch(HibernateException he) {
			System.err.println("Cannot save fund!");	
		} catch(UnsupportedEncodingException uee) {
			System.err.println(uee.getMessage());
		}
		
		session.getTransaction().rollback();
		return ERROR;
	}
	
	@Override
	public UserFundBean getModel() {
		return userFund;
	}
	
	public List<UserFundBean> getFundList() {
		return this.fundList;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	private void addFundTransaction() throws UnsupportedEncodingException {
		String profileId = (String) sessionMap.get("loginId");
		
		fundtrans.setFund_transactionId(getTransactionId());
		fundtrans.setUser_fundId(userFund.getUser_fundId());
		fundtrans.setUser_profileId(profileId);
		fundtrans.setFund_transactionType(getTransactionType());
		fundtrans.setFund_transactionDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		fundtrans.setFund_transactionTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
		
		session.save(fundtrans);
	}
	
	private int getTransactionType() {
		return 1;
	}
	
	private String getTransactionId() throws UnsupportedEncodingException {
		String id = String.valueOf(System.currentTimeMillis());
		return UUID.nameUUIDFromBytes(id.getBytes("UTF-8")).toString();
	}
}
