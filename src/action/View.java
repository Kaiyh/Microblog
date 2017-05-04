package action;

import com.opensymphony.xwork2.ActionSupport;

public class View extends ActionSupport {
	
	public String registerView() {
		return "register";
	}
	
	public String loginView() {
		return "login";
	}
	
	public String write_weiboView() {
		return "write";
	}
	/*
	public String login_successView() {
		return "main";
	}
	*/
	public String attentionView() {
		return "atten";
	}
	
	public String fansView() {
		return "fans";
	}

}
