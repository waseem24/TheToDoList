package com.todolist.dao;

import com.todolist.model.MailDetail;

public interface MailDetailDao {

	public Long saveMailDetail(MailDetail mailDetail);
	public MailDetail getMailDetail(Long mailId);
}
