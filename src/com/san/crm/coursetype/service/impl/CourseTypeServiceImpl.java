package com.san.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.san.crm.coursetype.dao.CourseTypeDao;
import com.san.crm.coursetype.domain.CrmCourseType;
import com.san.crm.coursetype.service.CourseTypeService;
import com.san.crm.page.PageBean;

public class CourseTypeServiceImpl implements CourseTypeService {
	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	public List<CrmCourseType> findAll() {
		 
		return courseTypeDao.findAll();
	}

	public List<CrmCourseType> findAll(CrmCourseType courseType) {
		//拼凑查询条件
		StringBuilder buider=new StringBuilder();
		//拼凑实际参数
		List<Object> paramsList=new ArrayList<Object>();
		
		//课程类别(名称)
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			buider.append(" and courseName like ?");
			paramsList.add("%"+courseType.getCourseName()+"%");
		}
		//课程简介
		if(StringUtils.isNotBlank(courseType.getRemark())){
			buider.append(" and remark like ?");
			paramsList.add("%"+courseType.getRemark()+"%");
		}
		//总学时
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			buider.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			buider.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		//课程费用
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			buider.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			buider.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		String condition=buider.toString();
		Object[] params=paramsList.toArray();
		return courseTypeDao.findAll(condition, params);
	}
	
	//通过id查询
	public CrmCourseType findById(String courseTypeId) {
		
		return courseTypeDao.findById(courseTypeId);
	}
	
	//添加或编辑
	public void addOrEdit(CrmCourseType courseType) {
		this.courseTypeDao.saveOrUpdate(courseType);
	}
	
	//分页查询
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum,
			int pageSize) {
		//拼凑查询条件
		StringBuilder buider=new StringBuilder();
		//拼凑实际参数
		List<Object> paramsList=new ArrayList<Object>();
		
		//课程类别(名称)
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			buider.append(" and courseName like ?");
			paramsList.add("%"+courseType.getCourseName()+"%");
		}
		//课程简介
		if(StringUtils.isNotBlank(courseType.getRemark())){
			buider.append(" and remark like ?");
			paramsList.add("%"+courseType.getRemark()+"%");
		}
		//总学时
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			buider.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			buider.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		//课程费用
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			buider.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			buider.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		String condition=buider.toString();
		Object[] params=paramsList.toArray();
		//总记录数
		int totalRecord=this.courseTypeDao.getTotalRecord(condition, params);		
		//创建对象
		PageBean<CrmCourseType> pageBean=new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
		List<CrmCourseType> data=this.courseTypeDao.findAll(condition, params, pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}

}
