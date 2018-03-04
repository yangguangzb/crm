package com.san.crm.post.web.action;
import java.io.IOException;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import com.san.crm.base.BaseAction;
import com.san.crm.post.domain.CrmPost;
public class PostAction extends BaseAction<CrmPost>{
	private static final long serialVersionUID = 1L;
	/**
	 * ajax通过指定部门查询所有职务
	 * @return
	 * @throws IOException 
	 */
	public String findAllWithDepartment() throws IOException{
		List<CrmPost> allPost =getPostService().findAll(this.getModel().getDepartment());
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
