package com.bbs.entity.blog;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private String id;
	private String pubId;
	private String useId;
	private String content;
	private Date time;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(String id, String pubId, String useId, String content,
			Timestamp time) {
		this.id = id;
		this.pubId = pubId;
		this.useId = useId;
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

	public String getPubId() {
		return this.pubId;
	}

	public void setPubId(String pubId) {
		this.pubId = pubId;
	}

	public String getUseId() {
		return this.useId;
	}

	public void setUseId(String useId) {
		this.useId = useId;
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