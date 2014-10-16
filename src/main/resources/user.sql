drop table if exists user;
create table user (
	id integer generated by default as identity(start with 1) primary key,
	user_name varchar(255) not null,
	first_name varchar(255),
	last_name varchar(255)
);

insert into user (user_name, first_name, last_name) values ('trffd333h', 'rrr', 'Howard');
insert into user (user_name, first_name, last_name) values ('jdf', 'jjj', 'Herfs');
insert into user (user_name, first_name, last_name) values ('jdoe', 'John', 'Doe');

select * from user;
