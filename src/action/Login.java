package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class Login extends ActionSupport {

	private String userName;
	private String userPsw;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPsw() {
		return userPsw;
	}

	public void setUserPsw(String userPsw) {
		this.userPsw = userPsw;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession sess = req.getSession();
		
		User user = new User();
		user.setUserName(this.userName);
		user.setUserPsw(this.userPsw);
		boolean flag = UserDao.checkLogin(user.getUserName(), user.getUserPsw());
		if (flag) {
			sess.setAttribute("ID", user.getUserName());//注意此处：登录成功则更改session里存的ID
			return "T";
		} else {
			return "F";
		}
	}

}
