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
import invaid.users.model.MfFundDetail;
import invaid.users.model.MfFundDetails;

@SuppressWarnings("serial")
public class MFXMLParseAction extends ActionSupport implements ModelDriven<MfFundDetail> {
	private MfFundDetails fundWrapper = new MfFundDetails();
	private MfFundDetail fund = new MfFundDetail();
	private List<MfFundDetail> fundList = null;
	
	@Override
	public String execute() {
		String contextPath = ServletActionContext.getServletContext().getRealPath(Configurations.getMfFile().replaceAll("^\"|\"$", ""));
		try {
			JAXBContext jaxb = JAXBContext.newInstance(MfFundDetails.class);
			Unmarshaller um = jaxb.createUnmarshaller();
			fundWrapper = (MfFundDetails) um.unmarshal(new FileReader(contextPath));
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
	public MfFundDetail getModel() {
		return fund;
	}

	public List<MfFundDetail> getFundList() {
		return fundList;
	}

	public void setFundList(List<MfFundDetail> list) {
		this.fundList = list;
	}

}
