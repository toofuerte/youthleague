package uyifl.wicket.admin;

import org.apache.wicket.markup.html.basic.Label;

import uyifl.wicket.pojos.Registration;

public class ViewRegistration extends AdminTemplate {

	public ViewRegistration(Registration record) {
		
		add(new Label("pfname", record.getPfname()));
		add(new Label("plname", record.getPlname()));
		
		add(new Label("pbirth", record.getPbirth()));
		
		add(new Label("padd1", record.getPadd1()));
		add(new Label("padd2", record.getPadd2()));
		add(new Label("pcity", record.getPcity()));
		
		add(new Label("phphone", record.getPhphone()));
		add(new Label("pcphone", record.getPcphone()));
		add(new Label("pemail", record.getPemail()));
		
		add(new Label("ssize", record.getSsize()));
		add(new Label("psize", record.getPsize()));
		add(new Label("pweight", record.getPweight()));
		
		add(new Label("cname", record.getCname()));
		add(new Label("tmname", record.getTmname()));
		
	}
	
	

}
