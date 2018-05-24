package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AW_COUNTRY database table.
 * 
 */
@Entity
@Table(name="AW_COUNTRY")
@NamedQuery(name="AwCountry.findAll", query="SELECT a FROM AwCountry a")
public class AwCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String country;

	public AwCountry() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString () {
		return "{\"id\":\"" + this.getId() + 
		"\",\"country\":\"" + this.getCountry() + 
		"\"}";
	}
}