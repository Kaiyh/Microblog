package action;

import java.util.regex.Pattern;
import model.*;
import dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {

	private String newUser;
	private String newPsw;

	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (newUser.length() < 2 || newUser.length() > 20) {
			addFieldError("newUser", "用户名长度必须在2~20范围内");
		}
		if (!Pattern.matches("\\w{6, 20}", newPsw)) {
			addFieldError("newPsw", "密码必须是字母和数字的组合且长度在6~20范围内");
		}
		
		if (hasErrors()) {
			return "error";
		}
		
		User user = new User();
		user.setUserName(this.newUser);
		user.setUserPsw(this.newPsw);
		boolean flag = UserDao.checkRegister(user.getUserName(), user.getUserPsw());
		if (flag) {
			return "T";
		} else {
			return "F";
		}
	}
	
}
