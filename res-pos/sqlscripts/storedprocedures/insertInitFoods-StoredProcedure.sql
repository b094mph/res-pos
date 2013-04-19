DELIMITER //
CREATE PROCEDURE restaurant.insertInitFoods()
BEGIN
	INSERT IGNORE INTO food(foodshortname, foodlongname, cfoodname, description, cdescription)
		SELECT t.foodshortname, t.foodlongname, t.cfoodname, t.description, t.cdescription 
		FROM temp t;
END//
DELIMITER ;