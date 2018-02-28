package com.san.crm.post.web.action;

import java.io.IOException;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.san.crm.post.domain.CrmPost;
import com.san.crm.post.service.PostService;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost>{
	private static final long serialVersionUID = 1L;
	CrmPost crmPost=new CrmPost();
	public CrmPost getModel() {
		return crmPost;
	}
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	/**
	 * ajax通过指定部门查询所有职务
	 * @return
	 * @throws IOException 
	 */
	public String findAllWithDepartment() throws IOException{
		List<CrmPost> allPost =postService.findAll(crmPost.getDepartment());
		//(排查不需要的数据,解决死循环)
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		//将Java对象转化为json数据
		String jsonData=JSONArray.fromObject(allPost,jsonConfig).toString();
		
		//将json数据发送给浏览器
		//解决响应乱码
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonData);
		return NONE;
	}
}
