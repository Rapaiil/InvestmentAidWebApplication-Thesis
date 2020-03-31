package invaid.users.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="fund")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(MfFundDetails.class)
@XmlType(propOrder={"fundNumber", "fundName", "fundClassification", "companyName", "navps", "returnY1",
					"returnY3", "returnY5", "returnYtd", "riskClassification"})
public class MfFundDetail {
	private int fundNumber;
	private String fundName;
	private String fundClassification;
	private String companyName;
	private double navps;
	private String returnY1;
	private String returnY3;
	private String returnY5;
	private String returnYtd;
	private String riskClassification;
	
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
}
