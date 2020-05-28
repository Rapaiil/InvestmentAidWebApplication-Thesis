package invaid.users.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChartPortfolioAction extends ActionSupport {
	private String somedata;
	
	@Override
	public String execute() {
		
		return SUCCESS;
	}

	public String getSomedata() {
		return somedata;
	}

	public void setSomedata(String somedata) {
		this.somedata = somedata;
	}
	
	

}
