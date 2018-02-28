package com.san.crm.post.dao;

import java.util.List;

import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.post.domain.CrmPost;

public interface PostDao {
	/**
	 * 通过部门查询所有的职务
	 * @param crmDepartment
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment crmDepartment);
}
