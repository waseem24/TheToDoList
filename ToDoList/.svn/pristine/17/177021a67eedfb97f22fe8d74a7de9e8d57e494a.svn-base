package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.TaskDao;
import com.todolist.model.Task;
import com.todolist.service.TaskService;

@Service("taskService")
@Transactional(propagation = Propagation.SUPPORTS)
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

	public Long saveTask(Task task) {
		
		return taskDao.saveTask(task);
	}

	public List<Task> taskList() {
		
		return taskDao.taskList();
	}

	public Long updateTask(Task task) {

		return taskDao.updateTask(task);
	}

	public Task getTask(Long taskId) {
		
		return taskDao.getTask(taskId);
	}
}
