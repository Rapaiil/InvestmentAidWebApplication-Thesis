package invaid.users.db;

import java.util.List;

public interface DBCommands {
	final static String GET_TOKEN_RECORDS = "SELECT ab.user_profileId, pb.user_firstname, pb.user_lastname,"
			+ " ab.user_token, ab.user_email, ab.user_status"
			+ " FROM UserAccountBean ab LEFT JOIN UserProfileBean pb"
			+ " ON ab.user_profileId = pb.user_profileId";
	final static String GET_LOGIN_RECORDS = "SELECT ab.user_profileId, pb.user_firstname, pb.user_lastname,"
			+ " ab.user_token, ab.user_email, ab.user_password, ab.user_status"
			+ " FROM UserAccountBean ab LEFT JOIN UserProfileBean pb"
			+ " ON ab.user_profileId = pb.user_profileId";
	final static String GET_ACCOUNT_RECORD = "SELECT ab.user_profileId, pb.user_firstname, pb.user_lastname,"
			+ " pb.user_birthday, pb.user_telephonenumber, pb.user_cellphonenumber, pb.user_occupation,"
			+ " pb.user_company, ab.user_email"
			+ " FROM UserAccountBean ab LEFT JOIN UserProfileBean pb"
			+ " ON ab.user_profileId = pb.user_profileId"
			+ " WHERE pb.user_profileId = :id";
	final static String UPDATE_OTP_TOKEN = "UPDATE UserAccountBean"
			+ " set user_token = :tok,"
			+ " user_status = :status,"
			+ " user_otp = :otp"
			+ " WHERE user_profileId = :id";
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
	final static String SAVE_ACCOUNT = "UPDATE UserAccountBean "
			+ "set user_email = :email "
			+ "WHERE user_profileId = :profid";
	final static String SAVE_PROFILE = "UPDATE UserProfileBean "
			+ "set user_firstname = :first_name,"
			+ "user_lastname = :last_name,"
			+ "user_cellphonenumber = :cellphone_no,"
			+ "user_telephonenumber = :telephone_no,"
			+ "user_birthday = :birthday,"
			+ "user_occupation = :occupation,"
			+ "user_company = :company "
			+ "WHERE user_profileId = :profid";
	final static String GET_CURRENT_EMAIL = "SELECT user_email "
			+ "FROM UserAccountBean "
			+ "WHERE user_profileId = :profid";
	final static String GET_EMAILS = "SELECT user_email "
			+ "FROM UserAccountBean "
			+ "WHERE user_profileId != :profid";
	final static String UPDATE_USERFUND = "UPDATE UserFundBean"
			+ " set user_numOfUnitsShares = :numunits,"
			+ " user_fundHorizon = :fundhor"
			+ " WHERE user_fundId = :fundid";
	final static String DELETE_USERFUND = "DELETE FROM UserFundBean"
			+ " WHERE user_fundId = :fundid"; 
	final static String GET_USERFUND = "SELECT user_fundId"
			+ " FROM UserFundBean"
			+ " WHERE user_profileId = :profid";
	final static String GET_MF_USERFUND = "SELECT uf.user_fundId, mf.fundName, mf.fundClassification,"
			+ " uf.user_numOfUnitsShares, uf.user_fundHorizon, uf.user_fundInitAmount, mf.navps"
			+ " FROM UserFundBean uf LEFT JOIN MutualFundBean mf"
			+ " ON uf.fundNumber = mf.fundNumber"
			+ " WHERE uf.user_profileId = :profid AND mf.mfCrawledDate = :date AND uf.user_fundType = 0";
	final static String GET_UITF_USERFUND = "SELECT uf.user_fundId, tf.fundName, tf.fundClassification,"
			+ " uf.user_numOfUnitsShares, uf.user_fundHorizon, uf.user_fundInitAmount, tf.navpu"
			+ " FROM UserFundBean uf LEFT JOIN TrustFundBean tf"
			+ " ON uf.fundNumber = tf.fundNumber"
			+ " WHERE uf.user_profileId = :profid AND tf.uitfCrawledDate = :date AND uf.user_fundType = 1";
	public List<Object[]> getRecords();
}
