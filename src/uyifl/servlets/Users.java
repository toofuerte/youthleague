package uyifl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@SuppressWarnings("serial")
public class Users extends HttpServlet {

	private Map<String, String[]> params;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		params = req.getParameterMap();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String location=form("href");
		//String action = form("a");
		//String location = form("h");
		//if (action.equals("l")) {
			out.println(getUserStuff(location));
		//}

	}

	private String getUserStuff(String href) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		String ret = "";
		if (user == null) {
			ret = "<a href="
					+ userService.createLoginURL(href)
					+ ">Login here</a>";
		} else if (user.getEmail().equals("danlangford@gmail.com")) {
			ret = "<a href=\"javascript:alert('you are an admin')\">Administration</a>";
		} else {
			ret = "<a href=\""+userService.createLogoutURL(href)+"\">Sign Out</a>";
		}
		return ret;
	}

	private String form(String field) {
		if (params.containsKey(field))
			return params.get(field)[0];
		else
			return "n/a";
	}

}
