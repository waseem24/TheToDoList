package com.todolist.dao.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.GroupDao;
import com.todolist.dao.MemberDao;
import com.todolist.dao.PerformanceDao;
import com.todolist.dao.TaskDao;
import com.todolist.model.Group;
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
	
	@Autowired
	private GroupDao groupDao;

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
			performance = Double.parseDouble(new DecimalFormat("###.##").format(performance));
			
			memberPerformance.setCompletedTasks(taskDone);
			memberPerformance.setNotCompletedTasks(notDoneTasks);
			memberPerformance.setPercentageCompletedTask(performance);
			
			@SuppressWarnings("unused")
			Long updateMemberPerformance= updatePerformance(memberPerformance);
		}

	}
	@SuppressWarnings("unused")
	@Override
	public void calcGroupPerformance() 
	{	
		List<Group> groupsList = groupDao.groupList();
		int notDoneTasks =0;
		int taskDone = 0;
		double performance = 0.0;
		
		for(Group group: groupsList)
		{
			notDoneTasks = calculateNotDoneTasksForGroup(group.getGroupId());
			taskDone = calculateDoneTasksForGroup(group.getGroupId());
			
			
			performance = ((double)(taskDone/(group.getMember().size()))*100);
			performance = Double.parseDouble(new DecimalFormat("###.##").format(performance));
		}
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

	@Override
	public int calculateNotDoneTasksForGroup(Long id) {
		int groupDoneTasks = 0;
		List<Task> tasks = taskDao.taskList();
		for(Task task:tasks)
		{
			if(task.getMember().getGroup().getGroupId().equals(id) && task.getIsDone()== true)
			{
				groupDoneTasks ++;
			}
		}
		return groupDoneTasks;
	}

	@Override
	public int calculateDoneTasksForGroup(Long id) {
		int groupNotDoneTasks = 0;
		List<Task> tasks = taskDao.taskList();
		for(Task task:tasks)
		{
			if(task.getMember().getGroup().getGroupId().equals(id) && task.getIsDone()== false)
			{
				groupNotDoneTasks ++;
			}
		}
		return groupNotDoneTasks;
	} 
}
