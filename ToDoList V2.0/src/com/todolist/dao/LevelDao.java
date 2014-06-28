package com.todolist.dao;

import java.util.List;

import com.todolist.model.Level;

public interface LevelDao {
	
	Long saveLevel(Level level);
	Long updateLevel(Level level);
	List<Level> listLevel();
	Level getLevel(Long levelId);
	
}
