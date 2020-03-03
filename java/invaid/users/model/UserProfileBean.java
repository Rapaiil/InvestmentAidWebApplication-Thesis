package invaid.users.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	@Transient
	private String gender;
	@Column(nullable=false, columnDefinition="TINYINT(1)")
	private boolean user_gender;
	@Column(nullable=false)
	private String user_birthday;
	@Column(nullable=false)
	private String user_nationality;
	@Column(nullable=false)
	private long user_cellphonenumber;
	@Column(nullable=false)
	private String user_telephonenumber;
	@Column(nullable=false)
	private String user_occupation;
	@Column(nullable=false)
	private String user_company;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name="user_zip", column=@Column(columnDefinition="INT(4) ZEROFILL"))
	})
	private AddressBean user_address;
	
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

	public String getUser_nationality() {
		return user_nationality;
	}

	public void setUser_nationality(String user_citizenship) {
		this.user_nationality = user_citizenship;
	}

	public long getUser_cellphonenumber() {
		return user_cellphonenumber;
	}

	public void setUser_cellphonenumber(long user_cellphonenumber) {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setUser_gender(boolean user_gender) {
		this.user_gender = user_gender;
	}

	public boolean isUser_gender() {
		return user_gender;
	}
	
	public void genderConvert() {
		if(getGender().equals("male"))
			setUser_gender(true);
		else
			setUser_gender(false);
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = new SimpleDateFormat("MM/dd/yyyy").format(user_birthday);
	}
}
