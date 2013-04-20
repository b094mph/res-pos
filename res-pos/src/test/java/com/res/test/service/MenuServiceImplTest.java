package com.res.test.service;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	public void getFoodCategoriesFromMenuTest(){
		Set<Long> foodCategorySet = menuService.getFoodCategoriesFromMenu(1L);
		assertEquals(18 ,foodCategorySet.size());
	}

}
