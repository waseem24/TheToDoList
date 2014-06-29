package com.todolist.dao;

import java.util.List;

import com.todolist.model.Role;

public interface RoleDao {

	Long saveRole(Role role);
	Long updateRole(Role role);
	List<Role> getAllPerformances();
	Role getRole(Long roleId);
	
}
