package com.todolist.service;

import java.util.List;

import com.todolist.model.Meeting;

public interface MeetingService {
	Long saveMeeting(Meeting meeting);
	Long updateMeeting(Meeting meeting);
	List<Meeting> listMeeting();
	Meeting getMeeting(Long meetingId);
}
