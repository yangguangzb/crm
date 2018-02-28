package com.san.crm.department.dao;

import java.util.List;

import com.san.crm.department.domain.CrmDepartment;

public interface DepartmentDao {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<CrmDepartment> findAll();
}
