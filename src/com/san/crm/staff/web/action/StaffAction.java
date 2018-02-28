package com.san.crm.staff.web.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.department.service.DepartmentService;
import com.san.crm.staff.domain.CrmStaff;
import com.san.crm.staff.service.StaffService;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff>{
	private static final long serialVersionUID = 1L;
	//封装数据
	private CrmStaff staff=new CrmStaff();
	
	//注入staffService
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	//注入departmentService
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
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
	
	/**
	 * 查询所有员工方法
	 * @return
	 */
	public String findAll(){
		List<CrmStaff> allStaff = staffService.findAllStaff();
		//将结果存放到值栈中，方便jsp获取
		/**
		 * 方式1：
		 * 	context(map)存放put(key,value) jsp获得"#key"
		 * 		ActionContext.getContext.put(key,value)
		 * 方式2：
		 * 	root(值栈)，push(obj) 一般数据为javaBean或者map。jsp页面获得"属性名"或者"key"
		 * 		ActionContext.getContext().getValueStack().push(o)
		 * 方式3：
		 * 	root(值栈)，set(key,value),一般数据类型为list，jsp页面获得"key"
		 *		set() 底层new Map(key,value)，将push(map)
		 */
		ActionContext.getContext().put("allStaff",allStaff);
		return "findAll";
	}
	
	public String editUI(){
		CrmStaff findStaff=staffService.findById(staff.getStaffId());
		//将结果放入到值栈中，
		ActionContext.getContext().getValueStack().push(findStaff);
		
		//查询所有部门
		List<CrmDepartment> allDepartment=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("allDepartment",allDepartment);
		return "editUI";
	}
	/**
	 * 编辑员工信息
	 * @return
	 */
	public String edit(){
		staffService.update(staff);
		return "edit";
	}
}
