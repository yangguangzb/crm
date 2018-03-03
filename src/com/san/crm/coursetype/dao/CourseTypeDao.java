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
	
	/**
	 * 根据条件查询中记录数
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition,Object[] params);
	
	/**
	 * 根据条件分页查询所有
	 * @param condition
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition,Object[] params,int startIndex,int pageSize);
}
