package invaid.users.model;

import javax.persistence.Embeddable;

@Embeddable
public class AddressBean {
	private String user_street;
	private String user_apt;
	private String user_city;
	private String user_state;
	private int user_zip;
	
	public AddressBean() {}
	
	public AddressBean(String user_street, String user_apt, String user_city, String user_state, int user_zip) {
		this.user_street = user_street;
		this.user_apt = user_apt;
		this.user_city = user_city;
		this.user_state = user_state;
		this.user_zip = user_zip;
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
