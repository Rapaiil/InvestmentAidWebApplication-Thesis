package invaid.users.db;

import java.util.List;

public interface DBCommands {
	final static String GET_TOKEN_RECORDS = "SELECT ab.user_profileId, pb.user_firstname, pb.user_lastname,"
			+ " ab.user_token, ab.user_email, ab.user_status"
			+ " FROM UserAccountBean ab LEFT JOIN UserProfileBean pb"
			+ " ON ab.user_profileId = pb.user_profileId"; 
	final static String UPDATE_TOKEN = "UPDATE UserAccountBean"
			+ " set user_token = :tok,"
			+ " user_status = :status"
			+ " WHERE user_profileId = :id";
	final static String UPDATE_PASSWORD = "UPDATE UserAccountBean"
			+ " set user_password = :pass,"
			+ " user_token = :tok,"
			+ " user_status = :status"
			+ " WHERE user_profileId = :id";
	final static String VERIFY_USER = "UPDATE UserAccountBean "
			+ "set user_status = :status, "
			+ "user_token = :newtok "
			+ "WHERE user_token = :tok";
	
	public List<Object[]> getRecords();
}
