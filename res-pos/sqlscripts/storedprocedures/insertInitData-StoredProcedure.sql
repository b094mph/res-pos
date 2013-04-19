DELIMITER //
CREATE PROCEDURE restaurant.insertInitData()
BEGIN
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
END//
DELIMITER ;