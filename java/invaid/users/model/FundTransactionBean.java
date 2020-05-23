package invaid.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fund_transaction")
public class FundTransactionBean {
	
	@Id
	@Column(nullable=false)
	private String fund_transactionId;
	@Column(nullable=false, columnDefinition="TINYINT(1)")
	private int fund_transactionType;
	@Column(nullable=false)
	private String user_fundId;
	@Column(nullable=false)
	private String user_profileId;
	@Column(nullable=false)
	private String fund_transactionDate;
	@Column(nullable=false)
	private String fund_transactionTime;
	
	public String getFund_transactionId() {
		return fund_transactionId;
	}
	
	public void setFund_transactionId(String fund_transactionId) {
		this.fund_transactionId = fund_transactionId;
	}
	
	public int getFund_transactionType() {
		return fund_transactionType;
	}
	
	public void setFund_transactionType(int fund_transactionType) {
		this.fund_transactionType = fund_transactionType;
	}
	
	public String getUser_fundId() {
		return user_fundId;
	}
	
	public void setUser_fundId(String user_fundId) {
		this.user_fundId = user_fundId;
	}
	
	public String getUser_profileId() {
		return user_profileId;
	}
	
	public void setUser_profileId(String user_profileId) {
		this.user_profileId = user_profileId;
	}
	
	public String getFund_transactionDate() {
		return fund_transactionDate;
	}
	
	public void setFund_transactionDate(String fund_transactionDate) {
		this.fund_transactionDate = fund_transactionDate;
	}

	public String getFund_transactionTime() {
		return fund_transactionTime;
	}

	public void setFund_transactionTime(String fund_transactionTime) {
		this.fund_transactionTime = fund_transactionTime;
	}
	
	

}
