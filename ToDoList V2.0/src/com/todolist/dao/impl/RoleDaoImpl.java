package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.RoleDao;
import com.todolist.model.Role;

@Repository("roleDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class RoleDaoImpl implements RoleDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Long saveRole(Role role) {
		
		sessionFactory.getCurrentSession().save(role);
		
		return role.getRoleId();
	}

	@Transactional(readOnly = true)
	public Long updateRole(Role role) {

		sessionFactory.getCurrentSession().update(role);
		
		return role.getRoleId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<Role> getAllPerformances() {
		
		return (List<Role>)sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}

	@Transactional(readOnly = false)
	public Role getRole(Long roleId) {
		
		return (Role) sessionFactory.getCurrentSession().get(Role.class, roleId);
	}
}
