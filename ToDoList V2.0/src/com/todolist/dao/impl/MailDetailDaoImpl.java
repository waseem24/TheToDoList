package com.todolist.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MailDetailDao;
import com.todolist.model.MailDetail;

@Repository("mailDetailDao")
@Transactional(propagation = Propagation.SUPPORTS)
public class MailDetailDaoImpl implements MailDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly = false,propagation =Propagation.REQUIRED)
	public Long saveMailDetail(MailDetail mailDetail) {
		
		sessionFactory.getCurrentSession().save(mailDetail);
		
		return mailDetail.getMailId();
	}

	@Transactional(readOnly = true)
	public MailDetail getMailDetail(Long mailId) {
		
		return (MailDetail) sessionFactory.getCurrentSession().get(MailDetail.class,mailId);
		
	}

}
