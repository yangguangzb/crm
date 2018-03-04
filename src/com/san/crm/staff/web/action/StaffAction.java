package com.san.crm.staff.web.action;
import java.util.List;
import com.san.crm.base.BaseAction;
import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.staff.domain.CrmStaff;
public class StaffAction extends BaseAction<CrmStaff>{
	private static final long serialVersionUID = 1L;
	/**
	 * 员工登录
	 * @return
	 */
	public String login(){
		CrmStaff findStaff=getStaffService().login(this.getModel());
		if(findStaff!=null){
			putSession("loginStaff",findStaff);
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
		List<CrmStaff> allStaff = getStaffService().findAllStaff();
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
		put("allStaff",allStaff);
		return "findAll";
	}
	
	public String editUI(){
		CrmStaff findStaff=getStaffService().findById(this.getModel().getStaffId());
		//将结果放入到值栈中，
		push(findStaff);
		
		//查询所有部门
		List<CrmDepartment> allDepartment=getDepartmentService().findAll();
		set("allDepartment",allDepartment);
		return "editUI";
	}
	/**
	 * 编辑员工信息
	 * @return
	 */
	public String edit(){
		getStaffService().update(this.getModel());
		return "edit";
	}
}
