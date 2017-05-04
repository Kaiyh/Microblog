package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession sess = req.getSession();
		String ID = (String)sess.getAttribute("ID");
		
		if (ID == null) {
			return "notlogin";
		}
		
		return arg0.invoke();
	}
	
}
