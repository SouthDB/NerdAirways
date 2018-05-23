package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AW_CREDITCARD database table.
 * 
 */
@Entity
@Table(name="AW_CREDITCARD")
@NamedQuery(name="AwCreditcard.findAll", query="SELECT a FROM AwCreditcard a")
public class AwCreditcard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String cardnr;

	private String cardtype;

	private String holder;

	public AwCreditcard() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardnr() {
		return this.cardnr;
	}

	public void setCardnr(String cardnr) {
		this.cardnr = cardnr;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getHolder() {
		return this.holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

}