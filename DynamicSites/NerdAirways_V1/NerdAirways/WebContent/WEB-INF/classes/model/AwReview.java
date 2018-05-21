package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the AW_REVIEW database table.
 * 
 */
@Entity
@Table(name="AW_REVIEW")
@NamedQuery(name="AwReview.findAll", query="SELECT a FROM AwReview a")
public class AwReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal bookid;

	private BigDecimal rating;

	private String text;

	private Timestamp timelog;

	public AwReview() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getBookid() {
		return this.bookid;
	}

	public void setBookid(BigDecimal bookid) {
		this.bookid = bookid;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getTimelog() {
		return this.timelog;
	}

	public void setTimelog(Timestamp timelog) {
		this.timelog = timelog;
	}

}