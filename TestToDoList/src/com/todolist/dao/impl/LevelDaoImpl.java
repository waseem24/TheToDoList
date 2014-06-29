package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.LevelDao;
import com.todolist.model.Level;
@Repository("levelDao")
@Transactional(propagation=Propagation.SUPPORTS)
public class LevelDaoImpl implements LevelDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public Long saveLevel(Level level) {
		sessionFactory.getCurrentSession().save(level);
		return level.getLevelId();
	}

	@Transactional(readOnly=false)
	public Long updateLevel(Level level) {
		sessionFactory.getCurrentSession().update(level);
		return level.getLevelId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Level> listLevel() {

		return (List<Level>)sessionFactory.getCurrentSession().createCriteria(Level.class).list();
	}

	@Transactional(readOnly=true)
	public Level getLevel(Long levelId) {
		
		return (Level) sessionFactory.getCurrentSession().get(Level.class, levelId);
	}

	
}
