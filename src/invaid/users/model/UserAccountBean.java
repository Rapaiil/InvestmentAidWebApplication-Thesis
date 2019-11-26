package invaid.users.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="registered_useraccounts")
public class UserAccountBean {
	@Id
	private String user_accountId;
	@Column(nullable=false)
	private String user_email;
	@Column(nullable=false)
	private String user_password;
	@Transient
	private String user_confirmpassword;
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="userId", nullable=false)
	@MapsId
	private UserProfileBean userProfile;
	@Column
	private String reset_token;

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

	public String getUser_confirmpassword() {
		return user_confirmpassword;
	}

	public void setUser_confirmpassword(String user_confirmpassword) {
		this.user_confirmpassword = user_confirmpassword;
	}

	public UserProfileBean getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileBean userProfile) {
		this.userProfile = userProfile;
	}

	public String getReset_token() {
		return reset_token;
	}

	public void setReset_token(String reset_token) {
		this.reset_token = reset_token;
	}

	public String getUser_accountId() {
		return user_accountId;
	}

	public void setUser_accountId(String user_accountId) {
		this.user_accountId = user_accountId;
	}
	
}
