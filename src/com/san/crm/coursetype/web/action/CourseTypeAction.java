package com.san.crm.coursetype.web.action;

import java.util.List;

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
	
}
