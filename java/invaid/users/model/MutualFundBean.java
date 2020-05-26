package invaid.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mf_details")
public class MutualFundBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long mfDetailsId;
	@Column(nullable=false, columnDefinition="INT(3)")
	private int fundNumber;
	@Column(nullable=false)
	private String fundName;
	@Column(nullable=false)
	private String fundClassification;
	@Column(nullable=false)
	private String companyName;
	@Column(nullable=false)
	private double navps;
	@Column(nullable=false)
	private String returnY1;
	@Column(nullable=false)
	private String returnY3;
	@Column(nullable=false)
	private String returnY5;
	@Column(nullable=false)
	private String returnYtd;
	@Column(nullable=false)
	private String riskClassification;
	@Column(nullable=false)
	private String mfCrawledDate;

	public Long getMfDetailsId() {
		return mfDetailsId;
	}

	public void setMfDetailsId(Long mfDetailsId) {
		this.mfDetailsId = mfDetailsId;
	}
	
	public int getFundNumber() {
		return fundNumber;
	}
	
	public void setFundNumber(int fundNumber) {
		this.fundNumber = fundNumber;
	}
	
	public String getFundName() {
		return fundName;
	}
	
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	
	public String getFundClassification() {
		return fundClassification;
	}
	
	public void setFundClassification(String fundClassification) {
		this.fundClassification = fundClassification;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public double getNavps() {
		return navps;
	}
	
	public void setNavps(double navps) {
		this.navps = navps;
	}
	
	public String getReturnY1() {
		return returnY1;
	}
	
	public void setReturnY1(String returnY1) {
		this.returnY1 = returnY1;
	}
	
	public String getReturnY3() {
		return returnY3;
	}
	
	public void setReturnY3(String returnY3) {
		this.returnY3 = returnY3;
	}
	
	public String getReturnY5() {
		return returnY5;
	}
	
	public void setReturnY5(String returnY5) {
		this.returnY5 = returnY5;
	}
	
	public String getReturnYtd() {
		return returnYtd;
	}
	
	public void setReturnYtd(String returnYtd) {
		this.returnYtd = returnYtd;
	}
	
	public String getRiskClassification() {
		return riskClassification;
	}
	
	public void setRiskClassification(String riskClassification) {
		this.riskClassification = riskClassification;
	}

	public String getMfCrawledDate() {
		return mfCrawledDate;
	}

	public void setMfCrawledDate(String mfCrawledDate) {
		this.mfCrawledDate = mfCrawledDate;
	}
	
}
