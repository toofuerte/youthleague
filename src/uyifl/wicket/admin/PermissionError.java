package uyifl.wicket.admin;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.ExternalLink;

import uyifl.servlets.Users;

public class PermissionError extends WebPage {

	public PermissionError(){
		add(new ExternalLink("admin_check", new Users().signInLink(), "You must be an administrator, please click here to sign in."));
	}
	
}
