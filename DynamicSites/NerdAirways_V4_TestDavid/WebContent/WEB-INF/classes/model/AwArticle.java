package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AW_ARTICLE database table.
 * 
 */
@Entity
@Table(name="AW_ARTICLE")
@NamedQuery(name="AwArticle.findAll", query="SELECT a FROM AwArticle a")
public class AwArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String content;

	private String headline;

	private String imgpath;

	public AwArticle() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getImgpath() {
		return this.imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	public String toString () {
		return "{\"id\":\"" + this.getId() + 
		"\",\"content\":\"" + this.getContent() + 
		"\",\"headline\":\"" + this.getHeadline() + 
		"\",\"imgpath\":\"" + this.getImgpath() +  
		"\"}";
	}


}