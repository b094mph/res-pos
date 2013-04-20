package com.res.test.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.service.AgentService;

public class AgentServiceImplTest {
	
	private ApplicationContext ctx;
	private AgentService agentService;
	
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("junit-context.xml");
		agentService = (AgentService) ctx.getBean("agentService");
	}
	
	@Test
	public void isPasswordValidTest(){
		assertTrue(agentService.isPasswordValid("bthai", "123"));
	}

}
