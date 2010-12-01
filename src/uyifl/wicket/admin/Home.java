package uyifl.wicket.admin;

import java.util.List;

import javax.jdo.PersistenceManager;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import uyifl.utils.PMF;
import uyifl.wicket.pojos.Registration;

public class Home extends AdminTemplate {

	private PersistenceManager pm = PMF.get().getPersistenceManager();

	public Home() {

		List<Registration> list = (List<Registration>) pm.newQuery(
				"SELECT FROM " + Registration.class.getName()).execute();

		final DataView<Registration> dataView = new DataView<Registration>(
				"simple", new ListDataProvider<Registration>(list)) {

			private static final long serialVersionUID = 1503920385652317219L;

			public void populateItem(final Item<Registration> item) {
				final Registration regForm = item.getModelObject();
				item.add(new Label("pfname", regForm.getPfname()));
				item.add(new Label("plname", regForm.getPlname()));

				item.add(new Label("paddress", regForm.getPadd1() + ", "
						+ regForm.getPadd2() + ", " + regForm.getPcity()));
				item.add(new Label("team", regForm.getTmname()));

				item.add(new Link<Registration>("view_link") {

					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new ViewRegistration(regForm));
					}

				});
			}

		};

		dataView.setItemsPerPage(10);
		add(dataView);
		add(new PagingNavigator("navigator", dataView));
	}
}