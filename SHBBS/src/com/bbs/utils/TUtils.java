package com.bbs.utils;

import java.lang.reflect.ParameterizedType;

/** 
 * 项目名称：Electricity
 * 类名称：TUtils 
 * 类描述： 泛型的转接
 * 创建人：坛子
 * 创建时间：2016年3月27日 下午5:13:29
 * 修改人：TanLiu 
 * 修改时间：2016年3月27日 下午5:13:29
 * 修改备注： 
 * @version 
 */ 
public class TUtils {

	public static Class getActualType(Class entity) {
		ParameterizedType parameterizedType =  (ParameterizedType) entity.getGenericSuperclass();
		Class entityclass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityclass;
	}
	
	

}
