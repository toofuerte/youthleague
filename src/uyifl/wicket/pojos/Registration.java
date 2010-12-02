package uyifl.wicket.pojos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.apache.wicket.IClusterable;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Registration implements IClusterable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 523560842407933283L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String pfname;
	@Persistent
	private String plname;
	@Persistent
	private String padd1;
	@Persistent
	private String padd2;
	@Persistent
	private String pcity;
	@Persistent
	private String pzip;
	@Persistent
	private String phphone;
	@Persistent
	private String pcphone;
	@Persistent
	private String pemail;

	@Persistent
	private String pbirth;
	@Persistent
	private String ssize;
	@Persistent
	private String psize;
	@Persistent
	private String pweight;

	@Persistent
	private String cname;
	@Persistent
	private String tmname;

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getPfname() {
		return pfname;
	}

	public void setPfname(String pfname) {
		this.pfname = pfname;
	}

	public String getPlname() {
		return plname;
	}

	public void setPlname(String plname) {
		this.plname = plname;
	}

	public String getPadd1() {
		return padd1;
	}

	public void setPadd1(String padd1) {
		this.padd1 = padd1;
	}

	public String getPadd2() {
		return padd2;
	}

	public void setPadd2(String padd2) {
		this.padd2 = padd2;
	}

	public String getPcity() {
		return pcity;
	}

	public void setPcity(String pcity) {
		this.pcity = pcity;
	}

	public String getPzip() {
		return pzip;
	}

	public void setPzip(String pzip) {
		this.pzip = pzip;
	}

	public String getPhphone() {
		return phphone;
	}

	public void setPhphone(String phphone) {
		this.phphone = phphone;
	}

	public String getPcphone() {
		return pcphone;
	}

	public void setPcphone(String pcphone) {
		this.pcphone = pcphone;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public String getPbirth() {
		return pbirth;
	}

	public void setPbirth(String pbirth) {
		this.pbirth = pbirth;
	}

	public String getSsize() {
		return ssize;
	}

	public void setSsize(String ssize) {
		this.ssize = ssize;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public String getPweight() {
		return pweight;
	}

	public void setPweight(String pweight) {
		this.pweight = pweight;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}

}

/*
 * The datastore supports the following core value types:
 * 
 * java.lang.String com.google.appengine.api.datastore.ShortBlob boolean
 * java.lang.Boolean short java.lang.Short int java.lang.Integer long
 * java.lang.Long float java.lang.Float double java.lang.Double java.util.Date
 * com.google.appengine.api.users.User com.google.appengine.api.datastore.Text
 * com.google.appengine.api.datastore.Blob
 * com.google.appengine.api.datastore.Key
 * com.google.appengine.api.datastore.Category
 * com.google.appengine.api.datastore.Email
 * com.google.appengine.api.datastore.GeoPt
 * com.google.appengine.api.datastore.IMHandle
 * com.google.appengine.api.datastore.Link
 * com.google.appengine.api.datastore.PhoneNumber
 * com.google.appengine.api.datastore.PostalAddress
 * com.google.appengine.api.datastore.Rating
 */
