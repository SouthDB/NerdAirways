package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AW_FLIGHT database table.
 * 
 */
@Entity
@Table(name="AW_FLIGHT")
@NamedQuery(name="AwFlight.findAll", query="SELECT a FROM AwFlight a")
public class AwFlight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	private Date arrival;

	private BigDecimal flightnr;

	private BigDecimal fromid;

	private BigDecimal price;

	private BigDecimal statid;

	@Temporal(TemporalType.DATE)
	private Date takeoff;

	private BigDecimal toid;

	public AwFlight() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getArrival() {
		return this.arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public BigDecimal getFlightnr() {
		return this.flightnr;
	}

	public void setFlightnr(BigDecimal flightnr) {
		this.flightnr = flightnr;
	}

	public BigDecimal getFromid() {
		return this.fromid;
	}

	public void setFromid(BigDecimal fromid) {
		this.fromid = fromid;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getStatid() {
		return this.statid;
	}

	public void setStatid(BigDecimal statid) {
		this.statid = statid;
	}

	public Date getTakeoff() {
		return this.takeoff;
	}

	public void setTakeoff(Date takeoff) {
		this.takeoff = takeoff;
	}

	public BigDecimal getToid() {
		return this.toid;
	}

	public void setToid(BigDecimal toid) {
		this.toid = toid;
	}
	
	/*
	public String toString () {
		return "{\"id\":\"" + this.getId() + 
		"\",\"flightnr\":\"" + this.getFlightnr() +
		"\",\"fromid\":\"" + "[" + this.getFromid() + "]" +
		"\",\"toid\":\"" + "[" + this.getToid() + "]" +
		"\",\"statid\":\"" + "[" + this.getStatid() + "]" +
		"\",\"headline\":\"" + this.getHeadline() + 
		"\",\"imgpath\":\"" + this.getImgpath() +  
		"\"}";
	}
	*/

}