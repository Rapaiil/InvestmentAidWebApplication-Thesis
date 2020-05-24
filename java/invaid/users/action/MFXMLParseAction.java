package invaid.users.action;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.opensymphony.xwork2.ActionSupport;

import config.Configurations;
import invaid.users.model.MfFundDetail;
import invaid.users.model.MfFundDetails;

@SuppressWarnings("serial")
public class MFXMLParseAction extends ActionSupport {
	private MfFundDetails fundWrapper = new MfFundDetails();
	private List<MfFundDetail> fundList = new ArrayList<MfFundDetail>();
	private String contextPath = Configurations.getMfFile();
	
	@Override
	public String execute() {
		try {
			JAXBContext jaxb = JAXBContext.newInstance(MfFundDetails.class);
			Unmarshaller um = jaxb.createUnmarshaller();
			fundWrapper = (MfFundDetails) um.unmarshal(new FileReader(contextPath));
			if(fundWrapper == null || fundWrapper.getList().isEmpty())
				throw new FileNotFoundException("List is empty!");
			fundList = fundWrapper.getList();
			if(fundList == null || fundList.isEmpty())
				throw new FileNotFoundException("List is empty!");
			
			return SUCCESS;
		} catch(JAXBException jaxbe) {
			jaxbe.getMessage();
		} catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
		}
		
		return ERROR;
	}
	
	public List<MfFundDetail> getFundList() {
		return this.fundList;
	}

}
