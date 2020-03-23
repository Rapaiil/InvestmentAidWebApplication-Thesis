package invaid.users.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uitf")
@XmlAccessorType(XmlAccessType.FIELD)
public class UitfFundDetails {
	@XmlElement(name="fund")
	private List<UitfFundDetail> list = null;
	
	public List<UitfFundDetail> getList() {
		return this.list;
	}
	
	public void setList(List<UitfFundDetail> list) {
		this.list = list;
	}
}
