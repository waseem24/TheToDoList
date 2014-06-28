package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.GroupDao;
import com.todolist.model.Group;
import com.todolist.service.GroupService;

@Service("groupService")
@Transactional(propagation = Propagation.SUPPORTS)
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupDao groupDao;

	public Long saveGroup(Group group) {

		return groupDao.saveGroup(group);
	}
	
	public Long updateGroup(Group group) {
		
		return groupDao.updateGroup(group);
	}

	public List<Group> groupList() {
		
		return groupDao.groupList();
	}

	public Group getGroup(Long groupId) {
		
		return groupDao.getGroup(groupId);
	}

	public Group findGroupByName(String name) {

		return groupDao.findGroupByName(name);
	}	
}
