package com.bbs.action.managerblog;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.bbs.action.ManagerAction;
import com.bbs.entity.blog.Blog;
import com.bbs.services.managerblog.ManagerBlogServices;
import com.bbs.services.managerblog.impl.ManagerBlogServicesImpl;
import com.bbs.utils.PageUtils;
import com.bbs.utils.QueryUtils;
import com.bbs.utils.TUtils;

public class ManagerBlogAction extends ManagerAction<Blog> {
	
	Blog blog=this.getModel();
	
	private String[] blogIds;
	
	
	
	public String[] getBlogIds() {
		return blogIds;
	}

	public void setBlogIds(String[] blogIds) {
		this.blogIds = blogIds;
	}

	ManagerBlogServices mBlogServices=new ManagerBlogServicesImpl();

	@Override
	public String listUI() {
		
		QueryUtils queryUtils=new QueryUtils(Blog.class, "b");
		if(blog!=null&&blog.getTitle()!=null&&!blog.getTitle().equals("")){
			queryUtils.addCondition("b.title like ?", "%"+blog.getTitle()+"%");
		}
		ServletActionContext.getContext().getValueStack().push(blog);
		pageUtils=mBlogServices.getPageResult(queryUtils, getCurrentPage(), 2);
		request.setAttribute("pagetUtils", pageUtils);
		return "listUI";
	}

	@Override
	public String delete() {
		mBlogServices.deleteObjectByIds(blog.getId());
		return "delete";
	}

	@Override
	public String editorUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAll() {
		for (String id : blogIds) {
			mBlogServices.deleteObjectByIds(id);
		}
		return "delete";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

}
