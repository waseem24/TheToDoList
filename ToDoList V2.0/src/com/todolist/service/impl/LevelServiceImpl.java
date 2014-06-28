package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.LevelDao;
import com.todolist.model.Level;
import com.todolist.service.LevelService;

@Service("levelService")
@Transactional(propagation=Propagation.REQUIRED)
public class LevelServiceImpl implements LevelService {
	
	@Autowired
	private LevelDao levelDao;
	
	public Long saveLevel(Level level) {
		
		return levelDao.saveLevel(level);
	}

	
	public Long updateLevel(Level level) {
		
		return levelDao.updateLevel(level);
	}

	
	public List<Level> listLevel() {
		
		return levelDao.listLevel();
	}

	
	public Level getLevel(Long levelId) {
		
		return levelDao.getLevel(levelId);
	}

}
