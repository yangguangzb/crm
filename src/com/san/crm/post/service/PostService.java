package com.san.crm.post.service;

import java.util.List;

import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.post.domain.CrmPost;

public interface PostService {
	/**
	 * 查询指定部门的所有职务
	 * @param crmDepartment
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment crmDepartment);
}
