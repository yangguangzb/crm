package com.san.crm.staff.service.impl;
import java.util.List;

import com.san.crm.staff.dao.StaffDao;
import com.san.crm.staff.domain.CrmStaff;
import com.san.crm.staff.service.StaffService;
import com.san.crm.utils.MyStringUtils;
public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	
	public CrmStaff login(CrmStaff staff) {
		String MD5Password=MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(),MD5Password);
	}
	
	//查询所有员工
	public List<CrmStaff> findAllStaff() {
		return staffDao.findAll();
	}
	
	//通过ID查询
	public CrmStaff findById(String staffId) {
		return staffDao.findById(staffId);
	}
	//更新用户信息
	public void update(CrmStaff staff) {
		CrmStaff findStaff=staffDao.findById(staff.getStaffId());
		//判断数据库中的密码与用户提交的密码是否一致，如果不一致，则加密存储
		if(!findStaff.getLoginPwd().equals(staff.getLoginPwd())){
			//密码不一致，加密存储
			findStaff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
		}
		/**
		 * 采用hibernate的快照与一级缓存，自动更新(不需要数据库更新)
		 */
		findStaff.setLoginName(staff.getLoginName());
		findStaff.setStaffName(staff.getStaffName());
		findStaff.setGender(staff.getGender());
		findStaff.setOnDutyDate(staff.getOnDutyDate());
		findStaff.setPost(staff.getPost());
	}
	
}
