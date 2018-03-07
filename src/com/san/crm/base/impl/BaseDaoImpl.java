package com.san.crm.base.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.san.crm.base.BaseDao;
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

}
