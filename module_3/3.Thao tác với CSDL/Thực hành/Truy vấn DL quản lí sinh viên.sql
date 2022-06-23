use quanlysinhvien;
select * from student;
select * from student where Status =true;
select * from subject where Credit<10 ;
select S.StudentID,S.StudentName,C.ClassName 
from Student S join Class C on S.ClassID=C.ClassID
where C.ClassName='A1';
select S.StudentID, S.StudentName, Sub.SubName,M.Mark
from Student S join Mark M on S.StudentID=M.StudentID join subject Sub on M.SubID=Sub.SubID
where Sub.SubName='CF';
