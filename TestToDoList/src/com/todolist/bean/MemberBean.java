package com.todolist.bean;

import java.util.Set;


import org.springframework.web.multipart.MultipartFile;

import com.todolist.model.Group;
import com.todolist.model.Performance;
import com.todolist.model.Role;
import com.todolist.model.Task;
import com.todolist.model.UserStatus;

public class MemberBean {
	
private Long memberId;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private MultipartFile image;
	
	private Group group;
		
	private Set<Task> task;
		
	private Performance performance;

    private Set<Role> roles;
	
	private UserStatus status;


	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public Set<Task> getTask() {
		return task;
	}


	public void setTask(Set<Task> task) {
		this.task = task;
	}


	public Performance getPerformance() {
		return performance;
	}


	public void setPerformance(Performance performance) {
		this.performance = performance;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public UserStatus getStatus() {
		return status;
	}


	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	
}
