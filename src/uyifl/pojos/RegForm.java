package uyifl.pojos;

import com.google.appengine.api.datastore.PhoneNumber;
import com.google.appengine.api.datastore.PostalAddress;

public class RegForm {

	private String firstName;
	private String lastName;
	private PostalAddress address;
	private PhoneNumber homeNumber;
	private PhoneNumber cellNumber;
	
}

/*
 * The datastore supports the following core value types:
 * 
 * java.lang.String
 * com.google.appengine.api.datastore.ShortBlob
 * boolean
 * java.lang.Boolean
 * short
 * java.lang.Short
 * int
 * java.lang.Integer
 * long
 * java.lang.Long
 * float
 * java.lang.Float
 * double
 * java.lang.Double
 * java.util.Date
 * com.google.appengine.api.users.User
 * com.google.appengine.api.datastore.Text
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
