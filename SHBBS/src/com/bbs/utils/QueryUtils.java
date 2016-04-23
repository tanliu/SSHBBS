package com.bbs.utils;

import java.util.ArrayList;

import antlr.collections.List;


/** 
 * ��Ŀ���ƣ�SHBBSf
 * �����ƣ�QueryUtils 
 * �������� ��ѯ����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:04:28
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:04:28
 * �޸ı�ע�� 
 * @version 
 */ 
public class QueryUtils {
	
	//from����
	private String fromClause="";
	//where����
	private String whereClause="WHERE 1=1";
	//orderby����
	private String orderbyClause="";
	
	private java.util.List<Object> parameters;
	//orderby�ķ�ʽ
	private static String ORDER_DESC="DESC";
	private static String ORDER_ASC="ASC";
	
	
	
	
	/**
	 * �ù��캯��������from���
	 * @param clazz ʵ����
	 * @param alias ʵ����ı���
	 */
	public QueryUtils(Class clazz,String alias){
		fromClause="FROM "+clazz.getSimpleName()+" "+alias;			
	}
	
	
	/**
	 * ƴ��where���
	 * @param condition ��ѯ������䣻���磺i.title like ?
	 * @param params  ��ѯ���������?��Ӧ�Ĳ�ѯ����ֵ�����磺 %����%  
	 */
	public void addCondition(String condition,Object... params){
		//ƴ��
		whereClause+=" AND "+condition;
		if(parameters==null){
			parameters=new ArrayList<Object>();
		}
		//��¼����
		if(params!=null){
			for(Object param: params){
				parameters.add(param);
			}
		}

	}
	
	/**
	 * ƴ��orderby�ľ���
	 * @param property ����
	 * @param order ����ʽ 
	 */
	public void addOderbyByProperty(String property,String order){
		if(orderbyClause.length()>1){
			orderbyClause+=" "+property+" "+order;
		}else{//ÿһ�δ��� ��ʱ��
			orderbyClause=" ORDER BY "+property+" "+order;
		}
	}
	
	/**
	 * ��ȡ��ѯ��hql���
	 * @return
	 */
	public String getQueryHql(){
		return fromClause+" "+whereClause+" "+orderbyClause;
	}
	

	/**
	 * ��ȡ��ѯ��Ŀ��hql���
	 * @return
	 */
	public String getQueryCountHql(){
		return "SELECT COUNT(*) "+fromClause+" "+whereClause;
	}
	
	/**
	 * ��ȡ��䣿�Ĳ���
	 * @return
	 */
	public java.util.List<Object> getParams(){
		return parameters;
	}
	
}
