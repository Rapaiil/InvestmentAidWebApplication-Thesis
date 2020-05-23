package invaid.users.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import invaid.users.util.Mail;

public class SendFeedbackAction extends ActionSupport{
	//Variables
	private String feedback_name;
	private String feedback_email;
	private String feedback_message;
	private boolean feedback_success;

	public String execute() {
		System.out.println("Executing...");
		boolean success = Mail.sendFeedback(getFeedback_name(), getFeedback_email(), getFeedback_message());
		
		if(success) {
			setFeedback_success(success);
			System.out.println(success);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void validate() {
		boolean isNameValid;
		boolean isEmailValid;
		boolean isMessageValid;
		System.out.println("Validating...");
		System.out.println(getFeedback_name());
		System.out.println(getFeedback_email());
		System.out.println(getFeedback_message());
		
		
		//Name
		isNameValid = checkIfNull(feedback_name);
		if(!isNameValid) {
			addFieldError("emn","This field is required");
		}
		else {
			isNameValid = checkNameValid(feedback_name);
			if(!isNameValid) {
				addFieldError("emn","Please enter a valid name");
			}
		}
		
		//Email
		isEmailValid = checkIfNull(feedback_email);
		if(!isEmailValid) {
			addFieldError("emea","This field is required");
		}
		else {
			isEmailValid = ValidateEmail(feedback_email);
			if(!isEmailValid) {
				addFieldError("emea","Please enter a valid email address");
			}
		}
		
		//Message
		isMessageValid = checkIfNull(feedback_message);
		if(!isMessageValid) {
			addFieldError("emm","This field is required");
		}
	}
	
	//Functions
	private boolean checkIfNull(String string) {
		if((string.trim() == "") || (string.trim() == null)){
			return false;
		}
		return true;
	}
	private boolean checkNameValid(String string) {
		String nameRegex = "^[A-Za-z_-]*$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(string.trim());
		if (nameMatcher.matches()) {
			return true;
		}
		return false;
	}
	private boolean ValidateEmail(String string) {
		String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(string.trim());
		if (emailMatcher.matches()) {
			return true;
		}
		return false;
	}
	
	//Getters and Setters
	public String getFeedback_name() {
		return feedback_name;
	}
	public void setFeedback_name(String feedback_name) {
		this.feedback_name = feedback_name;
	}
	public String getFeedback_email() {
		return feedback_email;
	}
	public void setFeedback_email(String feedback_email) {
		this.feedback_email = feedback_email;
	}
	public String getFeedback_message() {
		return feedback_message;
	}
	public void setFeedback_message(String feedback_message) {
		this.feedback_message = feedback_message;
	}
	public boolean getFeedback_success() {
		return feedback_success;
	}

	public void setFeedback_success(boolean feedback_success) {
		this.feedback_success = feedback_success;
	}
}