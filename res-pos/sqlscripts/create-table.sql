/*CREATE SCHEMA restaurant;*/

USE restaurant;

CREATE TABLE IF NOT EXISTS address (
    addressid bigint(11) NOT NULL AUTO_INCREMENT,
    street1 varchar(40) NOT NULL,
    street2 varchar(40),
    city varchar(20) NOT NULL,
    state varchar(2),
    zipcode varchar(5),
    PRIMARY KEY (addressid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS foodcategory (
    foodcategoryid bigint(11) NOT NULL AUTO_INCREMENT,
    foodcategoryname varchar(30) NOT NULL UNIQUE,
	foodcategorycname varchar(10),
    PRIMARY KEY (foodcategoryid),
	UNIQUE INDEX(foodcategoryname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS food (
    foodid bigint(11) NOT NULL AUTO_INCREMENT,
    foodshortname varchar(30) NOT NULL UNIQUE,
    foodlongname varchar(50),
    cfoodname varchar(10),
    description varchar(500),
	cdescription varchar(500),
    PRIMARY KEY (foodid),
	UNIQUE INDEX(foodshortname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS person (
    personid bigint(11) NOT NULL AUTO_INCREMENT,
    addressid bigint(11),
    firstname varchar(20),
    lastname varchar(20),
    phone1 varchar(10) NOT NULL,
	phone2 varchar(10),
	email varchar(50),
    note text,
	lastupdateddate timestamp default current_timestamp,
	lastupdatedby varchar(20),
    PRIMARY KEY (personid),
	CONSTRAINT fk_person_address FOREIGN KEY person(addressid) REFERENCES address(addressid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS restaurant (
    restaurantid bigint(11) NOT NULL AUTO_INCREMENT,
    addressid bigint(11) NOT NULL,
    personid bigint(11) NOT NULL,
    restaurantname varchar(100) NOT NULL,
    location varchar(100) NOT NULL,
    phone1 varchar(10) NOT NULL UNIQUE,
    phone2 varchar(10),
	faxnumber varchar(12),
	deliverycost float,
	tax float,
	rounding tinyint(1),
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
	lastupdateddate TIMESTAMP,
	lastupdatebBy VARCHAR(20),
    PRIMARY KEY (restaurantid),
	UNIQUE INDEX(phone1),
	CONSTRAINT fk_restaurant_address FOREIGN KEY (addressid) REFERENCES address (addressid) ON DELETE CASCADE,
	CONSTRAINT fk_restaurant_person FOREIGN KEY (personid) REFERENCES person (personid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS agent (
    agentid bigint(11) NOT NULL AUTO_INCREMENT,
	username varchar(20) NOT NULL,
    firstname varchar(20) NOT NULL,
    lastname varchar(20) NOT NULL,
    agentpassword varchar(30) NOT NULL,
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate TIMESTAMP,
	lastupdatebBy VARCHAR(20),
    PRIMARY KEY (agentid),
	UNIQUE INDEX (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS agentjob (
    agentjobid bigint(11) NOT NULL AUTO_INCREMENT,
    restaurantid bigint(11) NOT NULL,
	agentid bigint(11) NOT NULL,
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate TIMESTAMP,
	lastupdatebBy VARCHAR(20),
    PRIMARY KEY (agentjobid),
	CONSTRAINT fk_agentjob_restaurant FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid) ON DELETE CASCADE,
	CONSTRAINT fk_agentjob_agent FOREIGN KEY (agentid) REFERENCES agent (agentid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS menu (
    menuid bigint(11) NOT NULL AUTO_INCREMENT,
    restaurantid bigint(11) NOT NULL,
	foodcategoryid bigint(11) NOT NULL,
    foodid bigint(11) NOT NULL,
    menunum varchar(5) NULL,
    small float,
	large float,
	lunchnum varchar(5) NULL,
	lunch float,
	combonum varchar(5) NULL,
	combo float,
	spicy BOOLEAN DEFAULT '0',
	rice BOOLEAN DEFAULT '0',
	sauce BOOLEAN DEFAULT '0',
	noodle BOOLEAN DEFAULT '0',
	pieces SMALLINT DEFAULT NULL,
	appetizercombo tinyint(1),
	createddate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	createdby VARCHAR(20),
	lastupdateddate TIMESTAMP,
	lastupdatebBy VARCHAR(20),
    PRIMARY KEY (menuid),
	CONSTRAINT fk_menu_restaurant FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid) ON DELETE CASCADE,
	CONSTRAINT fk_menu_foodcategory FOREIGN KEY menu(foodcategoryid) REFERENCES foodcategory(foodcategoryid) ON DELETE CASCADE,
	CONSTRAINT fk_menu_food FOREIGN KEY (foodid) REFERENCES food (foodid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS cardtype (
	cardtypeid bigint(11) NOT NULL AUTO_INCREMENT,
	cardname varchar(50) NOT NULL UNIQUE,
	PRIMARY KEY (cardtypeid),
	UNIQUE INDEX(cardname)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS creditcard (
	creditcardid bigint(11) NOT NULL AUTO_INCREMENT,
	personid bigint(11) NOT NULL,
	addressid bigint(11),
	cardtypeid bigint(11),
	creditcardnumber varchar(19) NOT NULL,
	creditcardname varchar(50) NOT NULL,
	expiration date NOT NULL,
	ccv varchar(3),
	PRIMARY KEY (creditcardid),
	UNIQUE(creditcardnumber),
	CONSTRAINT fk_creditcard_person FOREIGN KEY(personid) REFERENCES person(personid) ON DELETE CASCADE,
	CONSTRAINT fk_creditcard_address FOREIGN KEY(addressid) REFERENCES address(addressid) ON DELETE CASCADE,
	CONSTRAINT fk_creditcard_cardtype FOREIGN KEY(cardtypeid) REFERENCES cardtype(cardtypeid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS customerorder (
    customerorderid bigint(11) NOT NULL AUTO_INCREMENT,
    restaurantid bigint(11) NOT NULL,
    agentid bigint(11) NOT NULL,
	personid bigint(11) NOT NULL,
	creditcardid bigint(11),
    orderoption tinyint(1) NOT NULL,
    ordertime timestamp NOT NULL,
	subtotal float NOT NULL,
	tax float,
	grandtotal float NOT NULL,
	tip float,
	status varchar(10),
	note varchar(200),
    PRIMARY KEY (customerorderid),
	CONSTRAINT fk_customerorder_restaurant FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid) ON DELETE CASCADE,
	CONSTRAINT fk_customerorder_agent FOREIGN KEY (agentid) REFERENCES agent (agentid) ON DELETE CASCADE,
	CONSTRAINT fk_customerorder_person FOREIGN KEY (personid) REFERENCES person (personid) ON DELETE CASCADE,
	CONSTRAINT fk_customerorder_creditcard FOREIGN KEY (creditcardid) REFERENCES creditcard (creditcardid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS orderdetail (
	orderdetailid bigint(11) NOT NULL AUTO_INCREMENT,
	customerorderid bigint(11) NOT NULL,
	menuid bigint(11) NOT NULL,
	quantity int NOT NULL,
	note varchar(200),
	PRIMARY KEY (orderdetailid),
	CONSTRAINT fk_orderdetail_menu FOREIGN KEY(menuid) REFERENCES menu(menuid) ON DELETE CASCADE,
	CONSTRAINT fk_orderdetail_customerorder FOREIGN KEY(customerorderid) REFERENCES customerorder(customerorderid) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;
