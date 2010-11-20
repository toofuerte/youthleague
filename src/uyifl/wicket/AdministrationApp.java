package uyifl.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.HttpSessionStore;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.session.ISessionStore;

import uyifl.wicket.admin.db1;

public class AdministrationApp extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return db1.class;
	}

	@Override
	protected void init() {
		super.init();
		// also, following line for wicket to work
		getResourceSettings().setResourcePollFrequency(null);
	}

	@Override
	protected ISessionStore newSessionStore() {
		// return new SecondLevelCacheSessionStore(this, new DiskPageStore());
		return new HttpSessionStore(this);
	}

}
