# user database java

pre-requisite: -

	1. jdk kit installed on your system for running java code
	2. Then xampp for running localhost sql server and managing database
	
procedure to execute: -
	
	1. First of all import the .sql file in your localhost database given in "sql database" folder named as "experiments"
	2. Their is the java code name repository where.class and .java file are given.
	3. You can either open cmd, move to the particular folder where you saved above files and than run .class file.
	4. Or you can used any third party software to run the .class file ( like netbeans, eclipse) 
	

table schema :- 

table structure: -
	
			+--------------+--------------+------+-----+---------+----------------+
			| Field        | Type         | Null | Key | Default | Extra          |
			+--------------+--------------+------+-----+---------+----------------+
			| id           | bigint(20)   | NO   | PRI | NULL    | auto_increment |
			| first_name   | varchar(100) | NO   |     | NULL    |                |
			| last_name    | varchar(100) | NO   |     | NULL    |                |
			| city         | varchar(100) | NO   |     | NULL    |                |
			| phone_number | bigint(10)   | NO   |     | NULL    |                |
			+--------------+--------------+------+-----+---------+----------------+
			5 rows in set (0.01 sec)

table data: -

			+----+------------+------------+---------+--------------+
			| id | first_name | last_name  | city    | phone_number |
			+----+------------+------------+---------+--------------+
			|  1 | aman       | sharma     | jaipur  |   1234566789 |
			|  2 | aman       | khandelwal | alwar   |   9956655544 |
			|  3 | piyush     | mittal     | ajmer   |   9988223344 |
			|  4 | vikas      | sharma     | ajmer   |   1234567888 |
			|  5 | arun       | dangi      | meerut  |   1234567890 |
			|  7 | vikas      | sharma     | jodhpur |   1234567890 |
			+----+------------+------------+---------+--------------+
			6 rows in set (0.00 sec)
