DELIMITER //
CREATE PROCEDURE restaurant.insertInitMenu()
BEGIN
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
END //
DELIMITER ;