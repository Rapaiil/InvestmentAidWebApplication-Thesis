package invaid.users.model;

public class EditFundModel {
	private String fundNumber;
	private String user_numOfUnitsShares;
	private String user_fundHorizon;
	
	public String getFundNumber() {
		return fundNumber;
	}
	
	public void setFundNumber(String fundNumber) {
		this.fundNumber = fundNumber;
	}
	
	public String getUser_numOfUnitsShares() {
		return user_numOfUnitsShares;
	}
	
	public void setUser_numOfUnitsShares(String user_numOfUnitsShares) {
		this.user_numOfUnitsShares = user_numOfUnitsShares;
	}
	
	public String getUser_fundHorizon() {
		return user_fundHorizon;
	}
	
	public void setUser_fundHorizon(String user_fundHorizon) {
		this.user_fundHorizon = user_fundHorizon;
	}

}
