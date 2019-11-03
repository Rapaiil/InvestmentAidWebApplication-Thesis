package invaid.users.action;

import java.util.ArrayList;
import java.util.List;

public class GendersAction {
	private final static String MALE = "Male";
	private final static String FEMALE = "Female";
	private List<String> genders;
	
	public List<String> getGenders() {
		return genders;
	}
	
	public String getDefaultValue() {
		return MALE;
	}
	
	public String execute() {
		genders = new ArrayList<String>();
		genders.add(MALE);
		genders.add(FEMALE);
		return "success";
	}
	
}
