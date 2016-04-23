package com.bbs.utils;

import java.util.ArrayList;
import java.util.List;



/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�PageUtils 
 * �������� ��ҳ���ҵĹ�����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��4��23�� ����10:05:12
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��4��23�� ����10:05:12
 * �޸ı�ע�� 
 * @version 
 */ 
public class PageUtils<T> {
	private int currentPage=1;   //��ǰҳ��
	private int pageSize=4;      //ÿһҳ��ʾ��Ŀ������
	private long totalCount;      //�ܹ��ж�������
	private int totalPage;       //һ���ж���ҳ
	private List<T> pageData;    //Ҫ��ѯҳ������
	
	
	public PageUtils(long totalCount, int pageNO, int pageSize, List items) {
		pageData=items==null?new ArrayList():items;
		this.totalCount=totalCount;
		currentPage=pageNO;
		this.pageSize=pageSize;
	}
	//-------------------------getter&&setter-------------------------	
	public int getTotalPage() {
		if(totalCount!=0&&pageSize!=0){
			totalPage=(int) ((totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1)); //������ҳ��
		}
		
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	
	

}
