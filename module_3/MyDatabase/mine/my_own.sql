
create database if not exists practice;
use practice;

create table if not exists student(
id int primary key auto_increment,
`name` varchar (50),
age int,
check (age>5 and age <100),
class_id int,
`point` int,
check (`point`>=0 and `point` <11)
);

create table if not exists class(
id int auto_increment primary key,
class_name varchar(20) unique,
start_date DATE    NOT NULL,
state    BIT
);

insert into class
(class_name,start_date,state)
values
('a07',current_date(),1),
('a08',current_date()+10,1),
('a09',current_date()+5,1);


insert into student
(`name`,age,class_id,`point`)
values
('hổ con',23,1,8),
('one',13,2,9),
('two',17,2,8),
('three',33,3,6),
('four',19,1,7),
('five',18,2,8),
('six',17,2,9),
('seven',35,3,6),
('eight',20,1,5);

select student.id, student.name, class.class_name
from student join class on student.class_id = class.id;

select class.class_name, count(*)
from student join class on student.class_id = class.id
group by class.class_name;

select * from student;
select * from class;
select count(*) as quantity from student;

drop database practice;
drop table student;
truncate table student;
alter table student drop du_thua;
alter table student add du_thua int default 0;
alter table student modify du_thua varchar (50);
delete from student where id = 9;


select * from student;


-- select * from student where class_id = '1';
-- select * from student where class like '_0%';
-- select avg(`point`) as diem_trung_binh, sum(age) as tong_diem from student;
-- select class, sum(`point`) as tong_diem from student group by class;
-- select id,`name` as `name`,`point` from student where `point` between 6 and 8;
-- select distinct class from student;
-- select * from student where `point` = 8 and class = '2';
-- select * from student where not `point` = 8 and not class = '2';
-- select * from student where `point` = 8 or age = 17;
-- select class, `point` from student where class = '2' and (`point` = 9 or `point` = 8);
-- select * from student order by `point` desc, age asc;
-- update student set `name` = 'updated', age = 99 where id = 1;
-- delete from student where id = 1;
-- select * from student where `point` >= 8 limit 3;
-- select min(age) as min_age, max(`point`) as max_point from student;
-- select * from student where `point` = (select max(`point`) from student);
-- select * from student where `point` = (select min(`point`) from student);
-- select `point`, count(`point`) as quantity from student group by `point` order by `point` desc;
-- select class, avg(`point`) as average from student group by class order by class;
-- select class, sum(`point`) as sum from student group by class order by class;
-- select class, max(`point`) as max from student group by class order by class;
-- select class, min(`point`) as min from student group by class order by class;
-- select class, `point` from student where class = '2';
-- select * from student where `name` like binary '%hổ%';


