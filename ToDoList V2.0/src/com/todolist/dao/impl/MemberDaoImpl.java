package com.todolist.dao.impl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MemberDao;
import com.todolist.model.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Long saveMember(Member member) {
		
		sessionFactory.getCurrentSession().save(member);
		
		return member.getMemberId();
	}

	public Long updateMember(Member member) {
		
		sessionFactory.getCurrentSession().update(member);
		
		return member.getMemberId();
	}

	@Transactional(readOnly = true)
	public Member findMemberByName(String username) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Member.class);
		
		criteria.add(Restrictions.eq("username", username));		
		
		return (Member) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Member> getAllMembers() {
		
		return sessionFactory.getCurrentSession().createQuery("from Member").list();	}

	public Member getMember(Long memberId) {
		
		return (Member) sessionFactory.getCurrentSession().get(Member.class, memberId);
	}	
}
