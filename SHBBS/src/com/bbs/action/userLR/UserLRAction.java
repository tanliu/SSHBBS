package com.bbs.action.userLR;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.bbs.action.BaseAction;

import com.bbs.entity.user.User1;

import com.bbs.services.userLR.UserLRServices;
import com.bbs.services.userLR.Impl.UserLRServicesImpl;



public class UserLRAction extends BaseAction<User1>{
    User1 user=this.getModel();
    UserLRServices ULRS=new UserLRServicesImpl();
    
	/**
	 * 方法描述:注册跳转
	 * @return
	 */
	public String registerresult(){
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
         user.setLevel(0);
 		 user.setTime(time);
    	if(!user.getUsername().equals("") && !user.getPassword().equals("") && !user.getEmail().equals("")){
    		ULRS.checkregister(user);
    	return "success";
    }else
    	return "register";
    }
	
	
	/**
	 * 方法描述:登录跳转
	 * @return
	 */
	public String loginresult(){
		//user=ULRS.checklogin(id);
		User1 entityuser=ULRS.checklogin(user.getUsername(),user.getPassword());
		while(entityuser!=null){
		if(user.getUsername().equals(entityuser.getUsername()) && user.getPassword().equals(entityuser.getPassword())){
			HttpSession session=request.getSession();
			session.setAttribute("Userinformation",entityuser);
			return "success";
			}
		}
		return "login";
	}
}
