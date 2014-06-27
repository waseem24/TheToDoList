package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MemberDao;
import com.todolist.dao.PerformanceDao;
import com.todolist.dao.TaskDao;
import com.todolist.model.Member;
import com.todolist.model.Performance;
import com.todolist.model.Task;

@Repository("performanceDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class PerformanceDaoImpl implements PerformanceDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private TaskDao taskDao;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Long savePerformance(Performance performance) {
		
		sessionFactory.getCurrentSession().save(performance);
		
		return performance.getPerformanceId();
	}

	@Transactional(readOnly = true)
	public Long updatePerformance(Performance performance) {
		
		sessionFactory.getCurrentSession().update(performance);
		
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

	
	@Scheduled(fixedRate=2000)
	@Override
	public void calcMemberPerformance() 
	{
		List<Member> allMembers = memberDao.getAllMembers();
		List<Task> tasks = taskDao.taskList();
		double notCompletedTasks =0.0;
		double taskDone = 0.0;
		double performance = 0.0;
		
		
		for(Member member: allMembers)
		{
			for(Task newTask :tasks)
			{
			  if(newTask.getMember().getMemberId().equals(member.getMemberId()) && newTask.getIsDone()== true)
			   {
				 taskDone ++;
			   }
			}
			Performance memberPerformance = getPerformance(member.getMemberId());
			performance = (taskDone/memberPerformance.getNoOfTasks()*100);
			notCompletedTasks = memberPerformance.getNoOfTasks() - taskDone;
			
			Performance newPerformance = new Performance();
			
			newPerformance.setCompletedTasks((int)taskDone);
			newPerformance.setNotCompletedTasks((int)notCompletedTasks);
			newPerformance.setPercentageCompletedTask(performance);
			Long updateMemberPerformance= updatePerformance(newPerformance);
		}
		
	}

	@Override
	public void calcGroupPerformance() 
	{
		
		
	} 
}
