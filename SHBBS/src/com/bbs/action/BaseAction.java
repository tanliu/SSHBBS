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
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�BaseAction 
 * ��������Action�ײ��࣬ʵ��������ģ�ӿںʹ�����request��response
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����9:14:47
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����9:14:47
 * �޸ı�ע�� 
 * @version 
 */ 
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>,ServletRequestAware,ServletResponseAware {

	protected T entity;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public BaseAction(){
        //ͨ�����䴴�����͵�ʵ��
		Class entityclass = (Class) TUtils.getActualType(this.getClass());
		try {
			//ͨ�����䴴�����͵�ʵ��
			entity =(T) entityclass.newInstance();
		} catch (Exception e) {
			System.out.println("����ת����ʱ�����");
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
