package invaid.users.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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
import invaid.users.model.MfFundDetail;
import invaid.users.model.UitfFundDetail;
import invaid.users.model.UserFundBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial"})
public class AddFundAction extends ActionSupport implements ModelDriven<UserFundBean>, SessionAware {
	private UserFundBean userFund = new UserFundBean();
	//private FundTransactionBean fundtrans;
	//private List<UserFundBean> fundList = new ArrayList<UserFundBean>();
	Session session = HibernateUtil.getSession();
	private Map<String, Object> sessionMap;
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		//fundtrans = new FundTransactionBean();
		
		try {
			String profileId = (String) sessionMap.get("loginId");
			String fundType = "", fundId = "";
			String formattedProfileId = profileId.substring(profileId.length()-5);
			
			userFund.convertFundAmount();
			userFund.convertFundType();
			
			if(userFund.getUser_fundType() == 0) {
				List<MfFundDetail> listahanMf;
				MFXMLParseAction parser = new MFXMLParseAction();
				
				fundType = "MF";
				
				parser.execute();
				listahanMf = parser.getFundList();
				
				for(int i=0; i<(listahanMf.size()-1); i++) {
					if(listahanMf.get(i).getFundNumber() == Integer.parseInt(userFund.getFundName())) {
						userFund.setUser_fundName(listahanMf.get(i).getFundName());
						fundId = ((userFund.getFundName().length()) == 1) ? "00".concat(userFund.getFundName()) : ((userFund.getFundName().length()) == 2) ? "0".concat(userFund.getFundName()) : ((userFund.getFundName().length()) == 3) ? userFund.getFundName() : null;
						break;
					}
				}
			} else {
				List<UitfFundDetail> listahanUitf;
				UITFXMLParseAction parser = new UITFXMLParseAction();
				
				fundType = "UF";
				
				parser.execute();
				listahanUitf = parser.getFundList();
				
				for(int i=0; i<(listahanUitf.size()-1); i++) {
					if(listahanUitf.get(i).getFundNumber() == Integer.parseInt(userFund.getFundName())) {
						userFund.setUser_fundName(listahanUitf.get(i).getFundName());
						fundId = ((userFund.getFundName().length()) == 1) ? "00".concat(userFund.getFundName()) : ((userFund.getFundName().length()) == 2) ? "0".concat(userFund.getFundName()) : ((userFund.getFundName().length()) == 3) ? userFund.getFundName() : null;
						break;
					}
				}
			}
			
			userFund.setUser_fundId(fundType+formattedProfileId+fundId);
			
			session.save(userFund);
			//addFundTransaction();
			
			session.getTransaction().commit();
			return SUCCESS;
		} catch(HibernateException he) {
			System.err.println("Cannot save fund!");
			session.getTransaction().rollback();
		}
		return ERROR;
	}
	
	@Override
	public UserFundBean getModel() {
		return userFund;
	}
	
//	public List<UserFundBean> getFundList() {
//		return this.fundList;
//	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
//	private void addFundTransaction() {
//		String profileId = (String) sessionMap.get("loginId");
//		
//		try {
//			fundtrans.setFund_transactionId(getTransactionId());
//			fundtrans.setUser_fundId(userFund.getUser_fundId());
//			fundtrans.setUser_profileId(profileId);
//			fundtrans.setFund_transactionType(getTransactionType());
//			fundtrans.setFund_transactionDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
//			fundtrans.setFund_transactionTime(new SimpleDateFormat("HH:mm:ss").format(new Date()));
//			
//			session.save(fundtrans);
//		} catch(UnsupportedEncodingException uee) {
//			System.err.println(uee.getMessage());
//		}
//	}
	
	private void doProcess() {
		
	}
	
	private int getTransactionType() {
		return 1;
	}
	
	private String getTransactionId() throws UnsupportedEncodingException {
		String id = String.valueOf(System.currentTimeMillis());
		return UUID.nameUUIDFromBytes(id.getBytes("UTF-8")).toString();
	}
}
