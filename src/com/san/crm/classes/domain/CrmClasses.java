package com.san.crm.classes.domain;

import java.util.Date;

import com.san.crm.coursetype.domain.CrmCourseType;

public class CrmClasses {
	private String classId;
	private String name;		//课程名称
	private Date beginTime;	//开班时间
	private Date endTime;		//结业时间
	private String status;		//状态
	private Integer totalCount;	//总人数
	private Integer upgradeCount;	//升级数
	private Integer changeCount;	//转班数
	private Integer runoffCount;	//流失数
	private String remark;		//描述
	private Date uploadTime;	//上传时间
	private String uploadPath;	//上传课表路径
	private String uploadFilename;	//上传课表名称
	//多对一，多个班级对应一个课程类别
	private CrmCourseType courseType;
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getUpgradeCount() {
		return upgradeCount;
	}
	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}
	public Integer getChangeCount() {
		return changeCount;
	}
	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}
	public Integer getRunoffCount() {
		return runoffCount;
	}
	public void setRunoffCount(Integer runoffCount) {
		this.runoffCount = runoffCount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUploadFilename() {
		return uploadFilename;
	}
	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}
	public CrmCourseType getCourseType() {
		return courseType;
	}
	public void setCourseType(CrmCourseType courseType) {
		this.courseType = courseType;
	}
}
