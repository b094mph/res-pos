DELIMITER //
CREATE PROCEDURE restaurant.insertInitData()
BEGIN
	INSERT IGNORE INTO users (username, password, salt, firstname, enabled, createdby) 
		VALUES ('admin', 'b0b65c379234be44f406b8a0c418d679568230d1870fde1d4eb115db4079ad3c', 'bfbaf639c79f06ca22556c5bb59def6ebea816eb37801787','admin', 1,'admin');
	INSERT IGNORE INTO users (username, password, salt, firstname, lastname, enabled, createdby) 
		VALUES ('bthai', '33078addb707e266404407af29e8205c570efd7a8aeab421b06d8dca70c592e8','daee01bac2ff29e976116fa3d6515c51fddea2917b57c4b5','bobby', 'thai', 1,'admin');
	INSERT IGNORE INTO authorities(username, authority,createdby) 
		VALUES('admin', 'ROLE_ADMIN', 'admin');
	INSERT IGNORE INTO authorities(username, authority,createdby) 
		VALUES('admin', 'ROLE_USER', 'admin');
	INSERT IGNORE INTO authorities(username, authority,createdby) 
		VALUES('bthai', 'ROLE_USER', 'admin');
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