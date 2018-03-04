package com.san.crm.coursetype.web.action;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.san.crm.base.BaseAction;
import com.san.crm.coursetype.domain.CrmCourseType;
import com.san.crm.page.PageBean;
public class CourseTypeAction extends BaseAction<CrmCourseType>{
	private static final long serialVersionUID = 1L;
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		PageBean<CrmCourseType> pageBean=getCourseTypeService().findAll(this.getModel(),this.getPageNum(),this.getPageSize());
		put("pageBean", pageBean);
		return "findAll";
	}
	
	/**
	 * 添加或编辑显示jsp页面
	 * @return
	 */
	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.getModel().getCourseTypeId())){
			//编辑(有id)，查询数据并显示
			CrmCourseType findCourseType=this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
			push(findCourseType);
		}
		return "addOrEditUI";
	}
	
	/**
	 * 编辑或添加功能
	 * @return
	 */
	public String addOrEdit(){
		this.getCourseTypeService().addOrEdit(this.getModel());
		return "addOrEdit";
	}
}






