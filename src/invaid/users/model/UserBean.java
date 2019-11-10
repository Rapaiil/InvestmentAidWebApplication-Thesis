package invaid.users.model;

import javax.persistence.*;

@Entity
@Table(name="registered_users")
public class UserBean {
	
	@Id
	@Column
	private String user_email;
	@Column
	private String user_firstname;
	@Column
	private String user_middlename;
	@Column
	private String user_lastname;
	@Column
	private String user_gender;
	@Column
	private String user_citizenship;
	@Column
	private String user_cellphonenumber;
	@Column
	private String user_telephonenumber;
	@Column
	private String user_primaryaddress;
	@Column
	private String user_permanentaddress;
	@Column
	private int user_postalcode;
	@Column
	private String user_occupation;
	@Column
	private String user_company;
	@Column
	private String user_password;
	
	public UserBean() {}
	
	public UserBean(String user_firstname,
					String user_middlename,
					String user_lastname,
					String user_gender,
					String user_citizenship,
					String user_cellphonenumber,
					String user_telephonenumber,
					String user_primaryaddress,
					String user_permanentaddress,
					int user_postalcode,
					String user_occupation,
					String user_company) {
		this.user_firstname = user_firstname;
		this.user_middlename = user_middlename;
		this.user_lastname = user_lastname;
		this.user_gender = user_gender;
		this.user_citizenship = user_citizenship;
		this.user_cellphonenumber = user_cellphonenumber;
		this.user_telephonenumber = user_telephonenumber;
		this.user_primaryaddress = user_primaryaddress;
		this.user_permanentaddress = user_permanentaddress;
		this.user_postalcode = user_postalcode;
		this.user_occupation = user_occupation;
		this.user_company = user_company;
	}
	
	public UserBean(String user_email, String user_password) {
		this.user_email = user_email;
		this.user_password = user_password;
	}

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

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
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

	public String getUser_primaryaddress() {
		return user_primaryaddress;
	}

	public void setUser_primaryaddress(String user_primaryaddress) {
		this.user_primaryaddress = user_primaryaddress;
	}

	public String getUser_permanentaddress() {
		return user_permanentaddress;
	}

	public void setUser_permanentaddress(String user_permanentaddress) {
		this.user_permanentaddress = user_permanentaddress;
	}

	public int getUser_postalcode() {
		return user_postalcode;
	}

	public void setUser_postalcode(int user_postalcode) {
		this.user_postalcode = user_postalcode;
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

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
}
