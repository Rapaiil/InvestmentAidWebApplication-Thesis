package invaid.users.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RedirectErrorAction extends ActionSupport {
	@Override
	public String execute() {
		return ERROR;
	}
}
