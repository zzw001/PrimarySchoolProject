package com.primaryschool.apply.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.primaryschool.apply.dao.IApplyDao;
import com.primaryschool.apply.entity.ApplyDate;

/**
 * 
* @ClassName: ApplyDao
* @Description: TODO APPLY DAO
* @author Mingshan
* @date 2017年5月1日 下午3:14:23
*
* @param <T>
 */

@Repository
public class ApplyDao<T> implements IApplyDao<T> {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveApplyInfo(T t) {
		// TODO Auto-generated method stub
		Serializable res=sessionFactory.getCurrentSession().save(t);
		return (int) res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findApplyInfo(int id) {
		// TODO Auto-generated method stub
		
		String hql="from Apply a where a.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findApplyInfoByCardId(String  cardCode) {
		// TODO Auto-generated method stub
		String hql="from Apply a where a.stuIdNum=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, cardCode);
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findApplyCardCodeByUserCardCode(String userCardCode) {
		// TODO Auto-generated method stub
		String hql="select new com.primaryschool.apply.entity.Apply(a.id,a.stuIdNum) from Apply a, ApplyUser au where a.uid=au.id and au.cardCode=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userCardCode);
		return (T) query.uniqueResult();
	}

	@Override
	public int findDateIdByYear(int year) {
		// TODO Auto-generated method stub
		String hql="from ApplyDate where year=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, year);
		ApplyDate date= (ApplyDate) query.uniqueResult();
		return date.getId();
	}

}
