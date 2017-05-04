package model;

public class User {

	private String userName;
	private String userPsw;
	private String userWeibo;

	public String getUserWeibo() {
		return userWeibo;
	}

	public void setUserWeibo(String userWeibo) {
		this.userWeibo = userWeibo;
	}

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

}
