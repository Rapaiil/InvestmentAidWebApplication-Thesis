package invaid.users.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.opensymphony.xwork2.ActionSupport;

import invaid.users.util.TokenUtil;
import config.Configurations;

@SuppressWarnings("serial")
public class WebCrawlAction extends ActionSupport implements SessionAware, Runnable {
	private Map<String, Object> sessionMap;
	private Map<String, String> table = new HashMap<String, String>();
	private List<String> fundNames = new ArrayList<String>();
	private ArrayList<String> data;
	private String token;
	final static int NO_OF_FUNDS = 383;
	private boolean isSuccess = false;
	
	public String execute() {
		Thread t = new Thread(this);
		t.start();
		if(isSuccess)
			return SUCCESS;
		else
			return ERROR;
	}
	
	@Override
	public void run() {
		token = (String) sessionMap.get("loginToken");
		
		switch(givePermission()) {
			case "denied": return;
		}
		
		for(int i = 1; i < NO_OF_FUNDS; i++) {
			String SOURCE_URL = Configurations.getAppUitf()+i+"#gsc.tab=0";
			
			Document document = null;
			Elements labels = null;
			Elements contents = null;
			String header = null;

			try {
				document = Jsoup.connect(SOURCE_URL).get();
				header = document.select("#inside-fundprofile h3").text();
				labels = document.select("[data-title='Label']");
				contents = document.select("[data-title='Data']");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(!contents.get(1).text().equals("PHP"))
				continue;
			
			System.out.println("Fund name: " + header);
			
			fundNames.add(header);
			for(int j=0; j<labels.size(); j++) {
				table.put(labels.get(j).text(), contents.get(j).text());
			}
		}
		isSuccess = !isSuccess;
		return;
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
