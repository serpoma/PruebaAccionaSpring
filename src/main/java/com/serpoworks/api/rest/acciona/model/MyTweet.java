package com.serpoworks.api.rest.acciona.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyTweet implements Serializable {
	
	private static final long serialVersionUID = 4894729030347835498L;
	
	@Id
	private String id;
	private String username;
	@Column(columnDefinition="varchar(300)")
	private String text;
	private String lang;
	private boolean isValidated = false;	
	private String hashTags="";
	
	
	public MyTweet() {
	}

	public MyTweet(String id, String username, String text, String lang, boolean isValidated, String hashTags) {
		this.id = id;
		this.username = username;
		this.text = text;
		this.lang = lang;
		this.isValidated = isValidated;
		this.hashTags = hashTags;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public boolean isValidated() {
		return isValidated;
	}
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public String getHashTags() {
		return hashTags;
	}

	public void setHashTags(String hashTags) {
		this.hashTags = hashTags;
	}
	
	
	

}
