use restaurant;
start transaction;

load data infile 'newcitychinese-food.csv'
	ignore
	into table food
	character set utf8
	fields terminated by ','
	lines terminated by '\n'
	(foodshortname, foodlongname, cfoodname, description, cdescription)
	;

commit;
