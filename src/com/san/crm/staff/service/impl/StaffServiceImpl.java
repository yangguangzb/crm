package com.san.crm.staff.service.impl;

import com.san.crm.staff.dao.StaffDao;
import com.san.crm.staff.domain.CrmStaff;
import com.san.crm.staff.service.StaffService;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	public CrmStaff login(CrmStaff staff) {
		return staffDao.find(staff.getLoginName(),staff.getLoginPwd());
	}
}
