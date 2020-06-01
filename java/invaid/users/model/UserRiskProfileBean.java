package invaid.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_riskappetite")
public class UserRiskProfileBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int riskappetiteId;
	@Column(nullable=false)
	private String user_profileId;
	@Column(nullable=false)
	private int user_riskprofile;
	
	public int getRiskappetiteId() {
		return riskappetiteId;
	}
	
	public void setRiskappetiteId(int riskappetiteId) {
		this.riskappetiteId = riskappetiteId;
	}
	
	public String getUser_profileId() {
		return user_profileId;
	}
	
	public void setUser_profileId(String user_profileId) {
		this.user_profileId = user_profileId;
	}
	
	public int getUser_riskprofile() {
		return user_riskprofile;
	}
	
	public void setUser_riskprofile(int user_riskprofile) {
		this.user_riskprofile = user_riskprofile;
	}
	
	
}
