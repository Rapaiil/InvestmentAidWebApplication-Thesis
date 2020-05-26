package invaid.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uitf_details")
public class TrustFundBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long uitfDetailsId;
	@Column(nullable=false, columnDefinition="INT(3)")
	private int fundNumber;
	@Column(nullable=false)
	private String fundName;
	@Column(nullable=false)
	private String fundClassification;
	@Column(nullable=false)
	private String bankName;
	@Column(nullable=false)
	private String navpu;
	@Column(nullable=false)
	private String roiyoy;
	@Column(nullable=false)
	private String roiytd;
	@Column(nullable=false)
	private String minInitParticipation;
	@Column(nullable=false)
	private String minAddParticipation;
	@Column(nullable=false)
	private String minMainParticipation;
	@Column(nullable=false)
	private String minHoldingDays;
	@Column(nullable=false)
	private String cutOffTime;
	@Column(nullable=false)
	private String settlementDate;
	@Column(nullable=false)
	private String trustFee;
	@Column(nullable=false)
	private String exitFee;
	@Column(nullable=false)
	private String benchmark;
	@Column(nullable=false)
	private String riskClassification;
	@Column
	private String uitfCrawledDate;
	
	public Long getUitfDetailsId() {
		return uitfDetailsId;
	}

	public void setUitfDetailsId(Long uitfDetailsId) {
		this.uitfDetailsId = uitfDetailsId;
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
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String getNavpu() {
		return navpu;
	}
	
	public void setNavpu(String navpu) {
		this.navpu = navpu;
	}
	
	public String getRoiyoy() {
		return roiyoy;
	}
	
	public void setRoiyoy(String roiyoy) {
		this.roiyoy = roiyoy;
	}

	public String getRoiytd() {
		return roiytd;
	}
	
	public void setRoiytd(String roiytd) {
		this.roiytd = roiytd;
	}
	
	public String getMinInitParticipation() {
		return minInitParticipation;
	}
	
	public void setMinInitParticipation(String minInitParticipation) {
		this.minInitParticipation = minInitParticipation;
	}
	
	public String getMinAddParticipation() {
		return minAddParticipation;
	}
	
	public void setMinAddParticipation(String minAddParticipation) {
		this.minAddParticipation = minAddParticipation;
	}
	
	public String getMinMainParticipation() {
		return minMainParticipation;
	}
	
	public void setMinMainParticipation(String minMainParticipation) {
		this.minMainParticipation = minMainParticipation;
	}
	
	public String getMinHoldingDays() {
		return minHoldingDays;
	}
	
	public void setMinHoldingDays(String minHoldingDays) {
		this.minHoldingDays = minHoldingDays;
	}
	
	public String getCutOffTime() {
		return cutOffTime;
	}
	
	public void setCutOffTime(String cutOffTime) {
		this.cutOffTime = cutOffTime;
	}
	
	public String getSettlementDate() {
		return settlementDate;
	}
	
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	
	public String getTrustFee() {
		return trustFee;
	}
	
	public void setTrustFee(String trustFee) {
		this.trustFee = trustFee;
	}
	
	public String getExitFee() {
		return exitFee;
	}
	
	public void setExitFee(String exitFee) {
		this.exitFee = exitFee;
	}
	
	public String getBenchmark() {
		return benchmark;
	}
	
	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}
	
	public String getRiskClassification() {
		return riskClassification;
	}
	
	public void setRiskClassification(String riskClassification) {
		this.riskClassification = riskClassification;
	}

	public String getUitfCrawledDate() {
		return uitfCrawledDate;
	}

	public void setUitfCrawledDate(String uitfCrawledDate) {
		this.uitfCrawledDate = uitfCrawledDate;
	}
	
	
}
