package com.primaryschool.home.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.home.dao.ISclassDao;

@Repository
public class SclassDao<T> implements ISclassDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<T> findClassInfo() {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.home.entity.Sclass(c.id, c.className, c.gradeId, g.gradeCode)from Sclass c,Grade g where c.gradeId=g.id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	

}