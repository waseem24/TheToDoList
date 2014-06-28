package com.todolist.dao;

import java.util.List;

import com.todolist.model.Meeting;

public interface MeetingDao {
	Long saveMeeting(Meeting meeting);
	Long updateMeeting(Meeting meeting);
	List<Meeting> listMeeting();
	Meeting getMeeting(Long meetingId);
}
