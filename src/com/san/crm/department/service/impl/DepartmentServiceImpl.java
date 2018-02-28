package com.san.crm.department.service.impl;

import java.util.List;

import com.san.crm.department.dao.DepartmentDao;
import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.department.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	//查询所有部门
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

}
