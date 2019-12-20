package invaid.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="registered_useraccounts")
public class UserAccountBean {
	@Id
	@Column(nullable=false)
	private String user_email;
	@Column(nullable=false)
	private String user_password;
	@Transient
	private String user_repassword;
	@Column(nullable=false)
	private String user_profileId;
	@Column
	private String user_token;
	
	/*
	 * To be read as a tuple
	 * (x,y)
	 * 
	 * x - defines the account if verified (1) or not verified (0)
	 * y - defines if the user is currently finishing an event/function (1) i.e. resetting password event
	 * 		else, neutral state (0)
	 */
	@Column(columnDefinition="TINYINT(2) ZEROFILL")
	private int user_status;

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

	public String getUser_repassword() {
		return user_repassword;
	}

	public void setUser_repassword(String user_confirmpassword) {
		this.user_repassword = user_confirmpassword;
	}

	public String getUser_profileId() {
		return user_profileId;
	}

	public void setUser_profileId(String user_profileId) {
		this.user_profileId = user_profileId;
	}

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	
	
}
