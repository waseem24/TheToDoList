package com.todolist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MailDetailDao;
import com.todolist.model.MailDetail;
import com.todolist.service.MailDetailService;

@Service("mailDetailService")
@Transactional(propagation=Propagation.SUPPORTS)
public class MailDetailServiceImpl implements MailDetailService {

	@Autowired
	private MailDetailDao mailDetailDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Long saveMailDetail(MailDetail mailDetail) {
		return mailDetailDao.saveMailDetail(mailDetail);
	}

	@Override
	@Transactional(readOnly=true)
	public MailDetail getMailDetail(Long mailId) {
		return mailDetailDao.getMailDetail(mailId);
	}
	
	

}
