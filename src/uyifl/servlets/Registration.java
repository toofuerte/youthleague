package uyifl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uyifl.pojos.RegForm;
import uyifl.utils.PMF;

import com.google.appengine.api.datastore.PhoneNumber;

@SuppressWarnings("serial")
public class Registration extends HttpServlet {

	/**
	 * the POST parameters. storing these in the class scope allows a couple of
	 * methods to access them
	 */
	private Map<String, String[]> params;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Hello, servlet<br>GET<br>ERROR: no form data found");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		params = req.getParameterMap();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Hello, servlet<br>POST<hr>");
		if (acceptableAttempt()) {
			RegForm form = compileRegForm();
			try {
				persist(form);
			} catch (Exception e) {
				out.println("whoa, i ran into an error");
				out.println(e.toString());
				out.println("see server log for details");
			}
			out.println("well, i finished");
			//displayParams(out);
		}

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

	/**
	 * Convenience method to snag a parameter value.
	 * avoids null pointers
	 * 
	 * @param field
	 *            parameter name
	 * @return String value of parameter, or empty String if not found
	 */
	private String form(String field) {
		if (params.containsKey(field))
			return params.get(field)[0];
		else
			return null;
	}
	

	/**
	 * @return RegForm object with values set from request params
	 */
	private RegForm compileRegForm() {
		RegForm form=new RegForm();
		form.setFirstName(form("pfname"));
		form.setLastName(form("plname"));
		//form.setAddress(new PostalAddress(form(field)));
		form.setHomeNumber(new PhoneNumber(form("phphone")));
		form.setCellNumber(new PhoneNumber(form("pcphone")));
		return form;
	}

	/**
	 * @param form
	 */
	private void persist(RegForm form) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(form);
        } finally {
            pm.close();
        }
	}

//	private void displayParams(PrintWriter out) {
//		// just display all the parameters received
//		Enumeration<String> parameterNames = params.getParameterNames();
//		while (parameterNames.hasMoreElements()) {
//			String paramName = parameterNames.nextElement();
//			out.println("<br><B>" + paramName + "</B>");
//			String[] paramValues = params.getParameterValues(paramName);
//			if (paramValues.length == 1) {
//				String paramValue = paramValues[0];
//				if (paramValue.length() == 0)
//					out.print("=<I>No Value</I>");
//				else
//					out.print("=" + paramValue);
//			} else {
//				out.println("<UL>");
//				for (int i = 0; i < paramValues.length; i++) {
//					out.println("<LI>" + paramValues[i]);
//				}
//				out.println("</UL>");
//			}
//		}
//	}

}
