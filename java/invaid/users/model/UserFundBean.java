package invaid.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user_funddetails")
public class UserFundBean {
	
	@Id
	@Column(nullable=false)
	private String user_fundId;
	@Column(nullable=false)
	private String user_profileId;
	@Column(nullable=false)
	private String user_fundName;
	@Column(nullable=false, columnDefinition="TINYINT(1) ZEROFILL")
	private int user_fundType;
	@Column(nullable=false)
	private int user_numOfUnitsShares;
	@Column(nullable=false, columnDefinition="TINYINT(1)")
	private int user_fundHorizon;
	@Column(nullable=false)
	private String user_fundDatePurchased;
	@Column(nullable=false, columnDefinition="DECIMAL(20,2)")
	private double user_fundInitAmount;
	@Transient
	private String fundInitAmount;
	@Transient
	private String fundType;
	@Transient
	private String fundName;
	
	
	public String getUser_fundId() {
		return user_fundId;
	}
	
	public void setUser_fundId(String user_fundId) {
		/*
		 * ID Format: MF/UF-xxxxx-xxx
		 * (fund type-profile id-fund id)
		 */
		this.user_fundId = user_fundId;
	}
	
	public String getUser_profileId() {
		return user_profileId;
	}
	
	public void setUser_profileId(String user_profileId) {
		this.user_profileId = user_profileId;
	}
	
	public String getUser_fundName() {
		return user_fundName;
	}
	
	public void setUser_fundName(String user_fundName) {
		this.user_fundName = user_fundName;
	}
	
	public int getUser_fundType() {
		return user_fundType;
	}
	
	public void setUser_fundType(int user_fundType) {
		this.user_fundType = user_fundType;
	}
	
	public int getUser_numOfUnitsShares() {
		return user_numOfUnitsShares;
	}
	
	public void setUser_numOfUnitsShares(int user_numOfUnitsShares) {
		this.user_numOfUnitsShares = user_numOfUnitsShares;
	}
	
	public int getUser_fundHorizon() {
		return user_fundHorizon;
	}
	
	public void setUser_fundHorizon(int user_fundHorizon) {
		this.user_fundHorizon = user_fundHorizon;
	}
	
	public String getUser_fundDatePurchased() {
		return user_fundDatePurchased;
	}
	
	public void setUser_fundDatePurchased(String user_fundDatePurchased) {
		this.user_fundDatePurchased = user_fundDatePurchased;
	}
	
	public double getUser_fundInitAmount() {
		return user_fundInitAmount;
	}
	
	public void setUser_fundInitAmount(double user_fundInitAmount) {
		this.user_fundInitAmount = user_fundInitAmount;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	
	public String getFundInitAmount() {
		return fundInitAmount;
	}

	public void setFundInitAmount(String fundInitAmount) {
		this.fundInitAmount = fundInitAmount;
	}
	
	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	/*
	 * 0 - mfRadioValue
	 * 1 - uitfRadioValue
	 */
	public void convertFundType() {
		if(getFundType().equals("mfRadioValue"))
			setUser_fundType(0);
		else
			setUser_fundType(1);
	}
	
	public void convertFundAmount() {
		setUser_fundInitAmount(Double.parseDouble(getFundInitAmount()));
	}
}
