/**
 * 
 */
package com.bbs.entity.blog;

import java.util.Date;
import java.util.UUID;

/** 
 * 项目名称：BBS
 * 类名称：Reply 
 * 类描述： 回帖的实体
 * 创建人：坛子
 * 创建时间：2016年3月31日 上午8:44:46
 * 修改人：TanLiu 
 * 修改时间：2016年3月31日 上午8:44:46
 * 修改备注： 
 * @version 
 */
public class Reply {

	private String id;
	private String pub_id;
	private String user_id;
	private String content;
	private Date time;
	private String Author;
	
	public Reply(){
		id=UUID.randomUUID().toString().replace("-", "");//用UUID生成唯一标识
	}
	
	//--------------------------------------getter&&setter-----------------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPub_id() {
		return pub_id;
	}
	public void setPub_id(String pub_id) {
		this.pub_id = pub_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	
}
