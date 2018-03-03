package com.san.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.san.crm.coursetype.domain.CrmCourseType;
import com.san.crm.coursetype.service.CourseTypeService;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
	private static final long serialVersionUID = 1L;
	//封装数据
	private CrmCourseType courseType=new CrmCourseType();
	public CrmCourseType getModel() {
		return courseType;
	}
	//调用service
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		List<CrmCourseType> allCourseType=courseTypeService.findAll(courseType);
		ActionContext.getContext().put("allCourseType", allCourseType);
		return "findAll";
	}
	
	/**
	 * 添加或编辑显示jsp页面
	 * @return
	 */
	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.courseType.getCourseTypeId())){
			//编辑(有id)，查询数据并显示
			CrmCourseType findCourseType=this.courseTypeService.findById(this.courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCourseType);
		}
		return "addOrEditUI";
	}
	
	/**
	 * 编辑或添加功能
	 * @return
	 */
	public String addOrEdit(){
		this.courseTypeService.addOrEdit(courseType);
		return "addOrEdit";
	}
}






