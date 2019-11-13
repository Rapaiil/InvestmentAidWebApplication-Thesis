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
public class RegisterProfileAction extends ActionSupport implements ModelDriven {
	private UserBean temp_user = new UserBean();
	
	private void addUser() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		Transaction t = session.getTransaction();
		try {
			session.save(temp_user);
			t.commit();
		} catch(HibernateException he) {
			t.rollback();
		}
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
		addUser();
		return SUCCESS;
	}
}
