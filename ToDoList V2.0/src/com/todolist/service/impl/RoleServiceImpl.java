package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.RoleDao;
import com.todolist.model.Role;
import com.todolist.service.RoleService;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS)
public class RoleServiceImpl implements RoleService
{
	
	@Autowired
	private RoleDao roleDao;

	public Long saveRole(Role role) {
		
		return roleDao.saveRole(role);
	}

	public Long updateRole(Role role) {
		
		return roleDao.updateRole(role);
	}

	public List<Role> getAllPerformances() {
		
		return roleDao.getAllPerformances();
	}

	public Role getRole(Long roleId) {
		
		return roleDao.getRole(roleId);
	}
	
}
