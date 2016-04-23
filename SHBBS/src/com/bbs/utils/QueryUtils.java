package com.bbs.utils;

import java.util.ArrayList;

import antlr.collections.List;


/** 
 * 项目名称：SHBBSf
 * 类名称：QueryUtils 
 * 类描述： 查询工具
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午10:04:28
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午10:04:28
 * 修改备注： 
 * @version 
 */ 
public class QueryUtils {
	
	//from句子
	private String fromClause="";
	//where句子
	private String whereClause="WHERE 1=1";
	//orderby句子
	private String orderbyClause="";
	
	private java.util.List<Object> parameters;
	//orderby的方式
	private static String ORDER_DESC="DESC";
	private static String ORDER_ASC="ASC";
	
	
	
	
	/**
	 * 用构造函数来创建from语句
	 * @param clazz 实体类
	 * @param alias 实体类的别名
	 */
	public QueryUtils(Class clazz,String alias){
		fromClause="FROM "+clazz.getSimpleName()+" "+alias;			
	}
	
	
	/**
	 * 拼接where语句
	 * @param condition 查询条件语句；例如：i.title like ?
	 * @param params  查询条件语句中?对应的查询条件值；例如： %标题%  
	 */
	public void addCondition(String condition,Object... params){
		//拼接
		whereClause+=" AND "+condition;
		if(parameters==null){
			parameters=new ArrayList<Object>();
		}
		//记录属性
		if(params!=null){
			for(Object param: params){
				parameters.add(param);
			}
		}

	}
	
	/**
	 * 拼接orderby的句子
	 * @param property 参数
	 * @param order 排序方式 
	 */
	public void addOderbyByProperty(String property,String order){
		if(orderbyClause.length()>1){
			orderbyClause+=" "+property+" "+order;
		}else{//每一次创建 的时候。
			orderbyClause=" ORDER BY "+property+" "+order;
		}
	}
	
	/**
	 * 获取查询的hql语句
	 * @return
	 */
	public String getQueryHql(){
		return fromClause+" "+whereClause+" "+orderbyClause;
	}
	

	/**
	 * 获取查询数目的hql语句
	 * @return
	 */
	public String getQueryCountHql(){
		return "SELECT COUNT(*) "+fromClause+" "+whereClause;
	}
	
	/**
	 * 获取语句？的参数
	 * @return
	 */
	public java.util.List<Object> getParams(){
		return parameters;
	}
	
}
