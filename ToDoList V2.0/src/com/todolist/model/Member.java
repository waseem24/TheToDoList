package com.todolist.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tblMember")
public class Member implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tblMember_Id", unique = true)
	private Long memberId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblMember_Name")
	private String name;
	
	@Size(min = 6, max = 13)
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblMember_Username", unique = true)
	private String username;
	
	@Size(min = 6, max = 16)
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblMember_Password")
	private String password;
	
	@Email
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblMember_Email", unique = true)
	private String email;
	
	@Column(name="tblMember_Image")
	private Blob image;
	
	@ManyToOne
	@JoinColumn(name="tblGroup_Id")
	private Group group;
		
	@OneToMany(mappedBy="member")
	private Set<Task> task;
		
	@OneToOne(mappedBy="member",cascade=CascadeType.ALL)
	private Performance performance;
	
	@ManyToMany
	@JoinTable(name="tblProgrammerRole",
			joinColumns=@JoinColumn(name="memberId"),
			inverseJoinColumns=@JoinColumn(name="roleId"))
    private Set<Role> roles;
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public Member() {
	}

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

	
	

}
