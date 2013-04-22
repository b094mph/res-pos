package com.res.test.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.model.FoodCategory;
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
		List<Long> fcList = menuService.getFoodCategoryIdsFromMenu(1L);
		assertEquals(18 ,fcList.size());
	}
	
	@Test
	public void getFoodCategoriesForMenuTest(){
		List<FoodCategory> fcSet =  menuService.getFoodCategoriesFromMenu(1L);
		assertEquals(18, fcSet.size());
		for(FoodCategory fc : fcSet){
			System.out.println("foodcategoryid = " + fc.getFoodCategoryId() + 
					" foodcategoryname = " + fc.getFoodCategoryName() +
					" foodcategorycname = " + fc.getFoodCategoryCName());
		}
		
	}

}
