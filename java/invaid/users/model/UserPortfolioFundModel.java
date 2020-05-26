package invaid.users.model;

public class UserPortfolioFundModel {
	private String fundId;
	private String fundName;
	private String fundClassification;
	private double fundAmount;
	private double fundNav;
	private double fundNumOfUnitsShares;
	private double fundPrice;
	private String pctGainLoss;
	
	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
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
	
	public double getFundAmount() {
		return fundAmount;
	}
	
	public void setFundAmount(double fundAmount) {
		this.fundAmount = fundAmount;
	}
	
	public double getFundNav() {
		return fundNav;
	}
	
	public void setFundNav(double fundNav) {
		this.fundNav = fundNav;
	}
	
	public double getFundNumOfUnitsShares() {
		return fundNumOfUnitsShares;
	}
	
	public void setFundNumOfUnitsShares(double fundNumOfUnitsShares) {
		this.fundNumOfUnitsShares = fundNumOfUnitsShares;
	}
	
	public double getFundPrice() {
		return fundPrice;
	}
	
	public void setFundPrice(double fundPrice) {
		this.fundPrice = fundPrice;
	}
	
	public String getPctGainLoss() {
		return pctGainLoss;
	}
	
	public void setPctGainLoss(String pctGainLoss) {
		this.pctGainLoss = pctGainLoss;
	}
	
	

}
