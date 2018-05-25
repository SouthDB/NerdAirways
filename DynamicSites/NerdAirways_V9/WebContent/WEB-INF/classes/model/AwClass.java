package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AW_CLASS database table.
 * 
 */
@Entity
@Table(name="AW_CLASS")
@NamedQuery(name="AwClass.findAll", query="SELECT a FROM AwClass a")
public class AwClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="\"CLASS\"")
	private String class_;

	private BigDecimal price;

	public AwClass() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}