package com.san.crm.staff.dao;

import com.san.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * 通过登录名和密码查询
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName,String loginPwd);
}
