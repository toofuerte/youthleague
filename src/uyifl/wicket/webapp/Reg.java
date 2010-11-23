package uyifl.wicket.webapp;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.util.value.ValueMap;
import org.apache.wicket.model.CompoundPropertyModel;
import uyifl.wicket.pojos.Registration;

public class Reg extends Template {

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 */
	public Reg() {
		super();
		// Add registration form
		add(new RegistrationForm("registrationForm"));

		// Add commentListView of existing comments
//		add(new PropertyListView<Comment>("comments", commentList) {
//			@Override
//			public void populateItem(final ListItem<Comment> listItem) {
//				listItem.add(new Label("date"));
//				listItem.add(new MultiLineLabel("text"));
//			}
//		}).setVersioned(false);
	}

	/**
	 * A form that allows a user to add a registration.
	 */
	public final class RegistrationForm extends Form<ValueMap> {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2602575739891684526L;

		public RegistrationForm(final String id) {
			// Construct form with no validation listener
			super(id, new CompoundPropertyModel<ValueMap>(new ValueMap()));

			// this is just to make the unit test happy
			setMarkupId("registrationForm");

			// Add text entry widget
			add(new TextArea<String>("text").setType(String.class));

			// Add simple automated spam prevention measure.
			add(new TextField<String>("prevention").setType(String.class));
		}

		/**
		 * Show the resulting valid edit
		 */
		@Override
		public final void onSubmit() {
			ValueMap values = getModelObject();

			// check if the honey pot is filled
			if (StringUtils.isNotBlank((String) values.get("prevention"))) {
				error("Caught a spammer!!!");
				return;
			}
			// Construct a copy of the edited registration
			Registration registration = new Registration();

			// Set date of registration to add
			registration.setDate(new Date());
			registration.setText((String) values.get("text"));
			//commentList.add(0, comment);
			//write to db? ...

			// Clear out the text component
			values.put("text", "");
		}
	}

	/**
	 * Clears the comments.
	 */
	public static void clear() {
		commentList.clear();
	}

}
