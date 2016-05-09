package com.bbs.action.managerblog;



import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.bbs.action.ManagerAction;
import com.bbs.entity.blog.Blog;
import com.bbs.services.managerblog.ManagerBlogServices;
import com.bbs.utils.QueryUtils;

/** 
 * 项目名称：SHBBS
 * 类名称：ManagerBlogAction 
 * 类描述： 
 * 创建人：坛子
 * 创建时间：2016年4月24日 下午7:54:56
 * 修改人：TanLiu 
 * 修改时间：2016年4月24日 下午7:54:56
 * 修改备注： 
 * @version 
 */ 
public class ManagerBlogAction extends ManagerAction<Blog> {
	
	Blog blog=this.getModel();
	@Resource(name=ManagerBlogServices.SERVICE_NAME)
	ManagerBlogServices mBlogServices;	
	private String[] blogIds;
	
	public String[] getBlogIds() {
		return blogIds;
	}

	public void setBlogIds(String[] blogIds) {
		this.blogIds = blogIds;
	}



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
