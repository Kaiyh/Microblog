package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class Atten extends ActionSupport {
	
	private String atten;

	public String getAtten() {
		return atten;
	}

	public void setAtten(String atten) {
		this.atten = atten;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession sess = req.getSession();
		String ID = (String)sess.getAttribute("ID");
		
		int n = UserDao.addFans(this.atten, ID);
		if (n == 1) {
			return "F";
		} else if (n == 2) {
			return "T";
		} else {
			Vector<String> ve = UserDao.showLike(atten, ID);
			req.setAttribute("ve2", ve);
			return "like";
		}
	}
	
}
