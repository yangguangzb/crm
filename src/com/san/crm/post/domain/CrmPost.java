package com.san.crm.post.domain;

import java.util.HashSet;
import java.util.Set;

import com.san.crm.department.domain.CrmDepartment;
import com.san.crm.staff.domain.CrmStaff;

public class CrmPost {
	private String postId;
	private String postName; //职务名称
	//多对一，多个职务属于一个部门
	private CrmDepartment department;
	//一对多，一个职务有多员工
	private Set<CrmStaff> staffSet=new HashSet<CrmStaff>();
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public CrmDepartment getDepartment() {
		return department;
	}
	public void setDepartment(CrmDepartment department) {
		this.department = department;
	}
	public Set<CrmStaff> getStaffSet() {
		return staffSet;
	}
	public void setStaffSet(Set<CrmStaff> staffSet) {
		this.staffSet = staffSet;
	}
}
