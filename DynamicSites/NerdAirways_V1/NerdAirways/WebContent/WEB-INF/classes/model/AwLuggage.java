package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AW_LUGGAGE database table.
 * 
 */
@Entity
@Table(name="AW_LUGGAGE")
@NamedQuery(name="AwLuggage.findAll", query="SELECT a FROM AwLuggage a")
public class AwLuggage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String mass;

	private BigDecimal price;

	public AwLuggage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMass() {
		return this.mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}