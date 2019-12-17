package invaid.users.db;

import java.util.List;

public interface DBCommands {
	final static String GET_ALL_ACCOUNT_RECORDS = "SELECT u "
			+ "FROM UserAccountBean u";
	final static String GET_TOKEN_RECORDS = "SELECT user_token, user_status, user_profileId"
			+ " FROM UserAccountBean"; 
	final static String UPDATE_PASSWORD = "UPDATE UserAccountBean "
			+ "set user_password = :pass "
			+ "WHERE user_token = :tok";
	final static String VERIFY_USER = "UPDATE UserAccountBean "
			+ "set user_status = :status, "
			+ "user_token = :newtok "
			+ "WHERE user_token = :tok";
	final static String GET_TOKEN_PROFILE_RECORD = "SELECT user_profileId, user_firstname, user_lastname"
			+ " FROM UserProfileBean";
	
	public List<Object[]> getRecords();
}
