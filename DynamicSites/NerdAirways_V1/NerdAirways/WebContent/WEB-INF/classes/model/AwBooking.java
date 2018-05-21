package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the AW_BOOKING database table.
 * 
 */
@Entity
@Table(name="AW_BOOKING")
@NamedQuery(name="AwBooking.findAll", query="SELECT a FROM AwBooking a")
public class AwBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal bookingnr;

	private String checkin;

	private BigDecimal clasid;

	private BigDecimal custid;

	private BigDecimal fligid;

	private BigDecimal laggid;

	private BigDecimal price;

	private Timestamp timelog;

	public AwBooking() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getBookingnr() {
		return this.bookingnr;
	}

	public void setBookingnr(BigDecimal bookingnr) {
		this.bookingnr = bookingnr;
	}

	public String getCheckin() {
		return this.checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public BigDecimal getClasid() {
		return this.clasid;
	}

	public void setClasid(BigDecimal clasid) {
		this.clasid = clasid;
	}

	public BigDecimal getCustid() {
		return this.custid;
	}

	public void setCustid(BigDecimal custid) {
		this.custid = custid;
	}

	public BigDecimal getFligid() {
		return this.fligid;
	}

	public void setFligid(BigDecimal fligid) {
		this.fligid = fligid;
	}

	public BigDecimal getLaggid() {
		return this.laggid;
	}

	public void setLaggid(BigDecimal laggid) {
		this.laggid = laggid;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Timestamp getTimelog() {
		return this.timelog;
	}

	public void setTimelog(Timestamp timelog) {
		this.timelog = timelog;
	}

}