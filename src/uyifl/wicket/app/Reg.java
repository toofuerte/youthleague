package uyifl.wicket.app;

import javax.jdo.PersistenceManager;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import uyifl.utils.PMF;
import uyifl.wicket.pojos.Registration;

public class Reg extends AppTemplate {

	private Registration registration = new Registration();
	private PersistenceManager pm = PMF.get().getPersistenceManager();

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 */
	public Reg() {
		super();

		final Form form = new Form<Registration>("registrationForm",
				new CompoundPropertyModel<Registration>(registration)) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -1099659001729777812L;

			protected void onSubmit() {
				// write to db?
				pm.makePersistent(registration);

				// setResponsePage
				setResponsePage(new RegThanks(registration.getPfname() + " "
						+ registration.getPlname()));
			}

		};
		//Player fields
		// add all fields
		form.add(new TextField<String>("pfname"));
		form.add(new TextField<String>("plname"));
		form.add(new TextField<String>("padd1"));
		form.add(new TextField<String>("padd2"));
		form.add(new TextField<String>("pcity"));
		// form.add(new DropDownChoice<String>("pstate"));
		form.add(new TextField<String>("pzip"));
		form.add(new TextField<String>("phphone"));
		form.add(new TextField<String>("pcphone"));
		form.add(new TextField<String>("pemail"));

		form.add(new TextField<String>("pbirth"));
		form.add(new TextField<String>("ssize"));
		form.add(new TextField<String>("psize"));
		form.add(new TextField<String>("pweight"));
		form.add(new TextField<String>("livew"));
		
		// Coach and team info
		form.add(new TextField<String>("cname"));
		form.add(new TextField<String>("tmname"));
		
		
		
		// Add registration form
		add(form);

	}

}
