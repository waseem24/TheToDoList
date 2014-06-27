package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.GroupDao;
import com.todolist.model.Group;

@Repository("groupDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class GroupDaoImpl implements GroupDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false)
	public Long saveGroup(Group group) {
		
		sessionFactory.getCurrentSession().save(group);
		
		return group.getGroupId();
	}

	@Transactional(readOnly = false)
	public Long updateGroup(Group group) {

		sessionFactory.getCurrentSession().update(group);
		
		return group.getGroupId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Group> groupList() {
		
		return sessionFactory.getCurrentSession().createCriteria(Group.class).list();
	}

	@Transactional(readOnly = true)
	public Group getGroup(Long groupId) {
		
		return (Group)sessionFactory.getCurrentSession().get(Group.class,groupId );
	}

	@Transactional(readOnly = true)
	public Group findGroupByName(String name) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Group.class);
	
		criteria.add(Restrictions.eq("name", name));
		
		return (Group) criteria.uniqueResult();
	}
}
