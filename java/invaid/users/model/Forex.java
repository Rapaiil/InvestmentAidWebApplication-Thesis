package invaid.users.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="rate")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(ForexWrapper.class)
@XmlType(propOrder={"currencyName", "currencyCode", "ratePhpFor", "rateForPhp"})
public class Forex {
	private String currencyName;
	private String currencyCode;
	private double ratePhpFor;
	private double rateForPhp;
	
	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public double getRatePhpFor() {
		return ratePhpFor;
	}
	
	public void setRatePhpFor(double ratePhpFor) {
		this.ratePhpFor = ratePhpFor;
	}
	
	public double getRateForPhp() {
		return rateForPhp;
	}
	
	public void setRateForPhp(double rateForPhp) {
		this.rateForPhp = rateForPhp;
	}
	
}
