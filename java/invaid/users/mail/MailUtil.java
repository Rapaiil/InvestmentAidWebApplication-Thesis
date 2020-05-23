package invaid.users.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;

public abstract class MailUtil implements Cloneable {
	private String mailType;
	protected Properties properties;
	protected Authenticator auth;
	
	/*
	 * returns the Session mail
	 */
	abstract public Session getSession();
	
	/*
	 * configures properties for mail sending
	 */
	protected Properties getProperties() {
		return properties;
	}
	
	/*
	 * creates Authenticator object
	 */
	protected Authenticator getAuth() {
		return auth;
	}
	
	/*
	 * identifies the mail type returned
	 */
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	public String getMailType() {
		return mailType;
	}
	
	@Override
	public Object clone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		} catch(CloneNotSupportedException cnse) {
			System.err.println(cnse.getMessage());
		}
		return clone;
	}

}
