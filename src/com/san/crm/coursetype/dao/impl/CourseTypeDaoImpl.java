package com.san.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.crm.coursetype.dao.CourseTypeDao;
import com.san.crm.coursetype.domain.CrmCourseType;
import com.san.crm.page.PageHibernateCallback;

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

	//分页获得总记录数
	public int getTotalRecord(String condition, Object[] params) {
		String hql="select count(c) from CrmCourseType c where 1=1 "+condition;
		List<Long> list=this.getHibernateTemplate().find(hql,params);
		return list.get(0).intValue();
	}
	
	//分页查询
	public List<CrmCourseType> findAll(String condition, Object[] params,
			int startIndex, int pageSize) {
		String hql="from CrmCourseType where 1=1 "+condition;
		return this.getHibernateTemplate().execute(
				new PageHibernateCallback<CrmCourseType>().setHql(hql).setParams(params).setPageSize(pageSize).setStartIndex(startIndex));
	}
}












