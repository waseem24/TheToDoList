package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.PerformanceDao;
import com.todolist.model.Performance;

@Repository("performanceDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class PerformanceDaoImpl implements PerformanceDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Long savePerformance(Performance performance) {
		
		sessionFactory.getCurrentSession().save(performance);
		
		return performance.getPerformanceId();
	}

	@Transactional(readOnly = true)
	public Long updatePerformance(Performance performance) {
		
		sessionFactory.getCurrentSession().update(performance);
		System.out.println("checking");
		return performance.getPerformanceId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Performance> getAllPerformances() {
		
		return sessionFactory.getCurrentSession().createCriteria(Performance.class).list();
	}

	@Transactional(readOnly = false)
	public Performance getPerformance(Long performanceId) {
		
		return (Performance) sessionFactory.getCurrentSession().get(Performance.class, performanceId);
	} 
}
