package invaid.users.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.util.HibernateUtil;
import invaid.users.util.Mail;

@SuppressWarnings({"serial", "rawtypes"})
public class ForgotPasswordAction extends ActionSupport implements ModelDriven, DBCommands {
	private UserAccountBean userAccount = new UserAccountBean();
	Session session = HibernateUtil.getSession();
	
	//Execute
	public String execute() {
		if(isValidRecord()) {
			Mail.sendPasswordResetMail(userAccount);
			return SUCCESS;
		}
		return ERROR;
	}
	
	private boolean isValidRecord() {
		UserAccountBean userTemp;
		List<Object> list = getRecords();
		Iterator recordsList = list.iterator();
		boolean recordExists = false;
		
		while(recordsList.hasNext()) {
			Object[] obj = (Object[]) recordsList.next();
			userTemp = new UserAccountBean();
			userTemp.setUser_email(obj[0].toString());
			if(userTemp.getUser_email().equals(userAccount.getUser_email()))
				return !recordExists;
		}
		return recordExists;
	}
	
	//Implemented Methods
	@Override
	public Object getModel() {
		return userAccount;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getRecords() {
		try {
			session.beginTransaction();
			return (List<Object>) session.createQuery(DBCommands.GET_ALL_ACCOUNT_RECORDS).list();
		} catch(Exception sqle) {
			if(null != session.getTransaction())
				session.getTransaction().rollback();
			System.err.println(sqle.getMessage());
		} finally {
			if(session != null) {
				HibernateUtil.shutdown();
			}
		}
		return null;
	}
}