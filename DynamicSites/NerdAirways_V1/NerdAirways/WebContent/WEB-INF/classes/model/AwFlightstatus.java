package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AW_FLIGHTSTATUS database table.
 * 
 */
@Entity
@Table(name="AW_FLIGHTSTATUS")
@NamedQuery(name="AwFlightstatus.findAll", query="SELECT a FROM AwFlightstatus a")
public class AwFlightstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String statustext;

	public AwFlightstatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatustext() {
		return this.statustext;
	}

	public void setStatustext(String statustext) {
		this.statustext = statustext;
	}

	/*
	public String toString () {
		return "{\"id\":\"" + this.getId() + 
		"\",\"statustext\":\"" + this.getStatustext() + 
		"\"}";
	}
	*/

}