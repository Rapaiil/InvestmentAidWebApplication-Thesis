package invaid.users.action;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.UserBean;

@SuppressWarnings({"serial", "rawtypes"})
public class RegisterAccountAction extends ActionSupport implements ModelDriven {
	private UserBean temp_user;

	private boolean addUser() {
		temp_user = new UserBean();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Transaction t = session.getTransaction();
		try {
			session.save(temp_user);
			t.commit();
			return true;
		} catch(HibernateException he) {
			t.rollback();
		}
		return false;
	}
	
	public UserBean getTemp_user() {
		return temp_user;
	}
	
	public void setTemp_user(UserBean temp_user) {
		this.temp_user = temp_user;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return temp_user;
	}
	
	public String execute() {
		if(addUser()) {
			return SUCCESS;
		}
		return ERROR;
	}

}
