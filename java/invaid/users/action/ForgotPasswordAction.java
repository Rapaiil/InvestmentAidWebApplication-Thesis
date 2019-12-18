package invaid.users.action;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.db.DBCommands;
import invaid.users.model.UserAccountBean;
import invaid.users.util.HibernateUtil;
import invaid.users.util.Mail;
import invaid.users.util.TokenUtil;

@SuppressWarnings({"serial", "rawtypes"})
public class ForgotPasswordAction extends ActionSupport implements ModelDriven, DBCommands {
	private UserAccountBean userAccount = new UserAccountBean();
	Session session = HibernateUtil.getSession();
	
	public String execute() {
		session.getTransaction().begin();
		List<Object[]> list = getRecords();
		String token = null;
		int stats;
		
		if(list != null) {
			for(Object[] record: list) {
				if(record[4].toString().equals(userAccount.getUser_email())) {
					switch(checkStatus(record[5].toString())) {
						case 1: stats = 0;
								token = TokenUtil.generateToken(record[1].toString(), record[2].toString());
								if(!updateUserToken(record[0].toString(), token, stats))
									return ERROR;
								Mail.sendPasswordResetMail(userAccount.getUser_email(), token);
								break;
						case 2: stats = 1;
								token = TokenUtil.generateToken(record[1].toString(), record[2].toString());
								if(!updateUserToken(record[0].toString(), token, stats))
									return ERROR;
								Mail.sendPasswordResetMail(userAccount.getUser_email(), token);
								break;
						case 3: return ERROR;
					}
					
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}
	
	@Override
	public Object getModel() {
		return userAccount;
	}
	
	private int checkStatus(String status) {
		/*
		 * 00 - Unverified/No on-going process (1)
		 * 10 - Verified/No on-going process (2)
		 * x1 - On-going process (3)
		 */
		switch(status.charAt(1)) {
			case '0':
				switch(status.charAt(0)) {
				case '0': return 1;
				case '1': return 2;
				} break;
			case '1': return 3;
		}
		return 0;
	}
	
	private boolean updateUserToken(String id, String token, int stats) {
		try {
			Query query = session.createQuery(UPDATE_TOKEN);
			query.setParameter("tok", token);
			query.setParameter("status", (stats*10+1));
			query.setParameter("id", id);
			
			if(query.executeUpdate() > 0) {
				session.getTransaction().commit();
				return true;
			}
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getRecords() {
		try {
			Query<Object[]> query = session.createQuery(GET_TOKEN_RECORDS);
			return query.getResultList();
		} catch(HibernateException he) {
			session.getTransaction().rollback();
		}
		return null;
	}

}