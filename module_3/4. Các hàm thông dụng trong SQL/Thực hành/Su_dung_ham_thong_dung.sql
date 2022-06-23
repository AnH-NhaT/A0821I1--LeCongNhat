use quanlysinhvien;

-- Hiển thị số lượng sinh viên từng nơi
select address, count(studentID) as 'So luong'
from student
group by address;

-- tính điểm trung bình của mỗi học viên
-- hiển thị khi điểm trung bình > 15
select s.studentID, s.studentName, AVG(mark)
from student s join mark m
on s.studentID = m.studentID
group by s.studentID
having avg(mark) > 15;

-- hiển thị thông tin học viên có điểm TB lớn nhất
select s.studentID, s.studentName, AVG(mark)
from student s join mark m
on s.studentID = m.studentID
group by s.studentID
having avg(mark) >= ALL(
	select avg(mark) from mark
    group by mark.studentID
)