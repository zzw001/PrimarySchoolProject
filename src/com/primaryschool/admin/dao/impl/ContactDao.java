package com.primaryschool.admin.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.admin.dao.IContactDao;

/**
 * 
* @ClassName: ContactDao
* @Description: TODO 联系我们
* @author Mingshan
* @date 2017年4月20日 下午10:25:26
*
* @param <T>
 */

@Repository
public class ContactDao<T> implements IContactDao<T> {

	@Autowired
	private  SessionFactory sessionFactory;
	
	
	/**
	 * 获取联系我们信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findContactInfo() {
		// TODO Auto-generated method stub
		String hql="from Contact";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (T) query.uniqueResult();
	}


	/**
	 * 添加
	 */
	@Override
	public int saveContactInfo(T t) {
		// TODO Auto-generated method stub
		Serializable result =sessionFactory.getCurrentSession().save(t);
		return (Integer)result;
	}


	/**
	 * 更新
	 */
	@Override
	public boolean updateContactInfo(T t) {
		// TODO Auto-generated method stub
		String hql="update Contact c set c.content=:content, c.addTime=:addTime,c.author=:author,c.isPublish=:isPublish  where c.id=:id";
		Query query  = sessionFactory.getCurrentSession().createQuery(hql); 
		query.setProperties(t);
		return (query.executeUpdate()>0);
	}

}
