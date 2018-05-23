package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AW_CUSTOMER database table.
 * 
 */
@Entity
@Table(name="AW_CUSTOMER")
@NamedQuery(name="AwCustomer.findAll", query="SELECT a FROM AwCustomer a")
public class AwCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String adress;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private java.math.BigDecimal counid;

	private java.math.BigDecimal credid;

	private String email;

	private String fname;

	private String gender;

	private String place;

	private String plz;

	private String pw;

	private String sname;

	private String username;

	public AwCustomer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public java.math.BigDecimal getCounid() {
		return this.counid;
	}

	public void setCounid(java.math.BigDecimal counid) {
		this.counid = counid;
	}

	public java.math.BigDecimal getCredid() {
		return this.credid;
	}

	public void setCredid(java.math.BigDecimal credid) {
		this.credid = credid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlz() {
		return this.plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getPw() {
		return this.pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}