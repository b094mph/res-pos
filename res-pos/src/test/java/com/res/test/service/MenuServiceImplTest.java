package com.res.test.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.res.constant.ResConstant;
import com.res.domain.FoodCategory;
import com.res.domain.Menu;
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
		List<Long> ids = menuService.getFoodCategoryIdsFromMenu(ResConstant.NEW_CITY_CHINESE_ID);
		assertEquals(18 , ids.size());
		for(Long id : ids){
			System.out.println("foodCategoryId = " + id);
		}
	}
	
	@Test
	public void getFoodCategoriesForMenuTest(){
		List<FoodCategory> foodCategories =  menuService.getFoodCategoriesFromMenu(ResConstant.NEW_CITY_CHINESE_ID);
		assertEquals(18, foodCategories.size());
		for(FoodCategory fc : foodCategories){
			System.out.println("foodcategoryid = " + fc.getFoodCategoryId() + 
					" foodcategoryname = " + fc.getFoodCategoryName() +
					" foodcategorycname = " + fc.getFoodCategoryCName());
		}
	}
	
	@Test
	public void getMenuByFoodCategoryTest(){
		List<Menu> subMenus = menuService.getMenuByFoodCategory(ResConstant.NEW_CITY_CHINESE_ID, 2L);
		assertEquals(20, subMenus.size());
		//TODO: nulls in menu.getFoodCategory() 
		for(Menu menu : subMenus){
			System.out.println(menu.getFoodCategory().getFoodCategoryName() + " : " + menu.getFood().getFoodShortName());
		}
	}

}
