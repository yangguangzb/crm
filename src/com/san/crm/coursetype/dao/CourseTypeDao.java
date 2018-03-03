package com.san.crm.coursetype.dao;

import java.util.List;

import com.san.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {
	/**
	 * 查询所有课程类别
	 * @return
	 */
	public List<CrmCourseType> findAll();
	
	/**
	 * 根据条件查询课程类别
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition,Object[] params);
	
	/**
	 * 通过课程类别id查询
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	
	/**
	 * 编辑或保存课程类别
	 * @param courseType
	 */
	public void saveOrUpdate(CrmCourseType courseType);
}
