package com.bbs.action;

import com.bbs.utils.PageUtils;

/** 
 * 项目名称：SHBBSf
 * 类名称：ManagerAction 
 * 类描述： 针对信息的维护创建的一个Action层的抽象 类
 * 创建人：坛子
 * 创建时间：2016年4月23日 下午9:17:58
 * 修改人：TanLiu 
 * 修改时间：2016年4月23日 下午9:17:58
 * 修改备注： 
 * @version 
 */ 
public abstract class ManagerAction<T> extends BaseAction<T> {
	
	protected PageUtils<T> pageUtils;//分页工具
	protected int currentPage;
	protected int pageSize;

	
	

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 方法描述:进行列表
	 * @return
	 */
	public abstract String listUI();
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 方法描述:删除信息
	 * @return
	 */
	public abstract String delete();
	/**
	 * 方法描述:进行编辑界面
	 * @return
	 */
	public abstract String editorUI();
	/**
	 * 方法描述:提交编辑后的信息
	 * @return
	 */
	public abstract String editor();
	/**
	 * 方法描述:删除所有信息
	 * @return
	 */
	public abstract String deleteAll();
	/**
	 * 方法描述:进行添加界面
	 * @return
	 */
	public abstract String addUI();
	/**
	 * 方法描述:提交添加后的信息
	 * @return
	 */
	public abstract String add();
}
