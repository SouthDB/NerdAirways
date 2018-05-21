package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the X_TABLE1 database table.
 * 
 */
@Entity
@Table(name="X_TABLE1")
@NamedQuery(name="XTable1.findAll", query="SELECT x FROM XTable1 x")
public class XTable1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String atri1;

	private String atri2;

	private BigDecimal atri3;

	public XTable1() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAtri1() {
		return this.atri1;
	}

	public void setAtri1(String atri1) {
		this.atri1 = atri1;
	}

	public String getAtri2() {
		return this.atri2;
	}

	public void setAtri2(String atri2) {
		this.atri2 = atri2;
	}

	public BigDecimal getAtri3() {
		return this.atri3;
	}

	public void setAtri3(BigDecimal atri3) {
		this.atri3 = atri3;
	}
	
	public String toString () {
	return "{\"id\":\"" + getId() + "\",\"atri1\":\"" + getAtri1() + "\",\"atri2\":\"" + getAtri2() + "\",\"atri3\":\"" + getAtri3() +  "\"}";
	}


}