package com.san.crm.base.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.san.crm.base.BaseDao;
import com.san.crm.coursetype.domain.CrmCourseType;
import com.san.crm.page.PageHibernateCallback;
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	//T 在编译时是变量，在运行时，才可以获得具体的类型
	private Class<?> beanclass;
	//子类new一个对象时，会执行父类的构造方法，再执行子类的构造方法
	public BaseDaoImpl(){
		//获得运行时的类型，BaseDaoImpl<CrmStaff>：被参数化的类型
		ParameterizedType paramType= (ParameterizedType) this.getClass().getGenericSuperclass();
		beanclass=(Class<?>) paramType.getActualTypeArguments()[0];
	}
	
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}

	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
	}

	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
		
	}

	public T findById(Serializable t) {
		
		return (T) this.getHibernateTemplate().get(beanclass,t);
	}

	public List<T> findAll() {
		//getName():获得全限定类名
		return this.getHibernateTemplate().find("from "+beanclass.getName());
	}

	//根据条件查询课程类别
	public List<T> findAll(String condition, Object[] params) {
		String hql="from "+beanclass.getName()+" where 1=1 "+condition;
		return this.getHibernateTemplate().find(hql,params);
	}

	//分页获得总记录数
	public int getTotalRecord(String condition, Object[] params) {
		String hql="select count(c) from "+beanclass.getName()+" c where 1=1 "+condition;
		List<Long> list=this.getHibernateTemplate().find(hql,params);
		return list.get(0).intValue();
	}
	
	//分页查询
	public List<T> findAll(String condition, Object[] params,
			int startIndex, int pageSize) {
		String hql="from "+beanclass.getName()+" where 1=1 "+condition;
		return this.getHibernateTemplate().execute(
				new PageHibernateCallback<T>().setHql(hql).setParams(params).setPageSize(pageSize).setStartIndex(startIndex));
	}
}
