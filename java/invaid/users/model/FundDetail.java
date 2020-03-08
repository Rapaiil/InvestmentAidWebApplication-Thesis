package invaid.users.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="fund")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({FundDetails.class})
@XmlType(propOrder= {"fundNumber", "bankName", "fundName", "fundClassification", "navpu", "roiyoy",
		"roiytd", "riskClassification", "minInitParticipation", "minAddParticipation",
		"minMaintainParticipation", "minHoldingDays", "cutOffTime", "settlementDate",
		"trustFee", "exitFee", "benchmark"})
public class FundDetail {
	private int fundNumber;
	private String bankName;
	private String fundName;
	private String fundClassification;
	private String navpu;
	private String roiyoy;
	private String roiytd;
	private String riskClassification;
	private double minInitParticipation;
	private double minAddParticipation;
	private double minMaintainParticipation;
	private String minHoldingDays;
	private String cutOffTime;
	private String settlementDate;
	private String trustFee;
	private String exitFee;
	private String benchmark;
	
	public int getFundNumber() {
		return fundNumber;
	}
	
	public void setFundNumber(int fundNumber) {
		this.fundNumber = fundNumber;
	}
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getRiskClassification() {
		return riskClassification;
	}

	public void setRiskClassification(String riskClassification) {
		this.riskClassification = riskClassification;
	}

	public double getMinInitParticipation() {
		return minInitParticipation;
	}

	public void setMinInitParticipation(double minInitParticipation) {
		this.minInitParticipation = minInitParticipation;
	}

	public double getMinAddParticipation() {
		return minAddParticipation;
	}

	public void setMinAddParticipation(double minAddParticipation) {
		this.minAddParticipation = minAddParticipation;
	}

	public double getMinMaintainParticipation() {
		return minMaintainParticipation;
	}

	public void setMinMaintainParticipation(double minMaintainParticipation) {
		this.minMaintainParticipation = minMaintainParticipation;
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
	
}
