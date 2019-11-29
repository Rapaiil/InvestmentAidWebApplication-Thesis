package invaid.users.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import invaid.users.model.UserAccountBean;
import invaid.users.model.UserProfileBean;
import invaid.users.util.HibernateUtil;

@SuppressWarnings("serial")
public class RenewPasswordAction extends ActionSupport implements ModelDriven{
	private UserAccountBean user = new UserAccountBean();
	private String password;
	private String confirm_password;
	private String keyword = "token=";
	private String url = ServletActionContext.getRequest().getHeader("Referer");
	private int result;
	private String token;
	Session session = HibernateUtil.getSession();
	
	public String execute() {
		result = isSubstring(keyword,url);
		System.out.println("password:" + password);
		if(result == -1) {
			return ERROR;
		}
		else {
			System.out.println(result);
			token = url.substring(result+6);
			boolean UpdateSuccess = updateRecord();
			
			if(UpdateSuccess) {
				return SUCCESS;
			}
			else {
				return ERROR;
			}
		}
		//System.out.println(url);
		//Update database
		
		
	}	
	
	//Functions
	public int isSubstring(String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        } 
      
        return -1; 
    } 
	
	public boolean updateRecord() {
		boolean updateComplete = false;
		List recordsList = getRecords();
		
		if(recordsList != null) {
			System.out.println("No. of Records:" + recordsList.size());
					System.out.println("Updating Records");
					//Token should be set here from temp to user
					//temp.setUser_accountId(user.getUser_accountId());
					
			Transaction transaction = session.beginTransaction();
		  	String hql = "UPDATE UserAccountBean set user_password = :pass "  + 
	             "WHERE reset_token = :tok";
			Query query = session.createQuery(hql);
			query.setParameter("pass", password);
			System.out.println(password + token + confirm_password);
			query.setParameter("tok", token);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			transaction.commit();
			updateComplete = true;
			session.close();
		}
		return updateComplete;
	}
	
	private List getRecords() {
		List recordsList = new ArrayList();
		
		try {
			session.beginTransaction();
			
			recordsList = session.createQuery("FROM UserAccountBean").list();
		}
		catch(Exception sqle) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			System.out.println("Stack trace here");
			sqle.printStackTrace();
		}
		finally {
			if(session != null) {
				
			}
		}
		return recordsList;
	}
	
	public boolean verifyPassword() {
		boolean passwords_match = false;
		if(this.password == this.confirm_password) {
			passwords_match = true;
		}
		
		return passwords_match;
	}
	
	//Getters and Setters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	//Implemented Methods
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
