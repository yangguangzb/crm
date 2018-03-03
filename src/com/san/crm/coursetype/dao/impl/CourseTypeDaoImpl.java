package com.san.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.crm.coursetype.dao.CourseTypeDao;
import com.san.crm.coursetype.domain.CrmCourseType;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {
	//查询所有课程类别
	public List<CrmCourseType> findAll() {
		
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

	//根据条件查询课程类别
	public List<CrmCourseType> findAll(String condition, Object[] params) {
		String hql="from CrmCourseType where 1=1 "+condition;
		return this.getHibernateTemplate().find(hql,params);
	}
	
	//通过课程类别id查询
	public CrmCourseType findById(String courseTypeId) {
		return this.getHibernateTemplate().get(CrmCourseType.class,courseTypeId);
	}
	
	//编辑或保存课程类别
	public void saveOrUpdate(CrmCourseType courseType) {
		this.getHibernateTemplate().saveOrUpdate(courseType);
	}

}
