package invaid.users.model;

public class LoginAccountModel {
	private String login_email;
	private String login_password;
	private int login_otp;
	
	public String getLogin_email() {
		return login_email;
	}
	
	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}
	
	public String getLogin_password() {
		return login_password;
	}
	
	public void setLogin_password(String login_password) {
		this.login_password = login_password;
	}

	public int getLogin_otp() {
		return login_otp;
	}

	public void setLogin_otp(int login_otp) {
		this.login_otp = login_otp;
	}

}
