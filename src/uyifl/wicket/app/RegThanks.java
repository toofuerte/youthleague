package uyifl.wicket.app;

import org.apache.wicket.markup.html.basic.Label;

public class RegThanks extends AppTemplate {
	
	public RegThanks(String name) {
		super();
		add(new Label("player_name", name));
		
	}

}
