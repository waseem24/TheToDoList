package com.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MemberDao;
import com.todolist.model.Member;
import com.todolist.service.MemberService;

@Service("memberService")
@Transactional(propagation = Propagation.SUPPORTS)
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Long saveMember(Member member) {
		
		return memberDao.saveMember(member);
	}

	@Transactional(readOnly=false)
	public Long updateMember(Member member) {
		
		return memberDao.updateMember(member);
	}

	@Transactional(readOnly=true)
	public Member findMemberByName(String username) {
		
		return memberDao.findMemberByName(username);
	}

	@Transactional(readOnly=true)
	public List<Member> getAllMembers() {
		
		return memberDao.getAllMembers();
	}

	@Transactional(readOnly=true)
	public Member getMember(Long memberId) {
		
		return memberDao.getMember(memberId);
	}
}
