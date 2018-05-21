package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AW_TERMINAL database table.
 * 
 */
@Entity
@Table(name="AW_TERMINAL")
@NamedQuery(name="AwTerminal.findAll", query="SELECT a FROM AwTerminal a")
public class AwTerminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String place;

	public AwTerminal() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}