package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class NoAtten extends ActionSupport {
	
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
		
		if (this.atten == null || this.atten.equals("")) {
			return "F";
		}
		UserDao.noFans(atten, ID);
	    return "T";
	}

}
