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
import invaid.users.model.UitfFundDetail;
import invaid.users.model.UitfFundDetails;

@SuppressWarnings("serial")
public class UITFXMLParseAction extends ActionSupport  {
	private UitfFundDetails fundWrapper = new UitfFundDetails();
	private List<UitfFundDetail> fundList = new ArrayList<UitfFundDetail>();
	private String contextPath = Configurations.getUitfFile();
	
	@Override
	public String execute() {
		try {
			JAXBContext jaxb = JAXBContext.newInstance(UitfFundDetails.class);
			Unmarshaller um = jaxb.createUnmarshaller();
			fundWrapper = (UitfFundDetails) um.unmarshal(new FileReader(contextPath));
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

	public List<UitfFundDetail> getFundList() {
		return fundList;
	}
}
