package com.san.crm.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.post.dao.PostDao;
import com.san.crm.post.domain.CrmPost;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	public List<CrmPost> findAll(CrmDepartment crmDepartment) {
		
		return this.getHibernateTemplate().find("from CrmPost where department=?",crmDepartment);
	}

}
