package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.PerformanceDao;
import com.todolist.model.Performance;
import com.todolist.service.PerformanceService;

@Service("performanceService")
@Transactional(propagation = Propagation.SUPPORTS)
public class PerformanceServiceImpl implements PerformanceService
{
	@Autowired
	private PerformanceDao performanceDao;
	
	public Long savePerformance(Performance performance) {

		return performanceDao.savePerformance(performance);
	}
	
	public Long updatePerformance(Performance performance) {
		
		return performanceDao.updatePerformance(performance);
	}
	
	public List<Performance> getAllPerformances() {
		
		return performanceDao.getAllPerformances();
	}

	public Performance getPerformance(Long performanceId) {

		return performanceDao.getPerformance(performanceId);
	}
}
