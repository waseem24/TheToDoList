package com.todolist.service;

import com.todolist.model.MailDetail;

public interface MailDetailService {
	public Long saveMailDetail(MailDetail mailDetail);
	public MailDetail getMailDetail(Long mailId);
}
