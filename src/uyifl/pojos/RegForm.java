package uyifl.pojos;

import java.util.Date;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PhoneNumber;

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
	@Persistent
	private Email email;
	@Persistent
	private Date birthDate;
	@Persistent
	private String shirtSize;
	@Persistent
	private String pantSize;
	@Persistent
	private int weight;
	@Persistent
	private String emergencyName;
	@Persistent
	private PhoneNumber ePhone1;
	@Persistent
	private PhoneNumber ePhone2;
	@Persistent
	private String eRelation;
	@Persistent
	private String gFirstName;
	@Persistent
	private String gLastName;
	
	@Persistent
	@Embedded
	private PostalAddress gAddress;
	
	@Persistent
	private PhoneNumber gHomeNumber;
	@Persistent
	private PhoneNumber gCellPhone;
	@Persistent
	private Email pEmail;
	@Persistent
	private String Coach;
	@Persistent
	private String teamName;

	// EMBEDDED CLASS
	@PersistenceCapable
    @EmbeddedOnly
    public static class PostalAddress {
        @Persistent
        private String address1;
        @Persistent
        private String address2;
        @Persistent
        private String city;
        @Persistent
        private String state;
        @Persistent
        private String zipCode;
        
        public String toString() {
        	return address1+", "+address2+", "+city+", "+state+", "+zipCode;
        }
        
		public String getAddress1() {
			return address1;
		}
		public String getAddress2() {
			return address2;
		}
		public String getCity() {
			return city;
		}
		public String getState() {
			return state;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public void setState(String state) {
			this.state = state;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
        
    }
	
	
	
	// /////////////////////////////////
	// // GETTERS AND SETTERS BELOW

	public String toString() {
		String addy = (address == null) ? "<NULL>" : address.toString();
		return "(" + key.toString() + ") " + lastName + ", " + firstName
				+ " - " + addy + " - " + homeNumber.getNumber() + " & "
				+ cellNumber.getNumber();
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PostalAddress getAddress() {
		return address;
	}

	public void setAddress(PostalAddress address) {
		this.address = address;
	}

	public PhoneNumber getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(PhoneNumber homeNumber) {
		this.homeNumber = homeNumber;
	}

	public PhoneNumber getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(PhoneNumber cellNumber) {
		this.cellNumber = cellNumber;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getShirtSize() {
		return shirtSize;
	}

	public void setShirtSize(String shirtSize) {
		this.shirtSize = shirtSize;
	}

	public String getPantSize() {
		return pantSize;
	}

	public void setPantSize(String pantSize) {
		this.pantSize = pantSize;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public PhoneNumber getePhone1() {
		return ePhone1;
	}

	public void setePhone1(PhoneNumber ePhone1) {
		this.ePhone1 = ePhone1;
	}

	public PhoneNumber getePhone2() {
		return ePhone2;
	}

	public void setePhone2(PhoneNumber ePhone2) {
		this.ePhone2 = ePhone2;
	}

	public String geteRelation() {
		return eRelation;
	}

	public void seteRelation(String eRelation) {
		this.eRelation = eRelation;
	}

	public String getgFirstName() {
		return gFirstName;
	}

	public void setgFirstName(String gFirstName) {
		this.gFirstName = gFirstName;
	}

	public String getgLastName() {
		return gLastName;
	}

	public void setgLastName(String gLastName) {
		this.gLastName = gLastName;
	}

	public PostalAddress getgAddress() {
		return gAddress;
	}

	public void setgAddress(PostalAddress gAddress) {
		this.gAddress = gAddress;
	}

	public PhoneNumber getgHomeNumber() {
		return gHomeNumber;
	}

	public void setgHomeNumber(PhoneNumber gHomeNumber) {
		this.gHomeNumber = gHomeNumber;
	}

	public PhoneNumber getgCellPhone() {
		return gCellPhone;
	}

	public void setgCellPhone(PhoneNumber gCellPhone) {
		this.gCellPhone = gCellPhone;
	}

	public Email getpEmail() {
		return pEmail;
	}

	public void setpEmail(Email pEmail) {
		this.pEmail = pEmail;
	}

	public String getCoach() {
		return Coach;
	}

	public void setCoach(String coach) {
		Coach = coach;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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
