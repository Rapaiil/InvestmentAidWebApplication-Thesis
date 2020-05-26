package invaid.users.job;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import invaid.users.model.MfFundDetail;
import invaid.users.model.MfFundDetails;
import invaid.users.model.MutualFundBean;
import invaid.users.util.HibernateUtil;
import config.Configurations;

public class MFWebCrawlJob implements Job {
	MfFundDetails fundList = new MfFundDetails();
	MfFundDetail fund = null;
	private String contextPath = Configurations.getMfFile();
	Session session = HibernateUtil.getSession();
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Executing web crawl action for mutual fund...");
		fundList.setList(new ArrayList<MfFundDetail>());
		
		String BANKSOURCE_URL = Configurations.getAppBankMf();
		int count = 0;
		boolean pesoFound = false;
		boolean empty = false;
		try {
			Document document = Jsoup.connect(BANKSOURCE_URL).get();
			Elements table = document.select("#tablepress-8 tbody");
			Iterator<String> listahan = table.select("td").eachText().iterator();
			
			while(listahan.hasNext()) {
				fund = new MfFundDetail();
				
				fund.setFundName(listahan.next().toString());
				if(fund.getFundName().regionMatches(true, 0, "grepalife", 0, 9))
					empty = !empty;
				fund.setFundClassification(listahan.next().toString());
				if(listahan.next().toString().equals("PHP"))
					pesoFound = !pesoFound;
				fund.setCompanyName(listahan.next().toString());
				
				if(empty) {
					pesoFound = false;
					empty = false;
					continue;
				} else if(pesoFound) {
					fund.setFundNumber(++count);
					fundList.getList().add(fund);
					pesoFound = !pesoFound;
				}
			}
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		String FUNDSOURCE_URL = Configurations.getAppFundMf();
		count = 0;
		boolean found = false;
		try {
			Document document = Jsoup.connect(FUNDSOURCE_URL).get();
			Elements table = document.select(".icap_BodySeparator tr.icap_DataText021");
			Iterator<String> list = table.select("td").eachText().iterator();
			
			while(list.hasNext()) {
				fund = new MfFundDetail();
				fund.setFundName(list.next().toString());
				System.out.println("Fund from list: " + fund.getFundName());
				for(MfFundDetail fd: fundList.getList()) {
					if(searchMatch(fund.getFundName(), fd.getFundName())) {
						fund = fd;
						System.out.println("Fund: " + fund.getFundName());
						found = !found;
					}
				}
				
				if(!found) {
					for(int i = 0; i < 6; i++)
						list.next();
					System.err.println("Fund not found!");
					continue;
				}
				
				fund.setNavps(Double.valueOf(list.next()));
				fund.setReturnY1(list.next().toString());
				fund.setReturnY3(list.next().toString());
				fund.setReturnY5(list.next().toString());
				fund.setReturnYtd(list.next().toString());
				fund.setRiskClassification(getRiskType(fund.getFundClassification()));
				
				list.next();
				count++;
				found = !found;
			}
			
			System.out.println("- - -\nCount: " + count+ "\n- - -");
		} catch(IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		
		try {
			JAXBContext jaxb = JAXBContext.newInstance(MfFundDetail.class);
			
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(fundList, new File(contextPath));
		} catch(JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}
		
		try {
			session.getTransaction().begin();
			MutualFundBean mfb;
			
			for(MfFundDetail f: fundList.getList()) {
				mfb = new MutualFundBean();
				mfb.setFundNumber(f.getFundNumber());
				mfb.setFundName(f.getFundName());
				mfb.setCompanyName(f.getCompanyName());
				mfb.setFundClassification(f.getFundClassification());
				mfb.setNavps(f.getNavps());
				mfb.setReturnY1(f.getReturnY1());
				mfb.setReturnY3(f.getReturnY3());
				mfb.setReturnY5(f.getReturnY5());
				mfb.setReturnYtd(f.getReturnYtd());
				mfb.setRiskClassification(f.getRiskClassification());
				mfb.setMfCrawledDate(new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now())));
				
				session.save(mfb);
			}
			session.getTransaction().commit();
		} catch(HibernateException he) {
			System.err.println(he.getMessage());
			session.getTransaction().rollback();
		}
		
		JobDetail jobDetail = context.getJobDetail();
		JobKey key = jobDetail.getKey();
		System.out.println("Job " + key + " completed on " + new Date());
	}
	
	private boolean searchMatch(String searchMe, String findMe) {
		if((searchMe.equals("Sun Life Prosperity Philippine Stock Index Fund, Inc. -a") && findMe.equals("Philippine Stock Index Fund")))
			return false;
		else if((searchMe.equals("Sun Life Prosperity Philippine Stock Index Fund, Inc. -a") && findMe.equals("Sun Life Prosperity Philippine Stock Index Fund")) ||
			(searchMe.equals("Philippine Stock Index Fund Corp. -a") && findMe.equals("Philippine Stock Index Fund")) ||
			(searchMe.equals("First Metro Consumer Fund on MSCI Phils. IMI, Inc. -a") && findMe.equals("First Metro Consumer Fund on MSCI Philippines")) ||
			(searchMe.equals("First Metro Phil. Equity Exchange Traded Fund, Inc. -a,c") && findMe.equals("First Metro Philippine Equity Exchange Traded Fund")) ||
			(searchMe.equals("First Metro Save and Learn Fixed Income Fund,Inc. -a") && findMe.equals("First Metro Save And Fixed Income Fund")))
			return true;
		
		boolean match = false;
		int findMeLen = findMe.length();
		int searchMeLen = searchMe.length();
		
		for(int i = 0; i <= (searchMeLen - findMeLen); i++) {
			if(searchMe.regionMatches(true, i, findMe, 0, findMeLen)) {
				match = !match;
				break;
			}
		}
		
		return match;
	}
	
	private static String getRiskType(String classification) {
		switch(classification) {
			case "Bond": return "Moderately Conservative";
			case "Money Market": return "Conservative";
			case "Balanced":
			case "ETF":	return "Moderate";
			default: return "Aggressive";
		}
	}
}
