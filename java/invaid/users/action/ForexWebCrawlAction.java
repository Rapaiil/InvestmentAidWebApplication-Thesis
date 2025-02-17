package invaid.users.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.opensymphony.xwork2.ActionSupport;

import config.Configurations;
import invaid.users.model.Forex;
import invaid.users.model.ForexWrapper;

@SuppressWarnings("serial")
public class ForexWebCrawlAction extends ActionSupport {
	private ForexWrapper rateList = new ForexWrapper();
	private Forex rate = null;
	private List<Forex> ratestable = null;
	private String contextPath = Configurations.getForexFile();
	
	@Override
	public String execute() {
		rateList.setRateList(new ArrayList<Forex>());
		
		try {
			Document document = Jsoup.connect(Configurations.getForexSource()).get();
			Elements table = document.select(".tablesorter tbody");
			Iterator<String> listahan = table.select("td").eachText().iterator();
			
			while(listahan.hasNext()) {
				rate = new Forex();
				rate.setCurrencyName(listahan.next().toString());
				rate.setCurrencyCode(getCurrencyCode(rate.getCurrencyName()));
				rate.setRatePhpFor(Double.valueOf(listahan.next()));
				rate.setRateForPhp(Double.valueOf(listahan.next()));
				
				rateList.getRateList().add(rate);
			}
			
			rate = new Forex();
			rate.setCurrencyName("Philippine Peso");
			rate.setCurrencyCode(getCurrencyCode(rate.getCurrencyName()));
			rate.setRatePhpFor(1.00);
			rate.setRateForPhp(1.00);
			
			rateList.getRateList().add(rate);
			
			try {
				JAXBContext jaxb = JAXBContext.newInstance(Forex.class);
				Marshaller marshaller = jaxb.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
				marshaller.marshal(rateList, new File(contextPath));
			} catch(JAXBException jaxbe) {
				jaxbe.printStackTrace();
				return ERROR;
			}
			
			if(getRatesFromXml()) {
				setRatestable(rateList.getRateList());
				return SUCCESS;
			}
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException io) {
			io.printStackTrace();
		}
		
		return ERROR;
	}
	
	private boolean getRatesFromXml() {
		rateList = null;
		
		try {
			JAXBContext jaxb = JAXBContext.newInstance(ForexWrapper.class);
			Unmarshaller um = jaxb.createUnmarshaller();
			rateList = (ForexWrapper) um.unmarshal(new FileReader(contextPath));
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}
		
		if(rateList == null || rateList.getRateList().isEmpty())
			return false;
		
		return true;
	}
	
	private String getCurrencyCode(String currency) {
		switch(currency) {
			case "Argentine Peso": return "ARS"; 
			case "Australian Dollar": return "AUD";
			case "Bahraini Dinar": return "BHD";
			case "Botswana Pula": return "BWP";
			case "Brazilian Real": return "BRL";
			case "Bruneian Dollar": return "BND";
			case "Bulgarian Lev": return "BGN";
			case "Canadian Dollar": return "CAD";
			case "Chilean Peso": return "CLP";
			case "Chinese Yuan Renminbi": return "CNY";
			case "Colombian Peso": return "COP";
			case "Croatian Kuna": return "HRK";
			case "Czech Koruna": return "CZK";
			case "Danish Krone": return "DKK";
			case "Euro": return "EUR";
			case "Hong Kong Dollar": return "HKD";
			case "Hungarian Forint": return "HUF";
			case "Icelandic Krona": return "ISK";
			case "Indian Rupee": return "INR";
			case "Indonesian Rupiah": return "IDR";
			case "Iranian Rial": return "IRR";
			case "Israeli Shekel": return "ILS";
			case "Japanese Yen": return "JPY";
			case "Kazakhstani Tenge": return "KZT";
			case "South Korean Won": return "KRW";
			case "Kuwaiti Dinar": return "KWD";
			case "Libyan Dinar": return "LYD";
			case "Malaysian Ringgit": return "MYR";
			case "Mauritian Rupee": return "MUR";
			case "Mexican Peso": return "MXN";
			case "Nepalese Rupee": return "NPR";
			case "New Zealand Dollar": return "NZD";
			case "Norwegian Krone": return "NOK";
			case "Omani Rial": return "OMR";
			case "Pakistani Rupee": return "PKR";
			case "Polish Zloty": return "PLN";
			case "Qatari Riyal": return "QAR";
			case "Romanian New Leu": return "RON";
			case "Russian Ruble": return "RUB";
			case "Saudi Arabian Riyal": return "SAR";
			case "Singapore Dollar": return "SGD";
			case "South African Rand": return "ZAR";
			case "Sri Lankan Rupee": return "LKR";
			case "Swedish Krona": return "SEK";
			case "Swiss Franc": return "CHF";
			case "Taiwan New Dollar": return "TWD";
			case "Thai Baht": return "THB";
			case "Trinidadian Dollar": return "TTD";
			case "Turkish Lira": return "TRY";
			case "Emirati Dirham": return "AED";
			case "British Pound": return "GBP";
			case "US Dollar": return "USD";
			case "Venezuelan Bolivar": return "VEF";
			case "Philippine Peso": return "PHP";
			default: return null;
		}
	}
	
	public List<Forex> getRatestable() {
		return this.ratestable;
	}

	public void setRatestable(List<Forex> ratestable) {
		this.ratestable = ratestable;
	}
}
