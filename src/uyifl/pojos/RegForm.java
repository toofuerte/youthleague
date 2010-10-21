package uyifl.pojos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PhoneNumber;
import com.google.appengine.api.datastore.PostalAddress;

@PersistenceCapable
public class RegForm {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private PostalAddress address;
	@Persistent
	private PhoneNumber homeNumber;
	@Persistent
	private PhoneNumber cellNumber;

	// /////////////////////////////////
	// // GETTERS AND SETTERS BELOW

	public Key getKey() {
		return key;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public PostalAddress getAddress() {
		return address;
	}

	public PhoneNumber getHomeNumber() {
		return homeNumber;
	}

	public PhoneNumber getCellNumber() {
		return cellNumber;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(PostalAddress address) {
		this.address = address;
	}

	public void setHomeNumber(PhoneNumber homeNumber) {
		this.homeNumber = homeNumber;
	}

	public void setCellNumber(PhoneNumber cellNumber) {
		this.cellNumber = cellNumber;
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
