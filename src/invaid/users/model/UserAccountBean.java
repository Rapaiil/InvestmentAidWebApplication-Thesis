package invaid.users.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="registered_accounts")
public class UserAccountBean {
	@Id
	@Column
	private String user_email;
	@Column(nullable=false)
	private String user_password;
	@Transient
	private String user_confirmpassword;
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id", nullable=false)
	private UserProfileBean userProfile;

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
	
}
