DELIMITER //
CREATE PROCEDURE restaurant.createTables()
BEGIN

CREATE TABLE IF NOT EXISTS address (
    addressid BIGINT(11) NOT NULL AUTO_INCREMENT,
    street1 VARCHAR(40) NOT NULL,
    street2 VARCHAR(40),
    city VARCHAR(20) NOT NULL,
    state VARCHAR(2),
    zipcode VARCHAR(5),
    PRIMARY KEY (addressid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS foodcategory (
    foodcategoryid BIGINT(11) NOT NULL AUTO_INCREMENT,
    foodcategoryname VARCHAR(30) NOT NULL UNIQUE,
	foodcategorycname VARCHAR(10),
    PRIMARY KEY (foodcategoryid),
	UNIQUE INDEX(foodcategoryname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS food (
    foodid BIGINT(11) NOT NULL AUTO_INCREMENT,
    foodshortname VARCHAR(50) NOT NULL UNIQUE,
    foodlongname VARCHAR(80),
    cfoodname VARCHAR(10),
    description VARCHAR(500),
	cdescription VARCHAR(500),
    PRIMARY KEY (foodid),
	UNIQUE INDEX(foodshortname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS person (
    personid BIGINT(11) NOT NULL AUTO_INCREMENT,
    addressid BIGINT(11),
    firstname VARCHAR(20),
    lastname VARCHAR(20),
    phone1 VARCHAR(10) NOT NULL,
	phone2 VARCHAR(10),
	ext VARCHAR(5),
	email VARCHAR(50),
    note TEXT,
	lastupdateddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	lastupdatedby VARCHAR(20),
    PRIMARY KEY (personid),
	CONSTRAINT fk_person_address FOREIGN KEY person(addressid) REFERENCES address(addressid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS restaurant (
    restaurantid BIGINT(11) NOT NULL AUTO_INCREMENT,
    addressid BIGINT(11) NOT NULL,
    personid BIGINT(11) NOT NULL,
    restaurantname VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    phone1 VARCHAR(10) NOT NULL UNIQUE,
    phone2 VARCHAR(10),
	faxnumber VARCHAR(12),
	deliverycost FLOAT,
	tax FLOAT,
	rounding TINYINT(1),
	montothrusopen VARCHAR(8) NOT NULL,
	montothursclose VARCHAR(8) NOT NULL,
	friopen VARCHAR(8) NOT NULL,
	friclose VARCHAR(8) NOT NULL,
	satopen VARCHAR(8) NOT NULL, 
	satclose VARCHAR(8) NOT NULL,
	sunopen VARCHAR(8) NOT NULL,
	sunclose VARCHAR(8) NOT NULL,
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate DATETIME,
	lastupdatedby VARCHAR(20),
	PRIMARY KEY (restaurantid),
	UNIQUE INDEX(phone1),
	CONSTRAINT fk_restaurant_address FOREIGN KEY (addressid) REFERENCES address (addressid) ON DELETE CASCADE,
	CONSTRAINT fk_restaurant_person FOREIGN KEY (personid) REFERENCES person (personid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS users(
	username VARCHAR(50) NOT NULL,
	password VARCHAR(64) NOT NULL,
	salt VARCHAR(48) NOT NULL,
	firstname VARCHAR(30),
    lastname VARCHAR(50),
	enabled TINYINT(1) NOT NULL,
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate DATETIME,
	lastupdatedby VARCHAR(20),
	PRIMARY KEY (username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS authorities(
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate DATETIME,
	lastupdatedby VARCHAR(20),
	PRIMARY KEY (username, authority),
	UNIQUE INDEX(username, authority),
	CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS agentjob (
    agentjobid BIGINT(11) NOT NULL AUTO_INCREMENT,
    restaurantid BIGINT(11) NOT NULL,
	username VARCHAR(50) NOT NULL,
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate DATETIME,
	lastupdatedby VARCHAR(20),
    PRIMARY KEY (agentjobid),
	CONSTRAINT fk_agentjob_restaurant FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid) ON DELETE CASCADE,
	CONSTRAINT fk_agentjob_users FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS menu (
    menuid BIGINT(11) NOT NULL AUTO_INCREMENT,
    restaurantid BIGINT(11) NOT NULL,
	foodcategoryid BIGINT(11) NOT NULL,
    foodid BIGINT(11) NOT NULL,
    menunum VARCHAR(5) NULL,
    small FLOAT,
	large FLOAT,
	lunchnum VARCHAR(5) NULL,
	lunch FLOAT,
	combonum VARCHAR(5) NULL,
	combo FLOAT,
	spicy TINYINT(1) DEFAULT '0',
	rice TINYINT(1) DEFAULT '0',
	sauce TINYINT(1) DEFAULT '0',
	noodle TINYINT(1) DEFAULT '0',
	pieces SMALLINT DEFAULT NULL,
	appetizercombo TINYINT(1),
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate DATETIME,
	lastupdatedby VARCHAR(20),
    PRIMARY KEY (menuid),
	CONSTRAINT fk_menu_restaurant FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid) ON DELETE CASCADE,
	CONSTRAINT fk_menu_foodcategory FOREIGN KEY menu(foodcategoryid) REFERENCES foodcategory(foodcategoryid) ON DELETE CASCADE,
	CONSTRAINT fk_menu_food FOREIGN KEY (foodid) REFERENCES food (foodid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS cardtype (
	cardtypeid BIGINT(11) NOT NULL AUTO_INCREMENT,
	cardname VARCHAR(50) NOT NULL UNIQUE,
	PRIMARY KEY (cardtypeid),
	UNIQUE INDEX(cardname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS creditcard (
	creditcardid BIGINT(11) NOT NULL AUTO_INCREMENT,
	personid BIGINT(11) NOT NULL,
	addressid BIGINT(11),
	cardtypeid BIGINT(11),
	creditcardending VARCHAR(4) NOT NULL,
	creditcardnum VARCHAR(19) NOT NULL,
	creditcardname VARCHAR(50) NOT NULL,
	expiration DATE NOT NULL,
	ccv VARCHAR(3),
	PRIMARY KEY (creditcardid),
	UNIQUE(creditcardnum),
	CONSTRAINT fk_creditcard_person FOREIGN KEY(personid) REFERENCES person(personid) ON DELETE CASCADE,
	CONSTRAINT fk_creditcard_address FOREIGN KEY(addressid) REFERENCES address(addressid) ON DELETE CASCADE,
	CONSTRAINT fk_creditcard_cardtype FOREIGN KEY(cardtypeid) REFERENCES cardtype(cardtypeid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS customerorder (
    customerorderid BIGINT(11) NOT NULL AUTO_INCREMENT,
    restaurantid BIGINT(11) NOT NULL,
    username VARCHAR(50) NOT NULL,
	personid BIGINT(11) NOT NULL,
	creditcardid BIGINT(11),
    orderoption TINYINT(1) NOT NULL,
    ordertime TIMESTAMP NOT NULL,
	subtotal FLOAT NOT NULL,
	tax FLOAT,
	grandtotal FLOAT NOT NULL,
	tip FLOAT,
	orderstatus VARCHAR(10),
	note VARCHAR(200),
    PRIMARY KEY (customerorderid),
	CONSTRAINT fk_customerorder_restaurant FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid) ON DELETE CASCADE,
	CONSTRAINT fk_customerorder_users FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE,
	CONSTRAINT fk_customerorder_person FOREIGN KEY (personid) REFERENCES person (personid) ON DELETE CASCADE,
	CONSTRAINT fk_customerorder_creditcard FOREIGN KEY (creditcardid) REFERENCES creditcard (creditcardid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS orderdetail (
	orderdetailid BIGINT(11) NOT NULL AUTO_INCREMENT,
	customerorderid BIGINT(11) NOT NULL,
	menuid BIGINT(11) NOT NULL,
	quantity INT NOT NULL,
	note VARCHAR(200),
	PRIMARY KEY (orderdetailid),
	CONSTRAINT fk_orderdetail_menu FOREIGN KEY(menuid) REFERENCES menu(menuid) ON DELETE CASCADE,
	CONSTRAINT fk_orderdetail_customerorder FOREIGN KEY(customerorderid) REFERENCES customerorder(customerorderid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

/* this temp table is used for data conversion*/
CREATE TABLE IF NOT EXISTS temp(
	id BIGINT(11) NOT NULL AUTO_INCREMENT,
   foodcategoryname VARCHAR(30) NOT NULL,
   foodcategorycname VARCHAR(10),
	foodshortname VARCHAR(50) NOT NULL,
    foodlongname VARCHAR(80),
    cfoodname VARCHAR(10),
    description VARCHAR(500),
	cdescription VARCHAR(500),
	menunum VARCHAR(5) NULL,
    small FLOAT DEFAULT NULL,
	large FLOAT DEFAULT NULL,
	lunchnum VARCHAR(5) NULL,
	lunch FLOAT DEFAULT NULL,
	combonum VARCHAR(5) NULL,
	combo FLOAT DEFAULT NULL,
	spicy TINYINT(1) DEFAULT '0',
	rice TINYINT(1) DEFAULT '0',
	sauce TINYINT(1) DEFAULT '0',
	noodle TINYINT(1) DEFAULT '0',
	pieces SMALLINT DEFAULT NULL,
	appetizercombo TINYINT(1) NULL,
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

END //
DELIMITER ;
