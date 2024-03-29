package uyifl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uyifl.pojos.RegForm;
import uyifl.utils.PMF;
import uyifl.utils.ParamSorter;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PhoneNumber;

@SuppressWarnings("serial")
public class Registration extends HttpServlet {

	private PersistenceManager pm = PMF.get().getPersistenceManager();
	ParamSorter params;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		params = new ParamSorter(req.getParameterMap());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(getPageHeader());

		String action = params.get("a");
		if (action.equals("d")) {
			RegForm rf = getRegForm(params.get("k"));
			String msg = rf.getKey().toString();
			pm.deletePersistent(rf);
			out.println("i deleted form: " + msg);
		} else if (action.equals("da")) {
			pm.deletePersistentAll(getAllForms());
			out.println("datastore purged");
		} else if (action.equals("sa")) {
			out.println("select all objects:<br>");
			out.println(displayForms(getAllForms()));
		} else {
			out.println("ERROR: no 'input data' or 'action' found");
		}
	}

	

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		params = new ParamSorter(req.getParameterMap());
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(getPageHeader());

		if (acceptableAttempt()) {
			RegForm form = compileRegForm();
			try {
				persist(form);
			} catch (Exception e) {
				out.println("whoa, i ran into an error");
				out.println(e.toString());
				out.println("see server log for details");
			}
			out.println("well, i finished processing the input, thank you");
		}

	}

	private String getPageHeader() {
		StringBuilder value = new StringBuilder();
		value.append("<h3>Hello, servlet</h3>");
		value.append("<b>controls:</b> <a href=\"reg.html\">Add new record</a>, <a href=\"?a=sa\">View all records</a>, <a href=\"?a=da\">Delete all records</a>");
		value.append("<br><hr>");
		return value.toString();
	}

	/**
	 * test that request looks like it contains right info. we could test
	 * referring page or parameter existence TODO confirm request requirements
	 * 
	 * @return boolean acceptability
	 */
	private boolean acceptableAttempt() {
		if (form("subject").equals("Sign Up")
				&& form("redirect").equals("reg.html"))
			return true;
		else
			return false;
	}

	private String form(String string) {
		return params.get(string);
	}



	/**
	 * @return RegForm object with values set from request params
	 */
	private RegForm compileRegForm() {
		RegForm rf = new RegForm();
		rf.setFirstName(form("pfname"));
		rf.setLastName(form("plname"));
		
		RegForm.PostalAddress p = new RegForm.PostalAddress();
		p.setAddress1(form("padd1"));
		p.setAddress2(form("padd2"));
		p.setState(form("pState"));
		p.setZipCode("pzip");
		p.setCity(form("pcity"));
		rf.setAddress(p);
		
		rf.setHomeNumber(new PhoneNumber(form("phphone")));
		rf.setCellNumber(new PhoneNumber(form("pcphone")));
		rf.setEmail(new Email(form("pemail")));
		return rf;
	}

	private RegForm getRegForm(String k) {
		RegForm r = pm.getObjectById(RegForm.class, KeyFactory.stringToKey(k));
		return r;
	}

	/**
	 * @param form
	 */
	private void persist(RegForm form) throws Exception {
		try {
			pm.makePersistent(form);
		} finally {
			// pm.close();
		}
	}

	private List<RegForm> getAllForms() {
		List<RegForm> forms = (List<RegForm>) pm.newQuery(
				"SELECT FROM " + RegForm.class.getName()).execute();
		return forms;
	}

	private String displayForms(List<RegForm> forms) {
		String value = "";
		if (forms != null) {
			value += "\n<br>I have " + forms.size() + " record(s)<br><ul>\n";
			for (RegForm rf : forms)
				value += "<li>" + rf.toString() + " <a href=\"?a=d&k="
						+ KeyFactory.keyToString(rf.getKey())
						+ "\">delete</a></li> \n";
			value += "</ul>";
		} else
			value += "uh oh, collection of Forms is NULL";
		return value;
	}

	// private void displayParams(PrintWriter out) {
	// // just display all the parameters received
	// Enumeration<String> parameterNames = params.getParameterNames();
	// while (parameterNames.hasMoreElements()) {
	// String paramName = parameterNames.nextElement();
	// out.println("<br><B>" + paramName + "</B>");
	// String[] paramValues = params.getParameterValues(paramName);
	// if (paramValues.length == 1) {
	// String paramValue = paramValues[0];
	// if (paramValue.length() == 0)
	// out.print("=<I>No Value</I>");
	// else
	// out.print("=" + paramValue);
	// } else {
	// out.println("<UL>");
	// for (int i = 0; i < paramValues.length; i++) {
	// out.println("<LI>" + paramValues[i]);
	// }
	// out.println("</UL>");
	// }
	// }
	// }

}
