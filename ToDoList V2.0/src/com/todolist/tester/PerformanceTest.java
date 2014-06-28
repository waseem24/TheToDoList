package com.todolist.tester;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todolist.config.DatabaseAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseAppConfig.class})
@WebAppConfiguration
public class PerformanceTest {

	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
