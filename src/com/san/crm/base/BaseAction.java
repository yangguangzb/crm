package com.san.crm.base;
import java.lang.reflect.ParameterizedType;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.san.crm.classes.service.ClassesService;
import com.san.crm.coursetype.service.CourseTypeService;
import com.san.crm.department.service.DepartmentService;
import com.san.crm.post.service.PostService;
import com.san.crm.staff.service.StaffService;
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private static final long serialVersionUID = 1L;
	//封装数据
	private T t;
	public T getModel() {
		return t;
	}
	//实例化t
	public BaseAction() {
		try {
			//获得T运行时的Class
			 ParameterizedType paramType= (ParameterizedType) this.getClass().getGenericSuperclass();
			 Class<T> clazz=(Class<T>) paramType.getActualTypeArguments()[0];
			 //反射创建实例
			 t=clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	//spring注入多个service
		//* 提供setter方法,让spring进行注入
		//* 提供getter方法，让子类可以获得spring注入的对象
	
	//员工
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	
	//职务
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	public PostService getPostService() {
		return postService;
	}
	
	//部门
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	
	//课程类别
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}
	
	//班级
	private ClassesService classesService;
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	public ClassesService getClassesService() {
		return classesService;
	}
	
	//分页数据
	private int pageNum=1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	private int pageSize=2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	//值栈操作
	/**
	 * 压栈
	 * @param o
	 */
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	/**
	 * 值栈的set
	 * @param key
	 * @param o
	 */
	public void set(String key,Object o){
		ActionContext.getContext().getValueStack().set(key, o);
	}
	
	/**
	 * map的put
	 * @param key
	 * @param o
	 */
	public void put(String key,Object o){
		ActionContext.getContext().put(key, o);
	}
	
	/**
	 * session的put
	 * @param key
	 * @param o
	 */
	public void putSession(String key,Object o){
		ActionContext.getContext().getSession().put(key, o);
	}
	
	/**
	 * application的put
	 * @param key
	 * @param o
	 */
	public void putApplication(String key,Object o){
		ActionContext.getContext().getApplication().put(key, o);
	}

}
