# HW_DatabaseProject
This is just a homework  
It's a simple test for JDBC using postgreSQL

__The database is created by following sentences: __



`--create`  
drop table team_member;  
create table team_member(  
	stu_id char(13),  
	name varchar(30),  
	birthday Date,  
	hobies varchar(255),  
	primary key (stu_id)   
);  
`-- data`

insert into team_member(stu_id,name,birthday,hobies) Values('2014141221035','黄正跃','1996-06-12','nothing');  
insert into team_member(stu_id,name,birthday,hobies) Values('2016239723234','Dev.test','1906-06-11','nothing'
