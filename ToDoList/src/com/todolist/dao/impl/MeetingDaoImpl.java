package com.todolist.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MeetingDao;
import com.todolist.model.Meeting;
@Repository("meetingDao")
@Transactional(propagation=Propagation.SUPPORTS)
public class MeetingDaoImpl implements MeetingDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public Long saveMeeting(Meeting meeting) {
		sessionFactory.getCurrentSession().save(meeting);
		return meeting.getMeetingId();
	}

	@Transactional(readOnly=false)
	public Long updateMeeting(Meeting meeting) {
		sessionFactory.getCurrentSession().update(meeting);
		return meeting.getMeetingId();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Meeting> listMeeting() {
		
		return (List<Meeting>)sessionFactory.getCurrentSession().createCriteria(Meeting.class).list();
	}

	@Transactional(readOnly=true)
	public Meeting getMeeting(Long meetingId) {
		
		return (Meeting) sessionFactory.getCurrentSession().get(Meeting.class, meetingId);
	}

}
