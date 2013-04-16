package com.res.test.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.dao.hibernate.MenuDao;
import com.res.model.Menu;

public class MenuDaoImplTest{
	
	private ApplicationContext ctx;
	private MenuDao menuDao;
	
	@Before
	public void setUp(){
		ctx = new ClassPathXmlApplicationContext("junit-context.xml");
		menuDao = (MenuDao) ctx.getBean("menuDao");
	}
	
	@Test
	public void menuByRestaurantIdTest(){
		//TODO: need to make dao classes transactional to run unit tests
		List<Menu> menuList = menuDao.menuByRestaurantId(1L);
		assertTrue(!menuList.isEmpty());
	}

}
