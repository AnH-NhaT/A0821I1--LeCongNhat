-- drop database a0821i1;
create database a0821i1;
use a0821i1;
create table jame_account(
 `account` varchar(50) primary key,
 `password` varchar(20)
);
create table instructor(
id int auto_increment,
`name` varchar(50),
birthday date,
salary int,
primary key(id)
);
create table class_type(
id int primary key auto_increment,
class_type_name varchar(50)
);
create table class(
id int primary key auto_increment,
class_name varchar(50),
class_type_id int,
foreign key (class_type_id) references class_type(id)
);
create table student(
id int primary key auto_increment,
`name` varchar(50),
`gender` boolean,
 birthday date,
`point` int,
 `account` varchar(50),
 class_id int,
 foreign key (`account`) references jame_account(account),
 foreign key (class_id) references class(id)
);
create table class_instructor(
 class_id int,
 instructor_id int,
 primary key (class_id,instructor_id),
 foreign key (class_id) references class(id),
 foreign key (instructor_id) references instructor(id)
);
insert into class_type (class_type_name) values ('full time'), ('part time'),('orther');
select * from class_type;

insert into class (class_name,class_type_id) values ('c1121g1',1), ('c1221g1',1),('a0821i1',2),('a0921i1',2);
select* from class;

insert into jame_account(`account`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');
 select* from jame_account;
 
 insert into instructor(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
 select* from instructor;
 
 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');
 select * from student;
 insert into class_instructor(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);
 select * from class_instructor;
 
select * from class_type;
select* from class;
select* from jame_account;
select* from instructor;
select * from student;
select * from class_instructor;
 
 -- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.--
 -- id, name, class_name
select s.id,s.`name`,c.class_name from student as s
inner join class as c on s.class_id =c.id;

-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học—
select s.id,s.`name`,c.class_name from student as s
left join class as c on s.class_id = c.id;

select s.id,s.`name`,c.class_name, ct.class_type_name from student as s
inner join class as c on s.class_id = c.id
inner join class_type as ct on c.class_type_id = ct.id;

-- 4. Lấy thông tin của các học viên tên 'vo minh hieu' và 'le xuan ky.
select * from student
where `name` ="le xuan ky" or`name` ="vo minh hieu" ;

-- 4. Lấy ra học viên có điểm lớn hơn 5
select * from student
where `point`>5 ;
-- 4. Lấy ra học viên có điểm lớn hơn hoặc bằng  6 và nhỏ hơn hoặc bằng  7
select * from student
where `point` between 6 and 7 ;
-- 5. Lấy ra học viên có họ là nguyen
select * from student
where `name` like 'nguyen%';

-- 6. thông kế số lượng học sinh theo từng loại điểm;
select `point`, count(id) as so_luong from student
group by `point`;

-- 6. thông kế số lượng học sinh theo điểm và điểm phải lớn hơn 4
select `point`, count(id) as so_luong from student
group by `point` having `point`>4;

select `point`, count(id) as so_luong from student
where `point`>4 group by `point`;

-- 6. thông kế số lượng học sinh theo điểm lớn hơn 4 và chỉ hiện thị với số lượng>2 
select `point`, count(id) as so_luong from student
where `point`>4 group by `point` having so_luong >=2;
-- 7. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp tên theo alphabet.

select s.id,s.`name`,c.class_name from student as s
inner join class as c on s.class_id =c.id
order by `name`;
-- 7. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp theo point giảm dần, nếu point bằng nhau
-- thì sắp xếp tên theo alphabet.
 select s.id,s.`name`, s.`point`,c.class_name from student as s
inner join class as c on s.class_id =c.id
order by `point`desc, `name` asc;
 
 -- 7. thông kế số lượng học sinh theo điểm lớn hơn 4 và chỉ hiện thị với số lượng>2 
 -- sắp xếp theo số lượng giảm dần;
select `point`, count(id) as so_luong 
from student
where `point`>4 
group by `point`
having so_luong >=2
order by so_luong desc;


 
 
 
 
 
 
 
 
 
 
 
 
 