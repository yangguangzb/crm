package com.san.crm.department.service;

import java.util.List;

import com.san.crm.department.domain.CrmDepartment;

public interface DepartmentService {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<CrmDepartment> findAll();
}
