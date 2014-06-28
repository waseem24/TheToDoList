package com.todolist.tester;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todolist.config.DatabaseAppConfig;
import com.todolist.dao.GroupDao;
import com.todolist.dao.MemberDao;
import com.todolist.dao.PerformanceDao;
import com.todolist.dao.RoleDao;
import com.todolist.dao.TaskDao;
import com.todolist.model.Group;
import com.todolist.model.Member;
import com.todolist.model.Performance;
import com.todolist.model.Role;
import com.todolist.model.Task;
import com.todolist.model.UserStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseAppConfig.class})
@WebAppConfiguration
public class MemberTest {
	
	@Autowired
	private MemberDao memberDao;
	private Member member;
	Long memberId = 0L;
	List<Member> memberList = null;
	
	@Autowired
	private TaskDao taskDao;
	private Task task;
	Long taskId = 0L;
	List<Task> taskList = null;
	boolean isDone = false;
	Set<Task> taskSet = new HashSet<Task>();
	
	@Autowired
	private RoleDao roleDao;
	private Role role;
	Long roleId = 0L;
	List<Role> roleList = null;
	List<Member> roleMember = null;
	Set<Role> roleSet = new HashSet<Role>();
	
	@Autowired
	private GroupDao groupDao;
	private Group group;
	Long groupId = 0L;
	List<Group> groupList = null;
	Set<Member> groupMember = new HashSet<Member>();
	
	@Autowired
	private PerformanceDao performanceDao;
	private Performance performance;
	Long perfromanceId = 0L;
	List<Performance> performannceList = null;
	
	@Before
	public void setMember() throws ParseException
	{
		isDone = true;
				
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
		Date startTime = sdf.parse("2014-06-27");
		Date finishTime = sdf.parse("2014-06-30");
		
		 //Initializing task   	
		task = new Task();
				
		task.setStartTime(startTime);
		task.setFinishTime(finishTime);
		task.setDescription("write a method to calculate average of task completed");
		task.setComment("insert comment here");
		task.setIsDone(isDone);
		
		//Initializing performance
		
		performance = new Performance();
		
		performance.setCompletedTasks(0);
		performance.setGroupPerformance(0.00);		
		performance.setNoOfTasks(1);
		performance.setNotCompletedTasks(0);
		performance.setPercentageCompletedTask(0.00);
		performance.setPercentageNotCompleted(0.00);
		performance.setTasksToBeCompleted(0);

		
		//Initializing role
		role = new Role();
				
		role.setRoleName("ROLE_Admhuwgs");
		
				
		//Initializing Group
		group = new Group();
		
		group.setName("HR");
		group.setDescription("Annotate all the instance variables");
		group.setProjectName("Model-Pojos");
			
		
		//Initializing Member
		member = new Member();
		
		member.setName("Jimmy");
		member.setSurname("Kimmu");
		member.setEmail("jbwstqs@a8n5d.com");
		member.setUsername("jamy7de75s");
		member.setPassword("jamybs6ldas");
		member.setStatus(UserStatus.ACTIVE);
		
		//setting all mapped relationships
		
		roleMember = new ArrayList<Member>();
		roleMember.add(member);
		
		roleSet.add(role);
		
		groupMember.add(member);
		
		taskSet.add(task);
						
		member.setImage(null);
		
		
	}
	
	
	@Test
	public void test()
	{				
		
		assertNotNull("Task has data",task);
		
		taskId = taskDao.saveTask(task);
		
		assertTrue("Task Id was persisted",taskId > 0L);
		
		task.setMember(member);
		member.setTask(taskSet);
				
		assertNotNull("Role has data", role);
		
		roleId = roleDao.saveRole(role);
		
		assertTrue("Role was persisted",roleId > 0L);

		role.setMembers(roleMember);
		member.setRoles(roleSet);
		
		assertNotNull("Group is populated",group);
		
		groupId = groupDao.saveGroup(group);
				
		assertTrue("Group was persisted",groupId > 0L);
		
		group.setMember(groupMember);
		member.setGroup(group);
						
		assertNotNull("Member has data", member);
		
		memberId = memberDao.saveMember(member);
		
		assertTrue("Member Id was persisted ",memberId > 0L);

		assertNotNull("Performance has data",performance);
		
		member.setPerformance(performance);
		performance.setMember(member);
		
		perfromanceId = performanceDao.savePerformance(performance);
		
		assertTrue("Perfromance was persisted", perfromanceId > 0L);
	
		
		
		/*memberList = memberDao.getAllMembers();
		
		for(Member m : memberList)
		{
			System.out.println(""+m.getEmail());
		}*/
				
	}
	
	
	@After
	public void destroy()
	{
		member = null;
		memberDao = null;
		memberId = null;
		memberList = null;
		
		taskDao = null;
		task = null;
		taskId = null;
		taskList = null;
		
		roleDao = null;
		role = null;
		roleId = null;
		roleList = null;
		
		groupDao = null;
		group = null;
		groupId = null;
		groupList = null;
		
		performanceDao = null;
		performance = null;
		perfromanceId = null;
		performannceList = null;
		
	}
	
}
