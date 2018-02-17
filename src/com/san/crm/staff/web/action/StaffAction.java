package com.san.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.san.crm.staff.domain.CrmStaff;
import com.san.crm.staff.service.StaffService;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff>{
	//封装数据
	private CrmStaff staff=new CrmStaff();
	//注入staffService
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public CrmStaff getModel() {
		return staff;
	}
	/**
	 * 员工登录
	 * @return
	 */
	public String login(){
		CrmStaff findStaff=staffService.login(staff);
		if(findStaff!=null){
			ActionContext.getContext().getSession().put("loginStaff",findStaff);
			return SUCCESS;
		}else{
			//登录失败
			this.addFieldError("","用户名与密码不匹配");
			return "login";
		}
	}
	
	/**
	 * 显示首页
	 * @return
	 */
	public String home(){
		return "home";
	}
}
