drop database if exists customer;
create database customer;
use customer;

create table customer(
id int auto_increment,
name varchar(50) not null,
email varchar(50) not null,
nation varchar(50) not null,
primary key(id)
);

insert into customer (name,email,nation) values 
('Anh Nhat','nhat@gmail.com','Viet Nam'),
('Anh Nhat','nhat@gmail.com','Viet Nam'),
('Anh Nhat','nhat@gmail.com','Viet Nam'),
('Anh Nhat','nhat@gmail.com','Viet Nam'),
('Anh Nhat','nhat@gmail.com','Viet Nam'),
('Anh Nhat','nhat@gmail.com','Viet Nam')
;
select * from customer;