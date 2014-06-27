package com.todolist.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todolist.dao.MailDetailDao;
import com.todolist.model.MailDetail;

@Repository("mailDetailDao")
public class MailDetailDaoImpl implements MailDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Long saveMailDetail(MailDetail mailDetail) {
		sessionFactory.getCurrentSession().save(mailDetail);
		return mailDetail.getMailId();
	}

	@Override
	public MailDetail getMailDetail(Long mailId) {
		return (MailDetail) sessionFactory.getCurrentSession().createQuery("from MailDetail where mailId="+mailId).uniqueResult();
		
	}

}
