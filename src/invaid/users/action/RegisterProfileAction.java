package invaid.users.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.AddressBean;
import invaid.users.model.UserProfileBean;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class RegisterProfileAction extends ActionSupport implements ModelDriven, SessionAware {
	private UserProfileBean userProfile = new UserProfileBean();
	private AddressBean userAddress;
	private String user_street, user_apt, user_city, user_state;
	private int user_zip;
	private Map<String, Object> sessionMap;

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userProfile;
	}
	
	public String execute() {
		userAddress = new AddressBean(user_street, user_apt, user_city, user_state, user_zip);
		userProfile.setUser_profileId(new TokenUtil().getIdentifier());
		userProfile.setUser_address(userAddress);
		userProfile.genderConvert();
		
		System.out.println(userProfile.getUser_firstname());
		System.out.println(userProfile.getUser_middlename());
		System.out.println(userProfile.getUser_lastname());
		System.out.println(userProfile.isUser_gender());
		System.out.println(userProfile.getUser_nationality());
		System.out.println(userProfile.getUser_address().getUser_street());
		System.out.println(userProfile.getUser_address().getUser_apt());
		System.out.println(userProfile.getUser_address().getUser_city());
		System.out.println(userProfile.getUser_address().getUser_state());
		System.out.println(userProfile.getUser_address().getUser_zip());
		System.out.println(userProfile.getUser_cellphonenumber());
		System.out.println(userProfile.getUser_telephonenumber());
		System.out.println(userProfile.getUser_occupation());
		System.out.println(userProfile.getUser_company());
		//validation here
		sessionMap.put("sessionUser", userProfile);
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}

	public String getUser_street() {
		return user_street;
	}

	public void setUser_street(String user_street) {
		this.user_street = user_street;
	}

	public String getUser_apt() {
		return user_apt;
	}

	public void setUser_apt(String user_apt) {
		this.user_apt = user_apt;
	}

	public String getUser_city() {
		return user_city;
	}

	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public int getUser_zip() {
		return user_zip;
	}

	public void setUser_zip(int user_zip) {
		this.user_zip = user_zip;
	}
	
	
}
