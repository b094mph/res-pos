/* Dump menu.csv file into temp table. this chinese menu contains everything 
about the restuarant's menu. we will use this temp table and put the 
information in the correct table - foodcategory, food and menu tables.
This script can be run once the stored procedures have been created.
*/
USE restaurant;
START TRANSACTION;
LOAD DATA INFILE 'newcitychinese-menu.csv'
	IGNORE
	INTO TABLE temp
	CHARACTER SET UTF8
	FIELDS TERMINATED BY ','
	LINES TERMINATED BY '\n'
	(foodcategoryname, foodcategorycname, foodshortname, foodlongname, cfoodname,
		description, cdescription, menunum, small, large, 
		lunchnum, lunch, combonum, combo, spicy, rice, sauce, noodle,
		pieces, appetizercombo);

CALL insertInitFoodCategories;
CALL insertInitFoods;
CALL insertInitData;
CALL insertInitMenu;

	/* need to insert dummy combination subcategory into menu since
	 * new city chinese do not have a menu dish that is ONLY a combination. This is
	 * needed in order to see combination as a food category in the order screen.*/
	INSERT INTO foodcategory (foodcategoryname) VALUES('Combination');
	INSERT INTO menu (restaurantid, foodcategoryid, foodid) VALUES(1,19,1);

COMMIT;	
