package invaid.users.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.struts2.interceptor.SessionAware;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.opensymphony.xwork2.ActionSupport;

import invaid.users.model.MfFundDetail;
import invaid.users.model.MfFundDetails;
import invaid.users.util.TokenUtil;
import config.Configurations;

@SuppressWarnings("serial")
public class MFWebCrawlAction extends ActionSupport implements SessionAware, Runnable {
	private Map<String, Object> sessionMap;
	MfFundDetails fundList = new MfFundDetails();
	MfFundDetail fund = null;
	private String token;
	final static int NO_OF_BANKS = 42;
	final static int NO_OF_FUNDS = 386;
	private boolean isSuccess = false;
	
	public String execute() {
		token = (String) sessionMap.get("loginToken");
		
		switch(givePermission()) {
			case "denied": return ERROR;
		}
		
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
			
			marshaller.marshal(fundList, new File("/WEB-INF/mf-data.xml"));
		} catch(JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}
		return SUCCESS;
		
		/*
		 * Thread t = new Thread(this); t.start(); if(isSuccess) return SUCCESS; else
		 * return ERROR;
		 */
	}
	
	@Override
	public void run() {
		
	}
	
	private String givePermission() {
		try {
			if(token == null)
				throw new NullPointerException("Token is empty!");
			TokenUtil.verifyUserToken().verify(token);
			return "granted";
		} catch(JWTDecodeException | AlgorithmMismatchException | SignatureVerificationException jwtve) {
			System.err.println("Invalid token! Access is denied.");
		} catch(InvalidClaimException jwtve) {
			System.err.println("Access is denied.");
		} catch(TokenExpiredException jwtve) {
			System.err.println("Session has expired!");
		} catch(JWTVerificationException jwtve) {
			System.err.println(jwtve.getMessage());
		} 
		return "denied";
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
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
