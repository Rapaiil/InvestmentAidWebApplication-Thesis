package invaid.users.action;

import java.io.IOException;
import java.util.ArrayList;
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

@SuppressWarnings("serial")
public class WebCrawlAction extends ActionSupport implements SessionAware, Runnable {
	private Map<String, Object> sessionMap;
	private ArrayList<String> data;
	private String token;
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
		
		for(int i = 1; i < 382; i++) {
			String SOURCE_URL = "http://www.uitf.com.ph/daily_navpu_details.php?fund_id="+i+"#gsc.tab=0";
			
			Document document = null;
			Elements texts = null;
			try {
				document = Jsoup.connect(SOURCE_URL).get();
				texts = document.select("*");
			} catch (IOException e) {
				e.printStackTrace();
			}
			String title = document.title();
			System.out.println("Title is " + title);
			for(Element text: texts) {
				data.add(text.data());
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
