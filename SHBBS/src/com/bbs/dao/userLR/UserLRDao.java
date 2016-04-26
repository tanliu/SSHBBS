package com.bbs.dao.userLR;

import java.io.Serializable;
import java.util.Date;

import com.bbs.dao.BaseDao;
import com.bbs.entity.blog.Blog;

import com.bbs.entity.user.User1;

public interface UserLRDao extends BaseDao<User1>{
	
/**
 * ·½·¨ÃèÊö:µÇÂ¼
 * @param 
 */

	public User1 login(String username,String password);

/**
 * ·½·¨ÃèÊö:×¢²á
 * @param u
 */
public void register(User1 u);

}
