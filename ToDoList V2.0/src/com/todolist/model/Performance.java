package com.todolist.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tblPerformance")
public class Performance implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="member"))
	@GeneratedValue(generator="generator")
	@Column(name="tblPerformance_Id",unique=true,nullable=false)
	private Long performanceId;
	
	@NotNull
	@Column(name="tblPerformance_NoOfTasks")
	private int noOfTasks;
	
	@NotNull
	@Column(name="tblPerformance_CompletedTasks")
	private int completedTasks;
	
	@NotNull
	@Column(name="tblPerformance_NotCompleted")
	private int notCompletedTasks;
	
	@NotNull
	@Column(name="tblPerformance_ToBeCompleted")
	private int tasksToBeCompleted;
	
	@NotNull
	@Column(name="tblPerformance_PercentageCompletedTask")
	private double percentageCompletedTask;
	
	@NotNull
	@Column(name="tblPerformance_PercentageNotCompleted")
	private double percentageNotCompleted;
	
	@NotNull
	@Column(name="tblPerformance_GroupPerformance")
	private double groupPerformance;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Member member;
	
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Performance() {
	}

	public Long getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Long performanceId) {
		this.performanceId = performanceId;
	}

	public void setGroupPerformance(double groupPerformance) {
		this.groupPerformance = groupPerformance;
	}

	public int getNoOfTasks() {
		return noOfTasks;
	}

	public void setNoOfTasks(int noOfTasks) {
		this.noOfTasks = noOfTasks;
	}

	public int getCompletedTasks() {
		return completedTasks;
	}

	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	public int getNotCompletedTasks() {
		return notCompletedTasks;
	}

	public void setNotCompletedTasks(int notCompletedTasks) {
		this.notCompletedTasks = notCompletedTasks;
	}

	public int getTasksToBeCompleted() {
		return tasksToBeCompleted;
	}

	public void setTasksToBeCompleted(int tasksToBeCompleted) {
		this.tasksToBeCompleted = tasksToBeCompleted;
	}

	public double getGroupPerformance() {
		return groupPerformance;
	}

	public double getPercentageCompletedTask() {
		return percentageCompletedTask;
	}

	public void setPercentageCompletedTask(double percentageCompletedTask) {
		this.percentageCompletedTask = percentageCompletedTask;
	}

	public double getPercentageNotCompleted() {
		return percentageNotCompleted;
	}

	public void setPercentageNotCompleted(double percentageNotCompleted) {
		this.percentageNotCompleted = percentageNotCompleted;
	}

	
	
	
}
