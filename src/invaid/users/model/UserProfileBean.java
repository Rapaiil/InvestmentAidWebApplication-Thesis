package invaid.users.model;

import javax.persistence.*;

@Entity
@Table(name="registered_userprofiles")
public class UserProfileBean {
	
	@Id
	@Column(nullable=false)
	private String user_profileId;
	@Column(nullable=false)
	private String user_firstname;
	@Column
	private String user_middlename;
	@Column(nullable=false)
	private String user_lastname;
	@Column(nullable=false)
	private boolean user_gender;
	@Column(nullable=false)
	private String user_citizenship;
	@Column(nullable=false)
	private String user_cellphonenumber;
	@Column(nullable=false)
	private String user_telephonenumber;
	//has-a relationship
	@Column(nullable=false)
	private AddressBean user_address;
	@Column(nullable=false)
	private String user_occupation;
	@Column(nullable=false)
	private String user_company;

	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_middlename() {
		return user_middlename;
	}

	public void setUser_middlename(String user_middlename) {
		this.user_middlename = user_middlename;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public boolean getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(boolean user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_citizenship() {
		return user_citizenship;
	}

	public void setUser_citizenship(String user_citizenship) {
		this.user_citizenship = user_citizenship;
	}

	public String getUser_cellphonenumber() {
		return user_cellphonenumber;
	}

	public void setUser_cellphonenumber(String user_cellphonenumber) {
		this.user_cellphonenumber = user_cellphonenumber;
	}

	public String getUser_telephonenumber() {
		return user_telephonenumber;
	}

	public void setUser_telephonenumber(String user_telephonenumber) {
		this.user_telephonenumber = user_telephonenumber;
	}
	
	public AddressBean getUser_address() {
		return user_address;
	}

	public void setUser_address(AddressBean user_address) {
		this.user_address = user_address;
	}

	public String getUser_occupation() {
		return user_occupation;
	}

	public void setUser_occupation(String user_occupation) {
		this.user_occupation = user_occupation;
	}

	public String getUser_company() {
		return user_company;
	}

	public void setUser_company(String user_company) {
		this.user_company = user_company;
	}

	public String getUser_profileId() {
		return user_profileId;
	}

	public void setUser_profileId(String user_profileId) {
		this.user_profileId = user_profileId;
	}
	
	
	
}
