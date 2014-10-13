CREATE DATABASE market_place
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL ON market_place.* TO 'spring'@'%';

drop table if exists person;

create table person (
	id int NOT NULL AUTO_INCREMENT,
	user_name varchar(255) not null,
	first_name varchar(255),
	last_name varchar(255),
	PRIMARY KEY (id)
);

insert into person (user_name, first_name, last_name) values ('ravi111', 'rav', 'sil');
insert into person (user_name, first_name, last_name) values ('j123', 'Janee', 'doe');
insert into person (user_name, first_name, last_name) values ('j565', 'John', 'Doe');

select * from person;
