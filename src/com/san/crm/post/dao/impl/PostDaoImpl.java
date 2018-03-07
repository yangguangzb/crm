package com.san.crm.post.dao.impl;
import java.util.List;
import com.san.crm.base.impl.BaseDaoImpl;
import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.post.dao.PostDao;
import com.san.crm.post.domain.CrmPost;
public class PostDaoImpl extends BaseDaoImpl<CrmPost> implements PostDao {

	public List<CrmPost> findAll(CrmDepartment crmDepartment) {
		
		return this.getHibernateTemplate().find("from CrmPost where department=?",crmDepartment);
	}

}
