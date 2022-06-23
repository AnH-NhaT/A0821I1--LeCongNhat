use quanlysinhvien;
insert into class value (1,'A1','2008-12-20',1);
insert into class value (2,'A2','2008-12-22',1);
insert into class value (3,'B3',current_date(),0);
insert into Student (StudentName,Address,Phone,Status,ClassID) value('Hung','Ha Noi',0912113113,1,1);
insert into Student (StudentName,Address,Status,ClassID) value('Hoa','Hai Phong',1,1);
insert into Student (StudentName,Address,Phone,Status,ClassID) value('Manh','HCM',0123123123,0,2);
insert into Subject 
values(1,'CF',5,1),(2,'C',6,1),(3,'HDJ',5,1),(4,'RDBMS',10,1);
insert into Mark (SubID,bangdiem ,StudentID, Mark, ExamTimes)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);