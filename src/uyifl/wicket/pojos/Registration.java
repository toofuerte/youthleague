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
	private static long serialVersionUID = 523560842407933283L;

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
	
	private String gfname1;
	@Persistent
	private String glname1;
	@Persistent
	private String gadd11;
	@Persistent
	private String gadd21;
	@Persistent
	private String gcity1;
	@Persistent
	private String gzip1;
	@Persistent
	private String ghphone1;
	@Persistent
	private String gcphone1;
	@Persistent
	private String gemail1;
	
	@Persistent
	private String livew;
	
	
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(final long serialVersionUID) {
		Registration.serialVersionUID = serialVersionUID;
	}
	public Key getKey() {
		return key;
	}
	public void setKey(final Key key) {
		this.key = key;
	}
	public String getPfname() {
		return pfname;
	}
	public void setPfname(final String pfname) {
		this.pfname = pfname;
	}
	public String getPlname() {
		return plname;
	}
	public void setPlname(final String plname) {
		this.plname = plname;
	}
	public String getPadd1() {
		return padd1;
	}
	public void setPadd1(final String padd1) {
		this.padd1 = padd1;
	}
	public String getPadd2() {
		return padd2;
	}
	public void setPadd2(final String padd2) {
		this.padd2 = padd2;
	}
	public String getPcity() {
		return pcity;
	}
	public void setPcity(final String pcity) {
		this.pcity = pcity;
	}
	public String getPzip() {
		return pzip;
	}
	public void setPzip(final String pzip) {
		this.pzip = pzip;
	}
	public String getPhphone() {
		return phphone;
	}
	public void setPhphone(final String phphone) {
		this.phphone = phphone;
	}
	public String getPcphone() {
		return pcphone;
	}
	public void setPcphone(final String pcphone) {
		this.pcphone = pcphone;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(final String pemail) {
		this.pemail = pemail;
	}
	public String getPbirth() {
		return pbirth;
	}
	public void setPbirth(final String pbirth) {
		this.pbirth = pbirth;
	}
	public String getSsize() {
		return ssize;
	}
	public void setSsize(final String ssize) {
		this.ssize = ssize;
	}
	public String getPsize() {
		return psize;
	}
	public void setPsize(final String psize) {
		this.psize = psize;
	}
	public String getPweight() {
		return pweight;
	}
	public void setPweight(final String pweight) {
		this.pweight = pweight;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(final String cname) {
		this.cname = cname;
	}
	public String getTmname() {
		return tmname;
	}
	public void setTmname(final String tmname) {
		this.tmname = tmname;
	}
	public String getGfname1() {
		return gfname1;
	}
	public void setGfname1(final String gfname1) {
		this.gfname1 = gfname1;
	}
	public String getGlname1() {
		return glname1;
	}
	public void setGlname1(final String glname1) {
		this.glname1 = glname1;
	}
	public String getGadd11() {
		return gadd11;
	}
	public void setGadd11(final String gadd11) {
		this.gadd11 = gadd11;
	}
	public String getGadd21() {
		return gadd21;
	}
	public void setGadd21(final String gadd21) {
		this.gadd21 = gadd21;
	}
	public String getGcity1() {
		return gcity1;
	}
	public void setGcity1(final String gcity1) {
		this.gcity1 = gcity1;
	}
	public String getGzip1() {
		return gzip1;
	}
	public void setGzip1(final String gzip1) {
		this.gzip1 = gzip1;
	}
	public String getGhphone1() {
		return ghphone1;
	}
	public void setGhphone1(final String ghphone1) {
		this.ghphone1 = ghphone1;
	}
	public String getGcphone1() {
		return gcphone1;
	}
	public void setGcphone1(final String gcphone1) {
		this.gcphone1 = gcphone1;
	}
	public String getGemail1() {
		return gemail1;
	}
	public void setGemail1(final String gemail1) {
		this.gemail1 = gemail1;
	}
	public String getLivew() {
		return livew;
	}
	public void setLivew(final String livew) {
		this.livew = livew;
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
