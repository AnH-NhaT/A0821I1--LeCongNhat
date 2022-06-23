drop database if exists product;
create database product;
use product;

create table category(
id int auto_increment,
name varchar(50),
primary key(id)
);

create table product(
id int auto_increment,
name varchar(50),
price double,
quantity int,
color varchar(100),
description varchar(250),
category_id int,
primary key(id),
date date,
type boolean,
foreign key (category_id) references category(id)
);

insert into category(name) values
('Phone'),('TV'),('Laptop');

insert into product(name,price,quantity,color,description,category_id,date,type) values
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),

('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),
('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0),

('galaxy S22',2000,10,'red','nice',1,'2020-01-01',1),
('Asus b56Qz',1400,15,'white','light gray',3,'2020-08-01',1),
('LG',1000,60,'black','great',2,'2020-04-01',0);


select * from product limit 27,9;
select count(*) as total from product;
select * from category;
select * from product;
select product.* , category.name as category_name from product join category on product.category_id = category.id order by product.id limit 18,9;






