package invaid.users.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="currency")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForexWrapper {
	@XmlElement(name="rate")	
	private List<Forex> rateList = null;

	public List<Forex> getRateList() {
		return rateList;
	}

	public void setRateList(List<Forex> rateList) {
		this.rateList = rateList;
	}
	
	

}
