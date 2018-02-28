package com.san.crm.staff.dao;

import java.util.List;

import com.san.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * 通过登录名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName,String loginPwd);
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<CrmStaff> findAll();
	
	/**
	 * 通过ID查询员工
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
}
