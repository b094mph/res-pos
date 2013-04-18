use restaurant;
start transaction;

load data infile 'newcitychinese-foodcategory.csv'
	ignore
	into table foodcategory 
	character set utf8
	fields terminated by ','
	lines terminated by '\n'
	(foodcategoryname, foodcategorycname)
	;

commit;
