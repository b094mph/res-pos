DELIMITER //
CREATE PROCEDURE restaurant.insertInitData()
BEGIN
	INSERT IGNORE INTO users (username, password, firstname, enabled, createdby) 
		VALUES ('admin', 'admin123','admin', 1,'admin');
	INSERT IGNORE INTO users (username, password, firstname, lastname, enabled, createdby) 
		VALUES ('bthai', 'bt123','bobby', 'thai', 1,'admin');
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