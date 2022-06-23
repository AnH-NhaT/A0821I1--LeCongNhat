use quanlysinhvien;
select * from student
where StudentName like 'h%';
select * from class
where month(StartDate) =12;
select * from subject
where Credit between 3 and 5;
update student
set ClassID=2
where StudentName='Hung';
select StudentName,SubName,Mark from student as s
join class as c on s.ClassID=c.ClassID
join subject as sub on c.ClassID=s.ClassID
join mark as m on m.StudentID=s.StudentID
order by  m.Mark desc, s.StudentName asc;

 
