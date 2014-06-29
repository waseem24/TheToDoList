package com.todolist.service;

import java.util.List;

import com.todolist.model.Role;

public interface RoleService {

	Long saveRole(Role role);
	Long updateRole(Role role);
	List<Role> getAllPerformances();
	Role getRole(Long roleId);
	
}
