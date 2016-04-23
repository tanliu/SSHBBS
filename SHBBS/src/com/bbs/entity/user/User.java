/**
 * 
 */
package com.bbs.entity.user;

import java.util.Date;
import java.util.UUID;

/** 
 * 项目名称：BBS
 * 类名称：User 
 * 类描述： 用户的实体类
 * 创建人：坛子
 * 创建时间：2016年3月31日 上午12:08:38
 * 修改人：TanLiu 
 * 修改时间：2016年3月31日 上午12:08:38
 * 修改备注： 
 * @version 
 */
public class User {
	private String id;
	private String password;
	private String username;
	private int level;
	private String email;
	private Date time;
	private int privilige;
	
	

	public User(){
		id=UUID.randomUUID().toString().replace("-", "");//用UUID生成唯一标识
	}
	
	//-------------------------------getter&&setter---------------------------
	
	public int getPrivilige() {
		return privilige;
	}

	public void setPrivilige(int privilige) {
		this.privilige = privilige;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
	


	
	
	
}
