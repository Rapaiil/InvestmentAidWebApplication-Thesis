package invaid.users.action;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import config.Configurations;
import invaid.users.model.UitfFundDetail;
import invaid.users.model.UitfFundDetails;

@SuppressWarnings("serial")
public class UITFXMLParseAction extends ActionSupport implements ModelDriven<UitfFundDetail> {
	private UitfFundDetails fundWrapper = new UitfFundDetails();
	private UitfFundDetail fund = new UitfFundDetail();
	private List<UitfFundDetail> fundList = null;
	
	@Override
	public String execute() {
		String contextPath = ServletActionContext.getServletContext().getRealPath(Configurations.getUitfFile());
		try {
			JAXBContext jaxb = JAXBContext.newInstance(UitfFundDetails.class);
			Unmarshaller um = jaxb.createUnmarshaller();
			fundWrapper = (UitfFundDetails) um.unmarshal(new FileReader(contextPath));
			if(fundWrapper == null || fundWrapper.getList().isEmpty())
				return ERROR;
			fundList = fundWrapper.getList();
			if(fundList != null && !fundList.isEmpty())
				return SUCCESS;
		} catch(JAXBException jaxbe) {
			jaxbe.getMessage();
		} catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
		}
		
		return ERROR;
	}
	
	@Override
	public UitfFundDetail getModel() {
		return fund;
	}

	public List<UitfFundDetail> getFundList() {
		return fundList;
	}

	public void setFundList(List<UitfFundDetail> list) {
		this.fundList = list;
	}

}
