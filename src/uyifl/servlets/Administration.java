package uyifl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;

import uyifl.utils.ParamSorter;

@SuppressWarnings("serial")
public class Administration extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		ParamSorter params = new ParamSorter(req.getParameterMap());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Users theList = new Users();
		User user = theList.getUser();
		if(!theList.isAdmin(user)) {
			out.println("You are not an authorized administrator. Feel free to return to our <a href=index.html>home page</a>");
			return;
		}
		
		out.println(getPage(1));
		
		out.println("welcome admin!");
		
		out.println(getPage(2));

	}

	private String getPage(int i) {
		String ret="";
		switch (i) {
		case 1:
			ret+="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html xmlns=http://www.w3.org/1999/xhtml><head><meta http-equiv=Content-Type name=keywords content=\"UYIFL,Utah youth indoor football, utah football, indoor, bylaws, football,utah, youth, indoor football, gaurdsman way, rice, eccles, rice eccles, rice eccles field house, take it indoors\" /><title>UYIFL   - Take it Indoors - Home</title><link rel=stylesheet type=text/css href=uyifl2.css/></head><body><div id=logo><a href=index.html><img src=pictures/takeit.gif alt=\"UYIFL Logo\" border=0 height=75px /></a></div><div id=container1><div id=leftcolumn><div id=menu><ul><li><h2>Menu</h2><ul><li><a href=db1.html title=DataBase>Data Base</a></li></ul><ul><li><a href=dbc.html title=Coach>Coach</a></li></ul><ul><li><a href=dbt.html title=Teams>Teams</a></li></ul><ul><li><a href=dbfund.html title=Funds>Funds</a></li></ul><ul><li><a href=dbplay.html title=Player>Players</a></li></ul><ul><li><a href=dbpart.html title=Parents>Parents</a></li></ul><ul><li><a href=dbequip.html title=Equipment>Equipment</a></li></ul></li></ul></div></div><!--ADDS SPACE--><div id=adds></div><div id=rightcolumn>";
			break;
		case 2:
			ret+="</div><div id=footer><h5>Copyright© 2010 Utah Youth Indoor Football League</h5><a href=mailto:gary@uyifl.com>By Gary Acton</a></div></div></body></html>";
			break;
		}
		return ret;
	}

}
