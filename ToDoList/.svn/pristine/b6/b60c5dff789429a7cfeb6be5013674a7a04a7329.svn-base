package com.todolist.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.dao.MemberDao;
import com.todolist.model.Member;
import com.todolist.model.Role;
import com.todolist.model.UserStatus;
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Member member = memberDao.findMemberByName(username); //our own User model class
		
		if(member!=null){
			String password = member.getPassword();
			//additional information on the security object
			boolean enabled = member.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired = member.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired = member.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked = member.getStatus().equals(UserStatus.ACTIVE);
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : member.getRoles()){
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			
			//Now let's create Spring Security User object
			User securityUser = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User Not Found!!!");
		}
	}

}
