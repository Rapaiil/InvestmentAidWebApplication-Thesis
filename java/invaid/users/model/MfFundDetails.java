package invaid.users.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mf")
@XmlAccessorType(XmlAccessType.FIELD)
public class MfFundDetails {
	@XmlElement(name="fund")
	private List<MfFundDetail> list = null;
	
	public List<MfFundDetail> getList() {
		return this.list;
	}
	
	public void setList(List<MfFundDetail> list) {
		this.list = list;
	}
}
