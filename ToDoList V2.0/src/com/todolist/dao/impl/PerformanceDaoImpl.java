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

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long savePerformance(Performance performance) {
		
		sessionFactory.getCurrentSession().save(performance);
		
		return performance.getPerformanceId();
	}

	@Transactional(readOnly = false)
	public Long updatePerformance(Performance performance) {
		
		sessionFactory.getCurrentSession().update(performance);
		System.out.println("checking");
		return performance.getPerformanceId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Performance> getAllPerformances() {
		
		return (List<Performance>)sessionFactory.getCurrentSession().createCriteria(Performance.class).list();
	}

	@Transactional(readOnly = true)
	public Performance getPerformance(Long performanceId) {
		
		return (Performance) sessionFactory.getCurrentSession().get(Performance.class, performanceId);
	}

	@Transactional(readOnly = true)
//	@Scheduled(fixedRate=300000)// this method will be invoked after every 5 min to perform calculations & update relevant table
	@Override
	public void calcMemberPerformance() 
	{
		List<Member> allMembers = memberDao.getAllMembers();
		int notDoneTasks =0;
		int taskDone = 0;
		double performance = 0.0;
		
		
		for(Member member: allMembers)
		{
			
			taskDone = calcDoneTasks(member.getMemberId());
			notDoneTasks = calcNotDoneTasks(member.getMemberId());
			
			Performance memberPerformance = getPerformance(member.getMemberId());
			
			performance = ((double)(taskDone/(memberPerformance.getNoOfTasks()))*100);
			
			
			memberPerformance.setCompletedTasks(taskDone);
			memberPerformance.setNotCompletedTasks(notDoneTasks);
			memberPerformance.setPercentageCompletedTask(performance);
			
			Long updateMemberPerformance= updatePerformance(memberPerformance);
		}

	}
	@Override
	public void calcGroupPerformance() 
	{	

	}
	
	public int calcDoneTasks(Long id) 
	{
		int taskDone = 0;
		List<Task> tasks = taskDao.taskList();
		for(Task newTasks: tasks)
		{
			if(newTasks.getMember().getMemberId().equals(id) && newTasks.getIsDone()==true)
			{
				taskDone ++;
			}
		}
		return taskDone;
	}


	public int calcNotDoneTasks(Long id) 
	{
		int taskNotDone = 0;
		List<Task> tasks = taskDao.taskList();
		for(Task newTasks: tasks)
		{
			if(newTasks.getMember().getMemberId().equals(id) && newTasks.getIsDone()==false)
			{
				taskNotDone ++;
			}
		}
		return taskNotDone;
	} 
}
