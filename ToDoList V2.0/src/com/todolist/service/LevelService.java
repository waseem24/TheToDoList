package com.todolist.service;

import java.util.List;

import com.todolist.model.Level;

public interface LevelService {
	Long saveLevel(Level level);
	Long updateLevel(Level level);
	List<Level> listLevel();
	Level getLevel(Long levelId);
}
