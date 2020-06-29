package invaid.users.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.AddressBean;
import invaid.users.model.UserProfileBean;
import invaid.users.util.IdGeneratorUtil;
import invaid.users.util.AESEncryption;

@SuppressWarnings({"serial"})
public class RegisterProfileAction extends ActionSupport implements ModelDriven<UserProfileBean>, SessionAware, Runnable {
	private UserProfileBean userProfile = new UserProfileBean();
	private AddressBean userAddress;
	private String user_street, user_apt, user_city, user_state, user_zip;
	private Map<String, Object> sessionMap;

	public String execute() {
		try {
			userProfile.setUser_profileId(IdGeneratorUtil.generateId(userProfile.getUser_firstname(), userProfile.getUser_lastname()));
			userAddress = new AddressBean(AESEncryption.encrypt(user_street), AESEncryption.encrypt(user_apt), AESEncryption.encrypt(user_city), AESEncryption.encrypt(user_state), AESEncryption.encrypt(user_zip));
			
			userProfile.setUser_address(userAddress);
			
			userProfile.setUser_firstname(AESEncryption.encrypt(userProfile.getUser_firstname()));
			userProfile.setUser_lastname(AESEncryption.encrypt(userProfile.getUser_lastname()));
			userProfile.setUser_company(AESEncryption.encrypt(userProfile.getUser_company()));
			userProfile.setUser_occupation(AESEncryption.encrypt(userProfile.getUser_occupation()));
			
			int cnLength = userProfile.getUser_cellphonenumber().length(), tnLength = userProfile.getUser_telephonenumber().length();
			if(cnLength > 10)
				userProfile.setUser_cellphonenumber(userProfile.getUser_cellphonenumber().substring(cnLength-10, cnLength));
			if(tnLength > 8)
				userProfile.setUser_telephonenumber(userProfile.getUser_telephonenumber().substring(tnLength-8, tnLength));

			userProfile.genderConvert();
		} catch(Exception e) {
			 e.getMessage();
			 return ERROR;
		}
		
		sessionMap.put("sessionUser", userProfile);
		return SUCCESS;
	}
	
	public void validate() {
		boolean fnValid = ValidateEmpty(userProfile.getUser_firstname());
		boolean lnValid = ValidateEmpty(userProfile.getUser_lastname());
		boolean strtValid = ValidateEmpty(getUser_street());
		boolean cityValid = ValidateEmpty(getUser_city());
		boolean stateValid = ValidateEmpty(getUser_state());
		boolean zipValid = ValidateEmpty(getUser_zip());
		boolean cnValid = ValidateEmpty(userProfile.getUser_cellphonenumber());
		boolean tnValid = ValidateEmpty(userProfile.getUser_telephonenumber());
		boolean occValid = ValidateEmpty(userProfile.getUser_occupation());
		boolean cmpValid = ValidateEmpty(userProfile.getUser_company());
		
		//First Name
		if(!fnValid) {
			addFieldError("lfntf", "This field is required");
		}
		else {
			fnValid = ValidateName(userProfile.getUser_firstname());
			if(!fnValid) {
				addFieldError("lfntf", "Please enter a valid name");
			}
		}
		
		//Last Name
		if(!lnValid){
			addFieldError("llntf", "This field is required");
		}
		else {
			lnValid = ValidateName(userProfile.getUser_lastname());
			if(!lnValid) {
				addFieldError("llntf", "Please enter a valid name");
			}
		}
		
		//Street
		if(!strtValid) {
			addFieldError("lstrttf", "This field is required");
		}
		
		//City
		if(!cityValid) {
			addFieldError("lcitytf", "This field is required");
		}
		
		//State
		if(!stateValid) {
			addFieldError("lstatetf", "This field is required");
		}
		
		//Zip
		if(!zipValid) {
			addFieldError("user_zip", "This field is required");
		}
		else {
			zipValid = ValidateZip(getUser_zip());
			if(!zipValid) {
				addFieldError("user_zip", "Please enter a valid zip/postal code");
			}
		}
		
		
		//Telephone Number
		if(!tnValid){
			addFieldError("ltntf", "This field is required");
		}
		else {
			tnValid = ValidateTel(userProfile.getUser_telephonenumber());
			if(!tnValid) {
				addFieldError("ltntf", "Please enter a valid telephone no");
			}
		}
		
		//Cellphone Number
		if(!cnValid){
			addFieldError("lcntf", "This field is required");
		}
		else {
			cnValid = ValidateCell(userProfile.getUser_cellphonenumber());
			if(!cnValid) {
				addFieldError("lcntf", "Please enter a valid cellphone no");
			}
		}
		
		//Occupation
		if(!occValid){
			addFieldError("locctf", "This field is required");
		}
		
		//Company
		if(!cmpValid){
			addFieldError("lcomtf", "This field is required");
		}
	}
	
	@Override
	public void run() {
		//
	}
	
	//Functions
	private boolean ValidateEmpty(String string) {
		if(string.trim() != "" || string.trim() != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean ValidateName(String string) {
		String nameRegex = "^[A-Za-z_-_ ]*$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(string.trim());
		if (nameMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean ValidateTel(String string) {
		string = string.replaceAll("\\s+","");
		String telRegex = "^(\\d{2})(\\d{8})$";
		Pattern telPattern = Pattern.compile(telRegex);
		Matcher telMatcher = telPattern.matcher(string.trim());
		String telRegex2 = "^(\\d{8})$";
		Pattern telPattern2 = Pattern.compile(telRegex2);
		Matcher telMatcher2 = telPattern2.matcher(string.trim());
		if (telMatcher.matches() || telMatcher2.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean ValidateCell(String string) {
		string = string.replaceAll("\\s+","");
		String cellRegex = "^(09|\\+639|639)\\d{9}$";
		Pattern cellPattern = Pattern.compile(cellRegex);
		Matcher cellMatcher = cellPattern.matcher(string.trim());
		if (cellMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	private boolean ValidateZip(String string) {
		int length = string.trim().length();
		String zipRegex = "^[0-9]+$";
		Pattern zipPattern = Pattern.compile(zipRegex);
		Matcher zipMatcher = zipPattern.matcher(string.trim());
		if(string.trim().contentEquals("0")) {
			return true;
		}
		if(zipMatcher.matches()) {
			if(length == 3 || length == 4) {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	//Getters and Setters
	@Override
	public UserProfileBean getModel() {
		// TODO Auto-generated method stub
		return userProfile;
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

	public String getUser_zip() {
		return user_zip;
	}

	public void setUser_zip(String user_zip) {
		this.user_zip = user_zip;
	}	
	
}
