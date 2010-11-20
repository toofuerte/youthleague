package uyifl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uyifl.utils.ParamSorter;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@SuppressWarnings("serial")
public class Users extends HttpServlet {

	private final String HREF="http://localhost:8888/app/";

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		ParamSorter params = new ParamSorter(req.getParameterMap());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String location=params.get("href");
		//String action = params.get("a");
		//String location = params.get("h");
		//if (action.equals("l")) {
			out.println(getUserLink(location));
		//}

	}

	private String getUserLink(String href) {
		UserService userService = UserServiceFactory.getUserService();
		User user = getUser();
		String ret = "";
		if (user == null) {
			ret = "<a href=" + userService.createLoginURL(href) + ">Login here</a>";
		} else if ( isAdmin(user)  ) {
			ret = "<a href=\"admin\">Administration</a>";
		} else {
			ret = "<a href=\""+userService.createLogoutURL(href)+"\">Sign Out</a>";
		}
		return ret;
	}
	
	public User getUser() {
		return UserServiceFactory.getUserService().getCurrentUser();
	}
	
	public boolean isAdmin(User user) {
		String e = user.getEmail();
		return ( e.equals("danlangford@gmail.com") || e.equals("garyacton@gmail.com") );
	}

	public String signOutLink() {
		return UserServiceFactory.getUserService().createLogoutURL(this.HREF);
	}

	public String signInLink() {
		return UserServiceFactory.getUserService().createLoginURL(this.HREF);
	}
	
	public String[] userLinkInfo() {
		String ret[] = new String[2];
		User user = getUser();
		if (user == null) {
			ret[0] = signInLink();
			ret[1] = "Login Here";
		} else if ( isAdmin(user)  ) {
			ret[0] = "admin";
			ret[1] = "Administration";
		} else {
			ret[0] = signOutLink();
			ret[1] = "Sign Out";
		}
		return ret;
	}


}
