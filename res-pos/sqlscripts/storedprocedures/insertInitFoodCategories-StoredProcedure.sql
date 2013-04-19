delimiter //
CREATE PROCEDURE restaurant.insertInitFoodCategories()

BEGIN
	INSERT IGNORE INTO foodcategory(foodcategoryname, foodcategorycname)
		SELECT t.foodcategoryname, t.foodcategorycname FROM temp t;
END//
delimiter ;

