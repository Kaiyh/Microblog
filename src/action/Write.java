package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class Write extends ActionSupport {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession sess = req.getSession();
		String ID = (String)sess.getAttribute("ID");
		
		UserDao.addWeibo(ID, this.message);
		return "T";
	}
	
	

}
