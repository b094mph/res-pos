/* Dump menu.csv file into temp table. this chinese menu contains everything 
about the restuarant's menu. we will use this temp table and put the 
information in the correct table - foodcategory, food and menu tables.
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
INSERT IGNORE INTO foodcategory(foodcategoryname, foodcategorycname)
	SELECT t.foodcategoryname, t.foodcategorycname FROM temp t;
INSERT IGNORE INTO food(foodshortname, foodlongname, cfoodname, description, cdescription)
	SELECT t.foodshortname, t.foodlongname, t.cfoodname, t.description, t.cdescription 
	FROM temp t;
INSERT IGNORE INTO agent(username, firstname, lastname, agentpassword, createdby)
	VALUES('bthai', 'bobby', 'thai', '123', 'admin');
INSERT IGNORE INTO address(street1, city, state, zipcode) 
	VALUES('100 Main Street', 'Flushing', 'NY', '11355');
INSERT IGNORE INTO person(firstname, lastname, phone1)
	VALUES('Uncle', 'John', '3473338987');
INSERT INTO restaurant(addressid, personid, restaurantname, location, phone1, 
		phone2,deliverycost,tax, rounding)
	VALUES(1,1,'Uncle John\'s', 'across kfc', '7163239830',
		'7163239831', 1.00, 0.08, 0);
INSERT IGNORE INTO menu(restaurantid, foodcategoryid, foodid, 
		menunum, small, large, lunchnum, lunch, combonum, combo, 
		spicy, rice, sauce, noodle, pieces, appetizercombo, createdby)
	SELECT 1 as restaurantid, fc.foodcategoryid, f.foodid, t.menunum, t.small, t.large,
		t.lunchnum, t.lunch, t.combonum, t.combo, t.spicy, t.rice, t.sauce,
		t.noodle, t.pieces, t.appetizercombo, 'dataconversion'
	FROM temp t
	INNER JOIN foodcategory fc ON fc.foodcategoryname=t.foodcategoryname
	INNER JOIN food f ON f.foodshortname=t.foodshortname
	ORDER BY t.id;
DROP TABLE IF EXISTS temp;
COMMIT;	