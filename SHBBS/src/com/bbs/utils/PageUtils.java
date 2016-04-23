package com.bbs.utils;

import java.util.ArrayList;
import java.util.List;



/** 
 * 项目名称：BBS
 * 类名称：PageUtils 
 * 类描述： 分页查找的工具类
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午10:05:12
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午10:05:12
 * 修改备注： 
 * @version 
 */ 
public class PageUtils<T> {
	private int currentPage=1;   //当前页码
	private int pageSize=4;      //每一页显示条目的数量
	private long totalCount;      //总共有多少数据
	private int totalPage;       //一共有多少页
	private List<T> pageData;    //要查询页的数据
	
	
	public PageUtils(long totalCount, int pageNO, int pageSize, List items) {
		pageData=items==null?new ArrayList():items;
		this.totalCount=totalCount;
		currentPage=pageNO;
		this.pageSize=pageSize;
	}
	//-------------------------getter&&setter-------------------------	
	public int getTotalPage() {
		if(totalCount!=0&&pageSize!=0){
			totalPage=(int) ((totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1)); //计算总页数
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
