package uyifl.wicket.admin;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;

import com.google.appengine.api.users.User;

import uyifl.servlets.Users;

public class AdminTemplate extends WebPage {

	public AdminTemplate() {

		boolean canSee = false;

		Users us = new Users();
		User user = us.getUser();
		String link = "";
		String msg = "";
		if (user == null) {
			link = us.signInLink();
			msg = "please sign in as an administrator to proceed";
		} else {
			link = us.signOutLink();
			if (us.isAdmin(user)) {
				msg = "Welcome Administrator! click here to log out";
				canSee = true;
			} else {
				msg = "you are not an administrator, click here to sign out";
			}
		}

		if (!link.equals(""))
			add(new ExternalLink("admin_check", link, msg));

		if (!canSee)
			throw new RestartResponseException(PermissionError.class);

	}

}
