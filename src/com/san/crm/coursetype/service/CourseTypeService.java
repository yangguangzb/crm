package com.san.crm.coursetype.service;

import java.util.List;

import com.san.crm.coursetype.domain.CrmCourseType;
import com.san.crm.page.PageBean;

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
	
	/**
	 * 根据id查询
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	
	/**
	 * 编辑或保存课程类别
	 * @param courseType
	 */
	public void addOrEdit(CrmCourseType courseType);
	
	/**
	 * 分页查询
	 * @param courseType
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType,int pageNum,int pageSize);
	
}
