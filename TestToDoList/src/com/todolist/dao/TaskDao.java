package com.todolist.dao;

import java.util.List;

import com.todolist.model.Task;

public interface TaskDao {
	
	Long saveTask(Task task);
	List<Task> taskList();
	Long updateTask(Task task);
	Task getTask(Long taskId);
}
