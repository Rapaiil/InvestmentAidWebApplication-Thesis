package invaid.users.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.MfFundDetail;
import invaid.users.model.UitfFundDetail;
import invaid.users.model.UserFundBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings({"serial"})
public class AddFundAction extends ActionSupport implements ModelDriven<UserFundBean>, SessionAware {
	private UserFundBean userFund = new UserFundBean();
	private List<UserFundBean> fundList = new ArrayList<UserFundBean>();
	Session session = HibernateUtil.getSession();
	private Map<String, Object> sessionMap;
	
	@Override
	public String execute() {
		session.getTransaction().begin();
		
		doProcess();
		
		if(userFund != null)
			session.save(userFund);
		
		return SUCCESS;
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
	
	private boolean addNewFund() {
		try {
			Query query = session.createQuery();
		} catch() {
			
		}
		return false;
	}
	
	private void doProcess() {
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
	}
}
