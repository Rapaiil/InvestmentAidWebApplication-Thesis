package invaid.users.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uitf")
@XmlAccessorType(XmlAccessType.FIELD)
public class FundDetails {
	@XmlElement(name="fund")
	private List<FundDetail> list = null;
	
	public List<FundDetail> getList() {
		return this.list;
	}
	
	public void setList(List<FundDetail> list) {
		this.list = list;
	}
}
