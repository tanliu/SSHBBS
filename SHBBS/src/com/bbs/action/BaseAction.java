package com.bbs.action;

import java.lang.reflect.ParameterizedType;







import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bbs.utils.TUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/** 
 * 项目名称：SHBBSf
 * 类名称：BaseAction 
 * 类描述：Action底层类，实现了驱动模接口和创建了request和response
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午9:14:47
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午9:14:47
 * 修改备注： 
 * @version 
 */ 
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware {

	protected T entity;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public BaseAction(){
        //通过反射创建泛型的实例
		Class entityclass = (Class) TUtils.getActualType(this.getClass());
		try {
			//通过反射创建泛型的实例
			entity =(T) entityclass.newInstance();
		} catch (Exception e) {
			System.out.println("泛型转换的时候出错！");
			e.printStackTrace();
		} 
	}	
	public T getModel() {
		return entity;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	
	
	
	

}
