package com.bbs.entity.blog;

import java.util.Date;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private String id;
	private String useId;
	private String title;
	private String content;
	private Date time;

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** full constructor */
	public Blog(String useId, String title, String content, Date time) {
		this.useId = useId;
		this.title = title;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUseId() {
		return this.useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}