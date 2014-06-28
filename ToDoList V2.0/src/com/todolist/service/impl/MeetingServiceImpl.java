package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MeetingDao;
import com.todolist.model.Meeting;
import com.todolist.service.MeetingService;
@Service("meetingService")
@Transactional(propagation=Propagation.REQUIRED)
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	private MeetingDao meetingDao;
	
	public Long saveMeeting(Meeting meeting) {
	
		return meetingDao.saveMeeting(meeting);
	}

	
	public Long updateMeeting(Meeting meeting) {
		
		return meetingDao.updateMeeting(meeting);
	}


	public List<Meeting> listMeeting() {
		
		return meetingDao.listMeeting();
	}

	
	public Meeting getMeeting(Long meetingId) {
	
		return meetingDao.getMeeting(meetingId);
	}

}
