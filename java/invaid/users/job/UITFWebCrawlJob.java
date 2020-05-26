package invaid.users.job;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

import invaid.users.model.Bank;
import invaid.users.model.TrustFundBean;
import invaid.users.model.UitfFundDetail;
import invaid.users.model.UitfFundDetails;
import invaid.users.util.HibernateUtil;
import config.Configurations;

public class UITFWebCrawlJob implements Job {
	UitfFundDetails fundList = new UitfFundDetails();
	final static int NO_OF_BANKS = 42;
	final static int NO_OF_FUNDS = 386;
	private String contextPath = Configurations.getUitfFile();
	Session session = HibernateUtil.getSession();
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Executing web crawl action for unit investement trust fund...");
		
		fundList.setList(new ArrayList<UitfFundDetail>());
		List<Bank> banko = Arrays.asList(Bank.values());
		int bankNum = 0;
		int fundCount = 0;
		
		for(int ctr=1; ctr<NO_OF_BANKS; ctr++) {
			if(ctr == 27)
				continue;
			String BANKSOURCE_URL = Configurations.getAppBankUitf()+ctr+Configurations.getAppUitfExt();
			
			Document document = null;
			Elements siblings = null;
			Elements table = null;
			Elements row = null;
			Map<String, String> fund;
			List<Map<String, String>> funds = new ArrayList<Map<String,String>>();
			Iterator<String> rawData = null;
			
			try {
				document = Jsoup.connect(BANKSOURCE_URL).get();
				if(document.select(".hovertable").isEmpty())
					continue;
				siblings = document.select("#inside-fundprofile h4").first().siblingElements();
				for(int i=1; i < siblings.size(); i++) {
					if(!"h4".equals(siblings.get(i).tagName())) {
						if("table".equals(siblings.get(i).tagName())) {
							table = siblings.get(i).children();
							row = table.select("tbody td");
							rawData = row.eachText().iterator();
							
							while(rawData.hasNext()) {
								fund = new HashMap<String, String>();
								UitfFundDetail fd = new UitfFundDetail();
								
								fund.put("Bank", banko.get(bankNum).getAction());
								fund.put("Fund Name", rawData.next().toString());
								fund.put("Classification", rawData.next().toString());
								fund.put("NAVpu", rawData.next().toString());
								fund.put("ROIYOY", rawData.next().toString());
								fund.put("ROIYTD", rawData.next().toString());
								
								funds.add(fund);
								
								fd.setFundNumber(++fundCount);
								fd.setBankName(fund.get("Bank"));
								fd.setFundName(fund.get("Fund Name"));
								fd.setFundClassification(fund.get("Classification"));
								fd.setNavpu(fund.get("NAVpu"));
								fd.setRoiyoy(fund.get("ROIYOY"));
								fd.setRoiytd(fund.get("ROIYTD"));
								fundList.getList().add(fd);
							}
						} else
							continue;
					} else
						break;
				}
				bankNum++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		List<UitfFundDetail> fdList = fundList.getList();
		fundList.setList(new ArrayList<UitfFundDetail>());
		boolean found = false;
		int total = 0;
		
		for(int ctr=1; ctr<NO_OF_FUNDS; ctr++) {
			total++;
			if((ctr > 4 && ctr < 8) ||
			   (ctr > 10 && ctr < 34) ||
			   (ctr > 42 && ctr < 46) ||
			   (ctr > 53 && ctr < 58) ||
			   (ctr > 64 && ctr < 68) ||
			   (ctr > 100 && ctr < 125) ||
			   (ctr > 135 && ctr < 142) ||
			   (ctr > 145 && ctr < 157) ||
			   (ctr > 159 && ctr < 175) ||
			   (ctr > 179 && ctr < 182) ||
			   (ctr > 198 && ctr < 201) ||
			   (ctr > 219 && ctr < 227) ||
			   (ctr > 231 && ctr < 238) ||
			   (ctr > 241 && ctr < 246) ||
			   (ctr > 259 && ctr < 263) ||
			   (ctr > 298 && ctr < 305) ||
			   (ctr > 318 && ctr < 327) ||
			   (ctr > 327 && ctr < 330) ||
			   (ctr > 333 && ctr < 340) ||
			   (ctr > 340 && ctr < 344) ||
			   (ctr > 349 && ctr < 353) ||
			   (ctr > 357 && ctr < 360) ||
			   (ctr > 366 && ctr < 369) ||
			   (ctr > 371 && ctr < 374) ||
			   (ctr > 377 && ctr < 385) ||
			   ctr == 9 || ctr == 47 || ctr == 72 || ctr == 77 || ctr == 79 ||
			   ctr == 83 || ctr == 87 || ctr == 90 || ctr == 99 || ctr == 144 ||
			   ctr == 181 || ctr == 158 || ctr == 183 || ctr == 210 || ctr == 206 ||
			   ctr == 202 || ctr == 249 || ctr == 253 || ctr == 265 || ctr == 272 ||
			   ctr == 288 || ctr == 306 || ctr == 331 || ctr == 343 || ctr == 346 ||
			   ctr == 348 || ctr == 354 || ctr == 356 || ctr == 362 || ctr == 365 ||
			   ctr == 376)
				continue;
			
			String SOURCE_URL = Configurations.getAppFundUitf()+ctr+Configurations.getAppUitfExt();
			
			Document document = null;
			Elements table = null;
			String header = null;
			UitfFundDetail fd = null;
			Iterator<UitfFundDetail> temp = fdList.iterator();
			Iterator<String> rawData = null;

			try {
				if(total % 90 == 0)
					TimeUnit.MINUTES.sleep(10);
				else
					TimeUnit.MINUTES.sleep(1);
				
				document = Jsoup.connect(SOURCE_URL).get();
				header = document.select("#inside-fundprofile h3").text().toString();
				
				table = document.select("[data-title='Data']");
				while(temp.hasNext()) {
					fd = temp.next();
					if(header.equals(fd.getFundName())) {
						found = !found;
						break;
					}
				}
				
				if(!found) {
					System.err.println("Fund doesn't exist!");
					continue;
				} else {
					found = !found;
				
					rawData = table.eachText().iterator();
					
					if(fd.getFundName().equals("AB CAPITAL BALANCED FUND")) {
						fd.setBenchmark("50% - 1 Yr, T-Bill +50%, PSEi");
						while(rawData.hasNext()) {
							rawData.next();
							rawData.next();
							fd.setRiskClassification(rawData.next().toString());
							fd.setMinInitParticipation(convertValue(rawData.next().toString()));
							fd.setMinAddParticipation(convertValue(rawData.next().toString()));
							fd.setMinMaintainParticipation(convertValue(rawData.next().toString()));
							fd.setMinHoldingDays(rawData.next().toString());
							fd.setCutOffTime(rawData.next().toString());
							fd.setSettlementDate(rawData.next().toString());
							fd.setTrustFee(rawData.next().toString());
							fd.setExitFee(rawData.next().toString());
							fundList.getList().add(fd);
						}
					} else if(fd.getFundName().equals("AB CAPITAL SHORT-TERM FUND")) {
						fd.setBenchmark("91-Day T-Bill");
						while(rawData.hasNext()) {
							rawData.next();
							rawData.next();
							fd.setRiskClassification(rawData.next().toString());
							fd.setMinInitParticipation(convertValue(rawData.next().toString()));
							fd.setMinAddParticipation(convertValue(rawData.next().toString()));
							fd.setMinMaintainParticipation(convertValue(rawData.next().toString()));
							fd.setMinHoldingDays(rawData.next().toString());
							fd.setCutOffTime(rawData.next().toString());
							fd.setSettlementDate(rawData.next().toString());
							fd.setTrustFee(rawData.next().toString());
							fd.setExitFee(rawData.next().toString());
							fundList.getList().add(fd);
						}
					} else if(fd.getFundName().equals("AB CAPITAL EQUITY FUND")) {
						fd.setBenchmark("PSEi");
						while(rawData.hasNext()) {
							rawData.next();
							rawData.next();
							fd.setRiskClassification(rawData.next().toString());
							fd.setMinInitParticipation(convertValue(rawData.next().toString()));
							fd.setMinAddParticipation(convertValue(rawData.next().toString()));
							fd.setMinMaintainParticipation(convertValue(rawData.next().toString()));
							fd.setMinHoldingDays(rawData.next().toString());
							fd.setCutOffTime(rawData.next().toString());
							fd.setSettlementDate(rawData.next().toString());
							fd.setTrustFee(rawData.next().toString());
							fd.setExitFee(rawData.next().toString());
							fundList.getList().add(fd);
						}
					} else {
						while(rawData.hasNext()) {
							rawData.next();
							rawData.next();
							fd.setRiskClassification(rawData.next().toString());
							fd.setMinInitParticipation(convertValue(rawData.next().toString()));
							fd.setMinAddParticipation(convertValue(rawData.next().toString()));
							fd.setMinMaintainParticipation(convertValue(rawData.next().toString()));
							fd.setMinHoldingDays(rawData.next().toString());
							fd.setCutOffTime(rawData.next().toString());
							fd.setSettlementDate(rawData.next().toString());
							fd.setTrustFee(rawData.next().toString());
							fd.setExitFee(rawData.next().toString());
							fd.setBenchmark(rawData.next().toString());
							fundList.getList().add(fd);
						}
					}
				}
			} catch(InterruptedException ie) {
				ie.getMessage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			JAXBContext jaxb = JAXBContext.newInstance(UitfFundDetail.class);
			
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshaller.marshal(fundList, new File(contextPath));
		} catch(JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}
		
		try {
			session.getTransaction().begin();
			TrustFundBean tfb;
			
			for(UitfFundDetail f: fundList.getList()) {
				tfb = new TrustFundBean();
				tfb.setFundNumber(f.getFundNumber());
				tfb.setFundName(f.getFundName());
				tfb.setBankName(f.getBankName());
				tfb.setFundClassification(f.getFundClassification());
				tfb.setNavpu(f.getNavpu());
				tfb.setRoiyoy(f.getRoiyoy());
				tfb.setRoiytd(f.getRoiytd());
				tfb.setMinInitParticipation(String.valueOf(f.getMinInitParticipation()));
				tfb.setMinAddParticipation(String.valueOf(f.getMinAddParticipation()));
				tfb.setMinMainParticipation(String.valueOf(f.getMinMaintainParticipation()));
				tfb.setMinHoldingDays(String.valueOf(f.getMinHoldingDays()));
				tfb.setSettlementDate(f.getSettlementDate());
				tfb.setTrustFee(f.getTrustFee());
				tfb.setExitFee(f.getExitFee());
				tfb.setCutOffTime(f.getCutOffTime());
				tfb.setBenchmark(f.getBenchmark());
				tfb.setRiskClassification(f.getRiskClassification());
				tfb.setUitfCrawledDate(new SimpleDateFormat("MM/dd/yyyy").format(Date.from(Instant.now())));
				
				session.save(tfb);
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
	
	private double convertValue(String text) {
		NumberFormat format = NumberFormat.getInstance(Locale.US);
		Number number = 0;
		try {
			number = format.parse(text);
		} catch(ParseException pe) {
			pe.getMessage();
		}
		return number.doubleValue();
	}
}
