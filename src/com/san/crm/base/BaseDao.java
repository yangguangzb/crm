package com.san.crm.base;

import java.util.List;

import com.san.crm.coursetype.domain.CrmCourseType;

/**
 * dao基类
 * @author zhangbiao
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 添加
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 更新
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 保存或编辑(无id为保存，有id为编辑)
	 * @param t
	 */
	public void saveOrUpdate(T t);
	
	/**
	 * 通过id查询
	 * @param t
	 * @return
	 */
	public T findById(java.io.Serializable t);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 根据条件查询课程类别
	 * @param condition
	 * @param params
	 * @return
	 */
	public List<T> findAll(String condition,Object[] params);
	
	/**
	 * 根据条件查询中记录数
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition,Object[] params);
	
	/**
	 * 根据条件分页查询所有
	 * @param condition
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<T> findAll(String condition,Object[] params,int startIndex,int pageSize);
	
}
