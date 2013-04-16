package com.res.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.dao.hibernate.AgentDao;
import com.res.model.Agent;

public class AgentDaoImplTest {
	
	private ApplicationContext ctx;
	private AgentDao agentDao;
	
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("junit-context.xml");
		agentDao = (AgentDao) ctx.getBean("agentDao");
	}
	
	@Test
	public void isPasswordValidTest(){
		//TODO: need a way to make daos transactional for this unit test to work.
		Agent agent = agentDao.getAgentById(1L);
		assertEquals("bobby", agent.getUserName());
	}

}
