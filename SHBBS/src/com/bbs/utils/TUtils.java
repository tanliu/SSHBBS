package com.bbs.utils;

import java.lang.reflect.ParameterizedType;

/** 
 * ��Ŀ���ƣ�Electricity
 * �����ƣ�TUtils 
 * �������� ���͵�ת��
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��27�� ����5:13:29
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��27�� ����5:13:29
 * �޸ı�ע�� 
 * @version 
 */ 
public class TUtils {

	public static Class getActualType(Class entity) {
		ParameterizedType parameterizedType =  (ParameterizedType) entity.getGenericSuperclass();
		Class entityclass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityclass;
	}
	
	

}
