package com.san.crm.staff.service;

import com.san.crm.staff.domain.CrmStaff;

public interface StaffService {
	/**
	 * 登录
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);
}
