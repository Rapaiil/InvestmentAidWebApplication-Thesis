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
		try {
			JAXBContext jaxb = JAXBContext.newInstance(MfFundDetails.class);
			Unmarshaller um = jaxb.createUnmarshaller();
			fundWrapper = (MfFundDetails) um.unmarshal(new FileReader(ServletActionContext.getServletContext().getRealPath(Configurations.getMfFile())));
			setFundList(fundWrapper.getList());
			if(getFundList().isEmpty())
				throw new FileNotFoundException("List is empty!");
			else
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
