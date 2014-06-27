package com.todolist.service;

import java.util.List;

import com.todolist.model.Task;

public interface TaskService {
	
	Long saveTask(Task task);
	List<Task> taskList();
	Long updateTask(Task task);
	Task getTask(Long taskId);
}
