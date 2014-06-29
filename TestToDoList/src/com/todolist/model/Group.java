package com.todolist.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tblGroup")
public class Group implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tblGroup_Id", unique = true)
	private Long groupId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblGroup_Name")
	private String name;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblGroup_ProjectName")
	private String projectName;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblGroup_ProjectDescription")
	private String description;
	
	
	@OneToMany(mappedBy="group",cascade = CascadeType.ALL)
	private Set<Member> member;

	
	public Set<Member> getMember() {
		return member;
	}

	public void setMember(Set<Member> member) {
		this.member = member;
	}

	public Group() {
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

	

}
