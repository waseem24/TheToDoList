package com.todolist.viewtester;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;















import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.todolist.config.DatabaseAppConfig;
import com.todolist.controller.MemberController;
import com.todolist.model.Member;
import com.todolist.model.UserStatus;
import com.todolist.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseAppConfig.class})
@WebAppConfiguration
public class ViewTester {

	private MockMvc mockMvc;
	
	@InjectMocks
	private MemberController memberController;
		
	@Mock
	private MemberService memberService;
	
	private Member member;
		
	
	@Before
	public void setupMockController()
	{
		
		member = new Member();
		
		member.setName("Jive");
		member.setSurname("Sulman");
		member.setPassword("weinthis");
		member.setEmail("w@c.c");
		member.setGroup(null);
		member.setImage(null);
		member.setPerformance(null);
		member.setRoles(null);
		member.setStatus(UserStatus.ACTIVE);
		member.setTask(null);
		member.setUsername("jive"); 
		
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc =MockMvcBuilders.standaloneSetup(memberController).build();				
	}
	
	@Test
	public void test() throws Exception {
		
		when(memberService.saveMember(member));
		
		/*mockMvc.perform(get("/addMember"))
			.andExpect(status().isOk());*/
	}

}
