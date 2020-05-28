package invaid.users.model;

public class FundGainLossModel {
	private String fundId;
	private String fundName;
	private String gainLossValue;
	private String gainLossPctValue;
	private String fundClassification;
	private double fundAmount;
	private double fundShares;
	private double fundMarketPrice;
	private double fundNav;
	
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
	
	public String getGainLossValue() {
		return gainLossValue;
	}
	
	public void setGainLossValue(String gainLossValue) {
		this.gainLossValue = gainLossValue;
	}
	
	public String getGainLossPctValue() {
		return gainLossPctValue;
	}
	
	public void setGainLossPctValue(String gainLossPctValue) {
		this.gainLossPctValue = gainLossPctValue;
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
	
	public double getFundMarketPrice() {
		return fundMarketPrice;
	}
	
	public void setFundMarketPrice(double fundMarketPrice) {
		this.fundMarketPrice = fundMarketPrice;
	}
	
	public double getFundNav() {
		return fundNav;
	}
	
	public void setFundNav(double fundNav) {
		this.fundNav = fundNav;
	}

	public double getFundShares() {
		return fundShares;
	}

	public void setFundShares(double fundShares) {
		this.fundShares = fundShares;
	}
	
	
}
