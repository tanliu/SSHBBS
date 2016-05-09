package com.bbs.entity.user;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * User1 entity. @author MyEclipse Persistence Tools
 */

public class User1 implements java.io.Serializable {

	// Fields

	private String id;
	private String password;
	private String username;
	private Integer level;
	private String email;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public User1() {
		
	}

	/** full constructor */
	public User1(String id, String password, String username, Integer level,
			String email, Timestamp time) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.level = level;
		this.email = email;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTime() {
		return this.time;
	}
	
	public void setTime(Timestamp time) {
		this.time = time;
	}

}