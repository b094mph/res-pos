package com.res.test.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.model.Menu;
import com.res.service.MenuService;

public class MenuServiceImplTest{
	
	private ApplicationContext ctx;
	private MenuService menuService;
	
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("junit-context.xml");
		menuService = (MenuService) ctx.getBean("menuService");
	}
	
	@Test
	public void menuByRestaurantIdTest(){
		
	}

}
