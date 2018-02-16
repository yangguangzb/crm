package com.san.crm.coursetype.domain;

import java.util.HashSet;
import java.util.Set;

import com.san.crm.classes.domain.CrmClasses;

public class CrmCourseType {
	private String courseTypeId;
	private double courseCost;	//课程费用
	private int total;			//总课时
	private String courseName;	//课程类别名称
	private String remark;		//课程介绍模板
	//一对多，一个课程对应多个班级
	private Set<CrmClasses> classesSet=new HashSet<CrmClasses>();
	public String getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(String courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public double getCourseCost() {
		return courseCost;
	}
	public void setCourseCost(double courseCost) {
		this.courseCost = courseCost;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<CrmClasses> getClassesSet() {
		return classesSet;
	}
	public void setClassesSet(Set<CrmClasses> classesSet) {
		this.classesSet = classesSet;
	}
}
