package com.todolist.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tblTask")
public class Task implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tblTask_Id")
	private Long taskId;
	
	@NotNull
	@Column(name="tblTask_Description")
	private String description;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tblTask_StartTime")
	private Date startTime;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tblTask_FinishTime")
	private Date finishTime;
	
	@NotNull
	@Column(name="tblTask_Comment")
	private String comment;
	
	@NotNull
	@Column(name="tblTask_TaskDone")
	private Boolean isDone;
	
	@ManyToOne
	@JoinColumn(name="tblMember_MemberId")
	private Member member;
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Task() {
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	

}
