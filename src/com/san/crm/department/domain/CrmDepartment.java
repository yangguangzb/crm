package com.san.crm.department.domain;

import java.util.HashSet;
import java.util.Set;

import com.san.crm.post.domain.CrmPost;

public class CrmDepartment {
	private String depId;
	private String depName;//部门名称
	//一对多，一个部门对应多的职务
	private Set<CrmPost> postSet=new HashSet<CrmPost>();
	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Set<CrmPost> getPostSet() {
		return postSet;
	}

	public void setPostSet(Set<CrmPost> postSet) {
		this.postSet = postSet;
	}
}
