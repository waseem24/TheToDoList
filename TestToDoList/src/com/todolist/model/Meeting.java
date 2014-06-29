package com.todolist.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tblMeeting")
public class Meeting implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tblMeeting_Id", unique=true)
	private Long meetingId;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tblDate_of_Meeting")
	private Date dateOfMeeting;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tblTime_Meeting")
	private Date timeOfMeeting;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblPlace_Of_Meeting")
	private String placeOfMeeting;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblAgenda")
	private String agenda;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="tblDiscussion")
	private String discussion;
	
	
	public Meeting() {
	}

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public Date getDateOfMeeting() {
		return dateOfMeeting;
	}

	public void setDateOfMeeting(Date dateOfMeeting) {
		this.dateOfMeeting = dateOfMeeting;
	}

	public Date getTimeOfMeeting() {
		return timeOfMeeting;
	}

	public void setTimeOfMeeting(Date timeOfMeeting) {
		this.timeOfMeeting = timeOfMeeting;
	}

	public String getPlaceOfMeeting() {
		return placeOfMeeting;
	}

	public void setPlaceOfMeeting(String placeOfMeeting) {
		this.placeOfMeeting = placeOfMeeting;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getDiscussion() {
		return discussion;
	}

	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}
	
	
	
	
}
