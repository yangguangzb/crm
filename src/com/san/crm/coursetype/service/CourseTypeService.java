package com.san.crm.coursetype.service;

import java.util.List;

import com.san.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeService {
	/**
	 * 查询所有课程类别业务
	 * @return
	 */
	public List<CrmCourseType> findAll();
	
	/**
	 * 根据条件查询课程类别业务
	 * @param courseType
	 * @return
	 */
	public List<CrmCourseType> findAll(CrmCourseType courseType);
	
}
