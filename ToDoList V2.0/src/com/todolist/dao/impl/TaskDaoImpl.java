package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.TaskDao;
import com.todolist.model.Task;

@Repository("taskDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class TaskDaoImpl implements TaskDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Long saveTask(Task task) {
		
		sessionFactory.getCurrentSession().save(task);
		
		return task.getTaskId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Task> taskList() {
		
		return (List<Task>)sessionFactory.getCurrentSession().createCriteria(Task.class).list();
	}

	@Transactional(readOnly = false)
	public Long updateTask(Task task) {
		
		sessionFactory.getCurrentSession().update(task);
		
		return task.getTaskId();
	}

	@Transactional(readOnly = true)
	public Task getTask(Long taskId) {
		
		return (Task) sessionFactory.getCurrentSession().get(Task.class, taskId);
	}	
}
